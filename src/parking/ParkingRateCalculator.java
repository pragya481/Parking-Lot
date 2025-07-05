package src.parking;

import java.time.Duration;

import src.vehicle.VehicleType;

public class ParkingRateCalculator {
    public double calculateFee(VehicleType type, Duration duration) {
        long hours = Math.max(1, duration.toHours());
        return switch (type) {
            case CAR -> hours * 20;
            case BIKE -> hours * 10;
            case TRUCK -> hours * 50;
        };
    }
}
