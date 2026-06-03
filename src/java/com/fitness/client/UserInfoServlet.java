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

@WebServlet(name = "UserInfoServlet", urlPatterns = {"/UserInfoServlet"})
public class UserInfoServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/HealthFitnessWS/HealthFitnessService?wsdl")
    private HealthFitnessService_Service service;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            // To Capture Inputs
            String name = request.getParameter("name");
            String icNumber = request.getParameter("icNumber");
            String gender = request.getParameter("gender");
            double weight = Double.parseDouble(request.getParameter("weight"));
            double height = Double.parseDouble(request.getParameter("height"));
            
            // To Get Profile HTML from Web Service
            HealthFitnessService port = service.getHealthFitnessServicePort();
            int age = port.determineAge(icNumber);
            double safeDefaultTargetWeight = weight;
            double safeDefaultWeeks = 1.0;
            String userInfoHtml = port.displayUserInfo(name, icNumber, gender, weight, height, safeDefaultTargetWeight, safeDefaultWeeks, age);

            // To Save to Session
            HttpSession session = request.getSession();
            session.setAttribute("userName", name);
            session.setAttribute("userWeight", weight);
            session.setAttribute("userIcNumber", icNumber);
            session.setAttribute("userHeight", height);
            session.setAttribute("userGender", gender); 
            session.setAttribute("userAge", age);
            
            out.println("<!DOCTYPE html><html><head><title>Personal Health & Fitness System</title>");
            out.println("<style>");
            out.println("body { font-family: 'Segoe UI', Tahoma, sans-serif; background-color: #F4F7F6; color: #333; margin: 0; padding: 40px 20px; display: flex; flex-direction: column; align-items: center; }");
            out.println(".container { background-color: white; width: 100%; max-width: 850px; padding: 30px; border-radius: 12px; box-shadow: 0 10px 25px rgba(0,0,0,0.05); }");
            
            // Top Bar & Logout
            out.println(".top-bar { display: flex; justify-content: flex-end; margin-bottom: -20px; }");
            out.println(".btn-logout { background-color: #f1f2f6; color: #e74c3c; padding: 8px 16px; border: 1px solid #e74c3c; border-radius: 6px; cursor: pointer; font-size: 0.9em; font-weight: bold; transition: all 0.3s; }");
            out.println(".btn-logout:hover { background-color: #e74c3c; color: white; }");

            // Header & Profile
            out.println(".header { text-align: center; margin-bottom: 30px; }");
            out.println(".header h2 { color: #2C3E50; margin: 0; font-size: 2.2em; }");
            out.println(".profile-card { background-color: #f8fcf9; border-left: 5px solid #2C3E50; padding: 15px 25px; border-radius: 8px; margin-bottom: 35px; box-shadow: 0 2px 10px rgba(0,0,0,0.02); }");
            out.println(".profile-card ul { list-style: none; padding: 0; margin: 10px 0 0 0; display: grid; grid-template-columns: 1fr 1fr; gap: 12px; font-size: 0.95em; color: #555;}");
            
            // Grid Layout
            out.println(".module-grid { display: grid; grid-template-columns: 1fr 1fr; gap: 25px; }");
            
            // Base Module Card Style
            out.println(".module-card { background-color: #fff; border-radius: 10px; padding: 25px; box-shadow: 0 4px 15px rgba(0,0,0,0.04); display: flex; flex-direction: column; justify-content: space-between; transition: transform 0.2s, box-shadow 0.2s; }");
            out.println(".module-card:hover { transform: translateY(-3px); box-shadow: 0 8px 20px rgba(0,0,0,0.08); }");
            out.println(".module-card h3 { margin: 0 0 10px 0; font-size: 1.2em; display: flex; align-items: center; gap: 8px; }");
            out.println(".module-card p { font-size: 0.9em; color: #777; margin-bottom: 20px; line-height: 1.4; }");
            
            // -- Module Card Color --
            // BMI (Blue)
            out.println(".card-bmi { border-top: 5px solid #3498DB; }");
            out.println(".card-bmi h3 { color: #3498DB; }");
            
            // Body Fat (Purple)
            out.println(".card-fat { border-top: 5px solid #9B59B6; }");
            out.println(".card-fat h3 { color: #9B59B6; }");
            
            // Burn Rate (Orange)
            out.println(".card-burn { border: 2px solid #E67E22; border-top: 6px solid #E67E22; background-color: #fffaf0; }");
            out.println(".card-burn h3 { color: #E67E22; }");
            
            // Deficit (Red)
            out.println(".card-deficit { border-top: 5px solid #E74C3C; }");
            out.println(".card-deficit h3 { color: #E74C3C; }");
            
            // Protein (Green)
            out.println(".card-protein { border: 2px solid #27AE60; border-top: 6px solid #27AE60; background-color: #fafffb; }");
            out.println(".card-protein h3 { color: #27AE60; }");
            
            // Forms & Buttons (FIX: Added input styling to keep things uniformly beautiful)
            out.println("select, input[type='number'] { width: 100%; padding: 12px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 6px; font-size: 0.95em; box-sizing: border-box; }");
            out.println(".btn { color: white; padding: 12px 20px; border: none; border-radius: 6px; cursor: pointer; width: 100%; font-size: 1em; font-weight: bold; transition: opacity 0.3s; margin-top: auto; }");
            out.println(".btn:hover { opacity: 0.85; }");
            out.println(".btn-blue { background-color: #3498DB; }");
<<<<<<< HEAD
=======
            out.println(".btn-purple { background-color: #9B59B6; }"); // Added Purple button style
>>>>>>> origin/MannnBodyFat
            out.println(".btn-orange { background-color: #E67E22; }");
            out.println(".btn-red { background-color: #E74C3C; }");
            out.println(".btn-green { background-color: #27AE60; }");
            out.println(".btn-disabled { background-color: #e0e0e0; color: #888; cursor: not-allowed; }");
            
            // Mobile Responsiveness
            out.println("@media (max-width: 700px) { .module-grid { grid-template-columns: 1fr; } .profile-card ul { grid-template-columns: 1fr; } }");
            out.println("</style></head><body>");
            
            out.println("<div class='container'>");
            
            // Logout Button
            out.println("<div class='top-bar'>");
            out.println("<form action='index.html' style='margin:0;'><button type='submit' class='btn-logout'>Log Out</button></form>");
            out.println("</div>");
            
            // Header
            out.println("<div class='header'><h2>Welcome, " + name + "</h2><p style='color:#7f8c8d;'>Select a health module to calculate</p></div>");
            
            // Profile Box
            out.println("<div class='profile-card'><b style='color:#2C3E50; font-size:1.1em;'>📋 Profile Overview</b>" + userInfoHtml + "</div>");
            
            // START MODULE GRID
            out.println("<div class='module-grid'>");
            
            // BMI Module
            out.println("<div class='module-card card-bmi'>");
            out.println("<div><h3>⚖️ Body Mass Index</h3>");
            out.println("<p>Evaluate your body weight relative to your height to determine your weight category.</p></div>");
            out.println("<form action='BMIServlet' method='POST'>");
            out.println("<input type='submit' class='btn btn-blue' value='Calculate BMI'>");
            out.println("</form>");
            out.println("</div>");

<<<<<<< HEAD
            // Body Fat Module
            out.println("<div class='module-card card-fat'>");
            out.println("<div><h3>🩸 Body Fat Percentage</h3></div>");
            out.println("<button class='btn btn-disabled' disabled>Pending Teammate</button>");
=======
            // Body Fat Module - AKTIFKAN MODUL ANDA DI SINI
            out.println("<div class='module-card card-fat'>");
            out.println("<div><h3>🩸 Body Fat Percentage</h3>");
            out.println("<p>Analyse your body composition to estimate the total percentage of body fat using biometric algorithms.</p></div>");
            out.println("<form action='BodyFatServlet' method='POST'>");
            out.println("<input type='submit' class='btn btn-purple' value='Calculate Body Fat'>");
            out.println("</form>");
>>>>>>> origin/MannnBodyFat
            out.println("</div>");
            
            // Calories Burn Rate Module
            out.println("<div class='module-card card-burn'>");
            out.println("<div><h3>🔥 Calories Burn Rate</h3>");
            out.println("<p>Calculate your daily energy expenditure based on your activity level.</p>");
            out.println("<form action='CaloriesBurnServlet' method='POST'>");
            out.println("<select name='activityMultiplier' required>");
            out.println("<option value='' disabled selected>Select Activity Level...</option>");
            out.println("<option value='1.2'>Sedentary (Little or no exercise)</option>");
            out.println("<option value='1.375'>Lightly Active (1-3 days/week)</option>");
            out.println("<option value='1.55'>Moderately Active (3-5 days/week)</option>");
            out.println("<option value='1.725'>Very Active (6-7 days/week)</option>");
            out.println("</select></div>"); 
            out.println("<input type='submit' class='btn btn-orange' value='Calculate Burn Rate'>");
            out.println("</form>");
            out.println("</div>"); 
            
            // ==========================================
            // FIX: CALORIE DEFICIT MODULE NESTING
            // ==========================================
            out.println("<div class='module-card card-deficit'>");
            out.println("<form action='CalorieDeficitServlet' method='POST' style='height: 100%; display: flex; flex-direction: column; justify-content: space-between;'>");
            out.println("  <div>");
            out.println("    <h3>📉 Calories Deficit</h3>");
            out.println("    <p>Calculate your required daily calorie budget based on your target weight timeline.</p>");
            
            // 1. Activity Level Selection
            out.println("    <select id='activityLevel' name='activityLevel' required>");
            out.println("      <option value='' disabled selected>Select Activity Level...</option>");
            out.println("      <option value='1.2'>Sedentary (No Exercise)</option>");
            out.println("      <option value='1.375'>Lightly Active (1-3 days/wk)</option>");
            out.println("      <option value='1.55'>Moderately Active (3-5 days/wk)</option>");
            out.println("      <option value='1.725'>Very Active (6-7 days/wk)</option>");
            out.println("    </select>");
            
            // 2. Target Weight Input
            out.println("    <input type='number' step='0.1' id='targetWeight' name='targetWeight' placeholder='Target Weight (kg)' min='30' max='300' required>");
            
            // 3. Weeks Duration Input
            out.println("    <input type='number' id='weeks' name='weeks' placeholder='Timeframe (Weeks)' min='1' max='52' required>");
            out.println("  </div>"); // Closes inner content wrapper safely
            
            // 4. Submit Button
            out.println("  <input type='submit' class='btn btn-red' value='Calculate Deficit'>");
            out.println("</form>");
            out.println("</div>"); // Closes .module-card cleanly
            
            // Protein Intake Module
            out.println("<div class='module-card card-protein'>");
            out.println("<div><h3>🥩 Daily Protein Intake</h3>");
            out.println("<p>Calculate your recommended daily protein intake (in grams) based on your fitness goals.</p>");
            out.println("<form action='ProteinIntakeServlet' method='POST'>");
            out.println("<select id='goal' name='goal' required>");
            out.println("<option value='' disabled selected>Select Fitness Goal...</option>");
            out.println("<option value='maintenance'>Maintenance (0.8 g/kg)</option>");
            out.println("<option value='fat_loss'>Fat Loss (1.6 g/kg)</option>");
            out.println("<option value='muscle_gain'>Muscle Gain (1.8 g/kg)</option>");
            out.println("</select></div>");
            out.println("<input type='submit' class='btn btn-green' value='Calculate Intake'>");
            out.println("</form>");
            out.println("</div>");
            
            // END OF MODULE GRID
            out.println("</div>"); 
            
            out.println("</div></body></html>");
            
        } catch (Exception e) {
            out.println("<h2>Error generating dashboard</h2><p>" + e.getMessage() + "</p>");
        }
    }
}