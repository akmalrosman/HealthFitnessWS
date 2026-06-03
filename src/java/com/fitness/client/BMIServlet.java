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

@WebServlet(name = "BMIServlet", urlPatterns = {"/BMIServlet"})
public class BMIServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/HealthFitnessWS/HealthFitnessService?wsdl")
    private HealthFitnessService_Service service;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            // 1. Get Data from Session (NO NEED FOR HTML INPUTS!)
            HttpSession session = request.getSession();
            Double weight = (Double) session.getAttribute("userWeight");
            Double height = (Double) session.getAttribute("userHeight");
            String name = (String) session.getAttribute("userName");
            
            if (weight == null || height == null) {
                out.println("<script>alert('Session expired. Please login again.'); window.location.href='index.html';</script>");
                return;
            }
            
            // 2. Invoke SOAP Web Service
            HealthFitnessService port = service.getHealthFitnessServicePort();
            double bmiResult = port.calculateBMI(weight, height);
            
            // 3. Determine the BMI Category & Color Alert
            String category = "";
            String alertColor = "";
            
            if (bmiResult < 18.5) {
                category = "Underweight";
                alertColor = "#3498DB"; // Blue
            } else if (bmiResult >= 18.5 && bmiResult < 25) {
                category = "Normal Weight";
                alertColor = "#2ECC71"; // Green
            } else if (bmiResult >= 25 && bmiResult < 30) {
                category = "Overweight";
                alertColor = "#F1C40F"; // Yellow
            } else {
                category = "Obese";
                alertColor = "#E74C3C"; // Red
            }
            
            // 4. Print Blue-Themed UI
            out.println("<!DOCTYPE html><html><head><title>BMI Result</title>");
            out.println("<style>");
            out.println("body { font-family: 'Segoe UI', Tahoma, sans-serif; background-color: #F4F7F6; color: #333; margin: 0; padding: 40px 20px; display: flex; justify-content: center; }");
            out.println(".container { background-color: white; width: 100%; max-width: 500px; padding: 40px; border-radius: 12px; box-shadow: 0 10px 25px rgba(0,0,0,0.05); text-align: center; }");
            out.println(".result-box { background-color: #ebf5fb; border: 2px solid #3498DB; border-radius: 10px; padding: 30px; margin: 25px 0; }");
            out.println(".number { font-size: 3.5em; font-weight: bold; color: #3498DB; margin: 0; }");
            
            // Dynamic Status Badge CSS
            out.println(".status-badge { display: inline-block; padding: 8px 16px; color: white; background-color: " + alertColor + "; border-radius: 20px; font-weight: bold; margin-top: 15px; font-size: 1.1em; }");
            
            out.println(".btn { background-color: #2C3E50; color: white; padding: 12px 20px; border: none; border-radius: 6px; cursor: pointer; width: 100%; font-size: 1em; font-weight: bold; margin-top: 20px; }");
            out.println(".btn:hover { background-color: #1a252f; }");
            out.println("</style></head><body>");
            
            out.println("<div class='container'>");
            out.println("<h2 style='color:#2C3E50; margin-top:0;'>⚖️ Body Mass Index</h2>");
            out.println("<p style='color:#666;'>Calculated for " + name + " using profile data (" + weight + "kg, " + height + "cm).</p>");
            
            out.println("<div class='result-box'>");
            out.println("<p style='margin:0 0 10px 0; font-weight:bold; color:#3498DB;'>Your BMI Score:</p>");
            out.println("<p class='number'>" + bmiResult + "</p>");
            out.println("<div class='status-badge'>" + category + "</div>");
            out.println("</div>");
            
            out.println("<ul style='text-align:left; color:#555; font-size:0.9em; margin-bottom:20px; background: #fafafa; padding: 15px 15px 15px 35px; border-radius: 8px;'>");
            out.println("<li><strong>Underweight:</strong> Below 18.5</li>");
            out.println("<li><strong>Normal Weight:</strong> 18.5 - 24.9</li>");
            out.println("<li><strong>Overweight:</strong> 25.0 - 29.9</li>");
            out.println("<li><strong>Obese:</strong> 30.0 and above</li>");
            out.println("</ul>");
            
            out.println("<button class='btn' onclick='window.history.back()'>← Back to Dashboard</button>");
            out.println("</div></body></html>");
            
        } catch (Exception e) {
            out.println("<h2 style='color: red;'>System Error</h2><p>" + e.getMessage() + "</p><button onclick='window.history.back()'>Go Back</button>");
        }
    }
}