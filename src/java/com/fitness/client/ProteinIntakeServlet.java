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

@WebServlet(name = "ProteinIntakeServlet", urlPatterns = {"/ProteinIntakeServlet"})
public class ProteinIntakeServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/HealthFitnessWS/HealthFitnessService?wsdl")
    private HealthFitnessService_Service service;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            HttpSession session = request.getSession();
            Double weight = (Double) session.getAttribute("userWeight");
            String name = (String) session.getAttribute("userName");
            
            if (weight == null) {
                out.println("<script>alert('Session expired. Please login again.'); window.location.href='index.html';</script>");
                return;
            }
            
            String goal = request.getParameter("goal");
            
            HealthFitnessService port = service.getHealthFitnessServicePort();
            double dailyProteinGrams = port.calculateProteinIntake(weight, goal);
            
            out.println("<!DOCTYPE html><html><head><title>Protein Result</title>");
            out.println("<style>");
            out.println("body { font-family: 'Segoe UI', Tahoma, sans-serif; background-color: #F4F7F6; color: #333; margin: 0; padding: 40px 20px; display: flex; justify-content: center; }");
            out.println(".container { background-color: white; width: 100%; max-width: 500px; padding: 40px; border-radius: 12px; box-shadow: 0 10px 25px rgba(0,0,0,0.05); text-align: center; }");
            out.println(".result-box { background-color: #e8f5e9; border: 2px solid #27AE60; border-radius: 10px; padding: 30px; margin: 25px 0; }");
            out.println(".number { font-size: 3em; font-weight: bold; color: #27AE60; margin: 0; }");
            out.println(".unit { font-size: 1.2em; color: #555; }");
            out.println(".btn { background-color: #2C3E50; color: white; padding: 12px 20px; border: none; border-radius: 6px; cursor: pointer; width: 100%; font-size: 1em; font-weight: bold; }");
            out.println(".btn:hover { background-color: #1a252f; }");
            out.println("</style></head><body>");
            
            out.println("<div class='container'>");
            out.println("<h2 style='color:#2C3E50; margin-top:0;'>Protein Intake Goal</h2>");
            out.println("<p style='color:#666;'>Calculated for " + name + " (" + weight + "kg) for " + goal.replace("_", " ") + "</p>");
            
            out.println("<div class='result-box'>");
            out.println("<p style='margin:0 0 10px 0; font-weight:bold; color:#27AE60;'>Your Target:</p>");
            out.println("<p class='number'>" + dailyProteinGrams + "</p>");
            out.println("<p class='unit'>grams / day</p>");
            out.println("</div>");
            
            out.println("<ul style='text-align:left; color:#555; font-size:0.9em; margin-bottom:30px;'>");
            out.println("<li>Supports muscle growth and recovery</li>");
            out.println("<li>Maintains proper nutritional balance</li>");
            out.println("</ul>");
            
            out.println("<button class='btn' onclick='window.history.back()'>← Back to Dashboard</button>");
            out.println("</div></body></html>");
            
        } catch (Exception e) {
            out.println("<h2 style='color: red;'>System Error</h2><p>" + e.getMessage() + "</p><button onclick='window.history.back()'>Go Back</button>");
        }
    }
}