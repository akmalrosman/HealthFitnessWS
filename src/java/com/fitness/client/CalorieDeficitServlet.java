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

@WebServlet(name = "CalorieDeficitServlet", urlPatterns = {"/CalorieDeficitServlet"})
public class CalorieDeficitServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/HealthFitnessWS/HealthFitnessService?wsdl")
    private HealthFitnessService_Service service;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            HttpSession session = request.getSession();
            String name = (String) session.getAttribute("userName");
            String icNumber = (String) session.getAttribute("userIcNumber");
            String gender = (String) session.getAttribute("userGender");
            Double currentWeight = (Double) session.getAttribute("userWeight");
            Double height = (Double) session.getAttribute("userHeight");
            
            if (icNumber == null || currentWeight == null || height == null) {
                out.println("<script>alert('Session expired or missing profile data. Please login again.'); window.location.href='index.html';</script>");
                return;
            }
            
            // Extract the parameters from UserInfoServlet's updated form
            double activityLevel = Double.parseDouble(request.getParameter("activityLevel"));
            double targetWeight = Double.parseDouble(request.getParameter("targetWeight"));
            int weeks = Integer.parseInt(request.getParameter("weeks"));
            
            HealthFitnessService port = service.getHealthFitnessServicePort();
            
            // Invoke Updated Proxy Method
            String deficitResult = port.calculateCaloriesDeficit(icNumber, gender, currentWeight, height, activityLevel, targetWeight, weeks);
            
            // Render UI Output
            out.println("<!DOCTYPE html><html><head><title>Calorie Deficit Result</title>");
            out.println("<style>");
            out.println("body { font-family: 'Segoe UI', Tahoma, sans-serif; background-color: #F4F7F6; color: #333; margin: 0; padding: 40px 20px; display: flex; justify-content: center; }");
            out.println(".container { background-color: white; width: 100%; max-width: 550px; padding: 40px; border-radius: 12px; box-shadow: 0 10px 25px rgba(0,0,0,0.05); text-align: center; }");
            
            if (deficitResult.startsWith("Warning")) {
                out.println(".result-box { background-color: #fff3cd; border: 2px solid #ffc107; border-radius: 10px; padding: 25px; margin: 25px 0; color: #856404; text-align: left; }");
            } else {
                out.println(".result-box { background-color: #e3f2fd; border: 2px solid #2196F3; border-radius: 10px; padding: 25px; margin: 25px 0; color: #0d47a1; text-align: left; font-size: 1.1em; line-height: 1.6; }");
            }
            
            out.println(".btn { background-color: #2C3E50; color: white; padding: 12px 20px; border: none; border-radius: 6px; cursor: pointer; width: 100%; font-size: 1em; font-weight: bold; }");
            out.println(".btn:hover { background-color: #1a252f; }");
            out.println("</style></head><body>");
            out.println("<div class='container'>");
            out.println("<h2 style='color:#2C3E50; margin-top:0;'>Calorie Budget Analysis</h2>");
            out.println("<p style='color:#666;'>Calculated for <strong>" + name + "</strong></p>");
            out.println("<div class='result-box'>" + deficitResult + "</div>");
            out.println("<ul style='text-align:left; color:#555; font-size:0.9em; margin-bottom:30px;'>");
            out.println("<li>Safe sustainable body recomposition targets range between 0.5 to 1.0 kg max loss per week.</li>");
            out.println("<li>Stay hydrated and track adjustments over time as your active mass drops.</li>");
            out.println("</ul>");
            out.println("<button class='btn' onclick='window.history.back()'>← Back to Dashboard</button>");
            out.println("</div></body></html>");
            
        } catch (NumberFormatException e) {
            out.println("<h2 style='color: red;'>Input Error</h2><p>Please enter valid numerical figures for weight metrics and week counts.</p><button onclick='window.history.back()'>Go Back</button>");
        } catch (Exception e) {
            out.println("<h2 style='color: red;'>System Error</h2><p>" + e.getMessage() + "</p><button onclick='window.history.back()'>Go Back</button>");
        }
    } 
}