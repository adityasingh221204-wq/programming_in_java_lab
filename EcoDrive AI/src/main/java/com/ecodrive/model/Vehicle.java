package com.ecodrive.model;

public class Vehicle {
    private String modelName;
    private FuelType fuelType;
    private double weightKg; // Base weight of the vehicle

    public enum FuelType {
        PETROL(2.31),   // kg CO2 per Liter
        DIESEL(2.68),   // kg CO2 per Liter
        ELECTRIC(0.05); // kg CO2 per kWh (Average Grid Intensity)

        private final double emissionFactor;

        FuelType(double emissionFactor) {
            this.emissionFactor = emissionFactor;
        }

        public double getEmissionFactor() {
            return emissionFactor;
        }
    }

    public Vehicle(String modelName, FuelType fuelType, double weightKg) {
        this.modelName = modelName;
        this.fuelType = fuelType;
        this.weightKg = weightKg;
    }

    // Getters
    public FuelType getFuelType() { return fuelType; }
    public double getWeightKg() { return weightKg; }
}