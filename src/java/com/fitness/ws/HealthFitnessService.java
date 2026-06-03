/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.fitness.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceException;

/**
 *
 * @author Khairul
 */
@WebService(serviceName = "HealthFitnessService")
public class HealthFitnessService {

    // Calculate User Age
    @WebMethod(operationName = "determineAge")
    public int determineAge(@WebParam(name = "icNumber") String icNumber) {
        if (icNumber == null || icNumber.length() < 6) {
            throw new WebServiceException("SOAP FAULT: Invalid IC Number. Must be at least 6 digits.");
        }
        
        try {
            String yearStr = icNumber.substring(0, 2);
            int yy = Integer.parseInt(yearStr);
            
            int birthYear = (yy > 26) ? (1900 + yy) : (2000 + yy);
            
            return 2026 - birthYear;
            
        } catch (NumberFormatException e) {
            throw new WebServiceException("SOAP FAULT: IC Number must start with valid YYMMDD format.");
        }
    }

    // Display User Info - UPDATED WITH ALL 8 PARAMETERS TO MATCH USERINFOSERVLET
    @WebMethod(operationName = "displayUserInfo")
    public String displayUserInfo(
            @WebParam(name = "name") String name,
            @WebParam(name = "icNumber") String icNumber,
            @WebParam(name = "gender") String gender,
            @WebParam(name = "weight") double weight,
            @WebParam(name = "height") double height,
            @WebParam(name = "activityLevel") double activityLevel,
            @WebParam(name = "targetWeight") double targetWeight,
            @WebParam(name = "weeks") int weeks) {
        
        int age = determineAge(icNumber);
        // Inside HealthFitnessService.java (Backend)
        if (targetWeight > 0 && weeks > 0) {
        // Only call validation/calculation if values are provided
            String calorieDetails = calculateCaloriesDeficit(icNumber, gender, weight, height, activityLevel, targetWeight, weeks);
        }

        StringBuilder info = new StringBuilder();
        info.append("<ul>");
        info.append("<li><strong>Name:</strong> ").append(name).append("</li>");
        info.append("<li><strong>IC Number:</strong> ").append(icNumber).append("</li>");
        info.append("<li><strong>Age:</strong> ").append(age).append(" years old</li>");
        info.append("<li><strong>Gender:</strong> ").append(gender).append("</li>");
        info.append("<li><strong>Weight:</strong> ").append(weight).append(" kg</li>");
        info.append("<li><strong>Height:</strong> ").append(height).append(" cm</li>");
        info.append("</ul>");
        
        return info.toString();
    }

<<<<<<< HEAD
=======
    /**
     * Body Fat Percentage 
     */
    @WebMethod(operationName = "bodyFatPercentage")
    public double bodyFatPercentage(
            @WebParam(name = "height") double height, 
            @WebParam(name = "weight") double weight,
            @WebParam(name = "age") int age,
            @WebParam(name = "gender") String gender) {
        
        if (height <= 0) {
            throw new WebServiceException("SOAP FAULT: Height must be greater than 0.");
        }

        double bmii = weight / (height * height);
        double bodyFat = 0.0;

        if (gender.equalsIgnoreCase("male")) {
            bodyFat = (1.20 * bmii) + (0.23 * age) - 16.2;
        } else if (gender.equalsIgnoreCase("female")) {
            bodyFat = (1.20 * bmii) + (0.23 * age) - 5.4;
        } else {
            throw new WebServiceException("SOAP FAULT: Invalid gender. Choose 'male' or 'female'.");
        }
        
        return Math.round(bodyFat * 100.0) / 100.0;
    }
>>>>>>> origin/MannnBodyFat

    /**
     * Body Calories Burn Rate
     */
    @WebMethod(operationName = "calculateCaloriesBurnRate")
    public double calculateCaloriesBurnRate(
            @WebParam(name = "weight") double weight, 
            @WebParam(name = "height") double height, 
            @WebParam(name = "age") int age, 
            @WebParam(name = "gender") String gender, 
            @WebParam(name = "activityMultiplier") double activityMultiplier) {
        
        // Validation
        if (weight <= 0 || height <= 0 || age <= 0) {
            throw new WebServiceException("SOAP FAULT: Invalid physical attributes.");
        }
        
        // Calculate Basal Metabolic Rate (BMR) using Mifflin-St Jeor Equation
        double bmr;
        if ("Male".equalsIgnoreCase(gender)) {
            bmr = (10 * weight) + (6.25 * height) - (5 * age) + 5;
        } else {
            bmr = (10 * weight) + (6.25 * height) - (5 * age) - 161;
        }
        
        // Calculate Total Daily Energy Expenditure (TDEE)
        double tdee = bmr * activityMultiplier;
        
        return Math.round(tdee * 100.0) / 100.0;
    }

    // Module: Calorie Deficit Engine (Adam + Paan) - Updated for Target Weight
    @WebMethod(operationName = "calculateCaloriesDeficit")
    public String calculateCaloriesDeficit(
            @WebParam(name = "icNumber") String icNumber,
            @WebParam(name = "gender") String gender,
            @WebParam(name = "currentWeight") double currentWeight,
            @WebParam(name = "height") double height,
            @WebParam(name = "activityLevel") double activityFactor, 
            @WebParam(name = "targetWeight") double targetWeight,
            @WebParam(name = "weeks") int weeks) {
        
        if (currentWeight <= 0 || height <= 0 || targetWeight <= 0 || weeks <= 0) {
            throw new WebServiceException("SOAP FAULT: Measurements and timeframe must be greater than zero.");
        }
        
        int age = determineAge(icNumber);
        
        // 1. Calculate BMR (Current Baseline)
        double bmr;
        if (gender != null && gender.equalsIgnoreCase("male")) {
            bmr = (10 * currentWeight) + (6.25 * height) - (5 * age) + 5;
        } else {
            bmr = (10 * currentWeight) + (6.25 * height) - (5 * age) - 161;
        }

        // 2. Calculate Maintenance Energy (TDEE)
        double tdee = bmr * activityFactor;
        
        // 3. Dynamic Target Weight Calculation Logic
        double weightDifference = currentWeight - targetWeight;
        
        // If user is already at their target weight
        if (Math.abs(weightDifference) < 0.1) {
            return "You are already at your target weight! Maintain your current habits with a daily intake of " 
                    + String.format("%.0f", tdee) + " kcal.";
        }
        
        // 7700 kcal per 1kg of body mass change
        double totalCalorieRequirement = weightDifference * 7700.0;
        double dailyDeficitSurplus = (totalCalorieRequirement / weeks) / 7.0;
        
        // 4. Safety Guardrails (Sustainable weekly rate validation)
        double weeklyRate = Math.abs(weightDifference) / weeks;
        if (weeklyRate > 1.0) {
            return "Warning: Aggressive timeline! Losing/gaining " + String.format("%.2f", weeklyRate) 
                    + " kg per week is unsafe. Please increase the number of weeks for a target pace of ≤ 1 kg/week.";
        }

        double recommendedIntake = tdee - dailyDeficitSurplus;

        if (recommendedIntake < 1200) {
            return "Warning: Your target weight goal requires a daily intake of " + String.format("%.0f", recommendedIntake) + 
                   " kcal. Consuming less than 1200 kcal is dangerous. Please extend your timeline (weeks).";
        }

        String goalType = (weightDifference > 0) ? "lose" : "gain";
        return "Your current TDEE is: " + String.format("%.0f", tdee) + " kcal. To " + goalType + " " 
                + String.format("%.1f", Math.abs(weightDifference)) + " kg in " + weeks + " weeks, aim for a daily deficit/surplus of " 
                + String.format("%.0f", Math.abs(dailyDeficitSurplus)) + " kcal. <strong>Recommended Daily Intake: " 
                + String.format("%.0f", recommendedIntake) + " kcal</strong>.";
    }

    /**
     * Protein Intake Daily
     */
    @WebMethod(operationName = "calculateProteinIntake")
    public double calculateProteinIntake(
            @WebParam(name = "weightKg") double weightKg, 
            @WebParam(name = "goal") String goal) {
        
        if (weightKg <= 0) {
            throw new WebServiceException("SOAP FAULT: Weight must be greater than 0 kg.");
        }
        
        // Protein Factor based on goal
        double proteinFactor = 0.0;
        switch (goal.toLowerCase()) {
            case "maintenance":
                proteinFactor = 0.8;
                break;
            case "fat_loss":
                proteinFactor = 1.6;
                break;
            case "muscle_gain":
                proteinFactor = 1.8;
                break;
            default:
                throw new WebServiceException("SOAP FAULT: Invalid goal. Choose maintenance, fat_loss, or muscle_gain.");
        }
        
        // Body Weight X Protein Factor
        double proteinIntake = weightKg * proteinFactor;
        
        return Math.round(proteinIntake * 100.0) / 100.0; 
    }
}