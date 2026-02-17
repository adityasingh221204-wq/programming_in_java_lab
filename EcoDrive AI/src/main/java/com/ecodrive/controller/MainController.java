package com.ecodrive.controller;

import com.ecodrive.ai.EcoCoach;
import com.ecodrive.exception.InvalidLoadException;
import com.ecodrive.model.Vehicle;
import com.ecodrive.service.CarbonService;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {
    @FXML private TextField distanceField;
    @FXML private TextField loadField;
    @FXML private Label resultLabel;
    @FXML private Label coachLabel;
    @FXML private TextArea ghostLogArea;
    @FXML private Button calculateButton;

    private final CarbonService carbonService = new CarbonService();
    private final EcoCoach ecoCoach = new EcoCoach();

    @FXML
    public void onCalculateClick() {
        try {
            // 1. Instant Physics Calculation
            double dist = Double.parseDouble(distanceField.getText());
            double load = Double.parseDouble(loadField.getText());
            Vehicle car = new Vehicle("Standard Sedan", Vehicle.FuelType.PETROL, 1500.0);

            double result = carbonService.calculateEmissions(car, dist, load);
            resultLabel.setText(String.format("%.2f KG CO2", result));
            ghostLogArea.appendText(carbonService.generateGhostLog(car, dist, load) + "\n");

            // 2. Async AI Analysis (UI won't freeze)
            runAiCoachTask(dist, load);

        } catch (NumberFormatException | InvalidLoadException e) {
            resultLabel.setText("Invalid Input");
        }
    }

    private void runAiCoachTask(double dist, double load) {
        calculateButton.setDisable(true);
        calculateButton.setText("ANALYZING...");
        coachLabel.setText("Consulting Gemini AI...");

        Task<String> aiTask = new Task<>() {
            @Override
            protected String call() {
                return ecoCoach.getEcoAdvice(dist, load, "Petrol");
            }
        };

        aiTask.setOnSucceeded(e -> {
            coachLabel.setText(aiTask.getValue());
            resetButton();
        });

        aiTask.setOnFailed(e -> {
            coachLabel.setText("Eco-Coach is currently offline.");
            resetButton();
        });

        new Thread(aiTask).start();
    }

    private void resetButton() {
        calculateButton.setDisable(false);
        calculateButton.setText("ANALYZE DATA");
    }
}