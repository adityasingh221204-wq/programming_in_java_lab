package com.ecodrive.service;

import com.ecodrive.model.Vehicle;
import com.ecodrive.exception.InvalidLoadException;

public class CarbonService {

    /**
     * Calculates emissions based on distance and load.
     * Load Factor is simplified as: (Added Load / Base Weight) * 0.5
     */
    public double calculateEmissions(Vehicle vehicle, double distance, double addedLoad) throws InvalidLoadException {
        if (addedLoad < 0) {
            throw new InvalidLoadException("Load cannot be negative.");
        }

        double ef = vehicle.getFuelType().getEmissionFactor();
        double loadFactor = (addedLoad / vehicle.getWeightKg()) * 0.5;

        // The Formula: E = (D * EF) * (1 + LoadFactor)
        return (distance * ef) * (1 + loadFactor);
    }

    public String generateGhostLog(Vehicle vehicle, double distance, double addedLoad) {
        double ef = vehicle.getFuelType().getEmissionFactor();
        double lf = (addedLoad / vehicle.getWeightKg()) * 0.5;

        return String.format(
                "[LOG] Base EF: %.2f | Dist: %.1f km | Load Factor: %.2f | Formula: (%.1f * %.2f) * (1 + %.2f)",
                ef, distance, lf, distance, ef, lf
        );
    }
}