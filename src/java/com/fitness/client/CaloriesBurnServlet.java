package com.fitness.client;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;

import com.fitness.client.stub.HealthFitnessService_Service;
import com.fitness.client.stub.HealthFitnessService;

@WebServlet(name = "CaloriesBurnServlet", urlPatterns = {"/CaloriesBurnServlet"})
public class CaloriesBurnServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/HealthFitnessWS/HealthFitnessService?wsdl")
    private HealthFitnessService_Service service;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            // 1. Get Data from Session
            HttpSession session = request.getSession();
            Double weight = (Double) session.getAttribute("userWeight");
            Double height = (Double) session.getAttribute("userHeight");
            Integer age = (Integer) session.getAttribute("userAge");
            String gender = (String) session.getAttribute("userGender");
            String name = (String) session.getAttribute("userName");
            
            if (weight == null || age == null) {
                out.println("<script>alert('Session expired. Please login again.'); window.location.href='index.html';</script>");
                return;
            }
            
            // 2. Get Activity Level from HTML Form
            double activityMultiplier = Double.parseDouble(request.getParameter("activityMultiplier"));
            
            // 3. Invoke SOAP Web Service
            HealthFitnessService port = service.getHealthFitnessServicePort();
            double burnRate = port.calculateCaloriesBurnRate(weight, height, age, gender, activityMultiplier);
            
            // 4. Print Orange-Themed UI
            out.println("<!DOCTYPE html><html><head><title>Calories Burn Rate Result</title>");
            out.println("<style>");
            out.println("body { font-family: 'Segoe UI', Tahoma, sans-serif; background-color: #F4F7F6; color: #333; margin: 0; padding: 40px 20px; display: flex; justify-content: center; }");
            out.println(".container { background-color: white; width: 100%; max-width: 500px; padding: 40px; border-radius: 12px; box-shadow: 0 10px 25px rgba(0,0,0,0.05); text-align: center; }");
            out.println(".result-box { background-color: #fff4e6; border: 2px solid #E67E22; border-radius: 10px; padding: 30px; margin: 25px 0; }");
            out.println(".number { font-size: 3em; font-weight: bold; color: #E67E22; margin: 0; }");
            out.println(".unit { font-size: 1.2em; color: #555; }");
            out.println(".btn { background-color: #2C3E50; color: white; padding: 12px 20px; border: none; border-radius: 6px; cursor: pointer; width: 100%; font-size: 1em; font-weight: bold; }");
            out.println(".btn:hover { background-color: #1a252f; }");
            out.println("</style></head><body>");
            
            out.println("<div class='container'>");
            out.println("<h2 style='color:#2C3E50; margin-top:0;'>🔥 Total Daily Energy Expenditure</h2>");
            out.println("<p style='color:#666;'>Calculated for " + name + " using the Mifflin-St Jeor Equation.</p>");
            
            out.println("<div class='result-box'>");
            out.println("<p style='margin:0 0 10px 0; font-weight:bold; color:#E67E22;'>You burn approximately:</p>");
            out.println("<p class='number'>" + burnRate + "</p>");
            out.println("<p class='unit'>kcals / day</p>");
            out.println("</div>");
            
            out.println("<p style='text-align:left; color:#555; font-size:0.9em; margin-bottom:30px;'>");
            out.println("<strong>Note:</strong> This is the number of calories you need to consume daily to <em>maintain</em> your current weight of " + weight + " kg.");
            out.println("</p>");
            
            out.println("<button class='btn' onclick='window.history.back()'>← Back to Dashboard</button>");
            out.println("</div></body></html>");
            
        } catch (Exception e) {
            out.println("<h2 style='color: red;'>System Error</h2><p>" + e.getMessage() + "</p><button onclick='window.history.back()'>Go Back</button>");
        }
    }
}