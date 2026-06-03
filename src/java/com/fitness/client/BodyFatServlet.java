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

@WebServlet(name = "BodyFatServlet", urlPatterns = {"/BodyFatServlet"})
public class BodyFatServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/HealthFitnessWS/HealthFitnessService?wsdl")
    private HealthFitnessService_Service service;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            // Dapatkan data daripada Session yang disimpan di UserInfoServlet
            HttpSession session = request.getSession();
            Double weight = (Double) session.getAttribute("userWeight");
            Double heightCm = (Double) session.getAttribute("userHeight");
            Integer age = (Integer) session.getAttribute("userAge");
            String gender = (String) session.getAttribute("userGender");
            String name = (String) session.getAttribute("userName");
            
            // Semak jika session kosong (contoh: user terus buka URL tanpa login)
            if (weight == null || heightCm == null || age == null || gender == null) {
                response.sendRedirect("index.html");
                return;
            }

            // Tukar tinggi dari sentimeter (cm) kepada meter (m) untuk formula BMI dalam WS
            double heightInMeters = heightCm / 100.0;
            
            // Panggil Web Service
            HealthFitnessService port = service.getHealthFitnessServicePort();
            double bodyFatResult = port.bodyFatPercentage(heightInMeters, weight, age, gender);
            
            // Buat UI untuk result
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Body Fat Result</title>");
            out.println("<style>");
            out.println("body { font-family: 'Segoe UI', Tahoma, sans-serif; background-color: #F4F7F6; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }");
            out.println(".result-card { background: white; padding: 40px; border-radius: 12px; box-shadow: 0 10px 25px rgba(0,0,0,0.1); text-align: center; max-width: 400px; width: 100%; border-top: 6px solid #9B59B6; }");
            out.println(".result-card h2 { color: #2C3E50; margin-bottom: 5px; }");
            out.println(".fat-value { font-size: 3.5em; font-weight: bold; color: #9B59B6; margin: 20px 0; }");
            out.println(".details { color: #7f8c8d; font-size: 0.95em; margin-bottom: 30px; line-height: 1.6; }");
            out.println(".btn-back { background-color: #34495E; color: white; text-decoration: none; padding: 12px 25px; border-radius: 6px; font-weight: bold; transition: background 0.3s; display: inline-block; }");
            out.println(".btn-back:hover { background-color: #2C3E50; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<div class='result-card'>");
            out.println("<h2>Body Fat Percentage</h2>");
            out.println("<div class='fat-value'>" + bodyFatResult + "%</div>");
            out.println("<div class='details'>");
            out.println("Hi <strong>" + name + "</strong>!<br>");
            out.println("Based on your profile (Age: " + age + ", Gender: " + gender + "), this is your estimated body fat percentage.");
            out.println("</div>");
            
            // Butang kembali ke dashboard
            // Oleh kerana UserInfoServlet memerlukan parameter untuk render, 
            // lebih selamat kita buat form terselindung (hidden) untuk POST semula data ke dashboard
            out.println("<form action='UserInfoServlet' method='POST'>");
            out.println("<input type='hidden' name='name' value='" + name + "'>");
            out.println("<input type='hidden' name='icNumber' value='" + session.getAttribute("userIcNumber") + "'>");
            out.println("<input type='hidden' name='gender' value='" + gender + "'>");
            out.println("<input type='hidden' name='weight' value='" + weight + "'>");
            out.println("<input type='hidden' name='height' value='" + heightCm + "'>");
            out.println("<button type='submit' class='btn-back' style='border:none; cursor:pointer;'>Back to Dashboard</button>");
            out.println("</form>");
            
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
        } catch (Exception e) {
            out.println("<h2>Error calculating Body Fat</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
            out.println("<a href='index.html'>Return to Login</a>");
        }
    }
}