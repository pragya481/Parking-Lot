package src.parking;

import src.vehicle.Vehicle;
import src.vehicle.VehicleType;

public class ParkingSlot {
    private final String slotId;
    private final VehicleType type;
    private boolean isOccupied;
    private Vehicle parkedVehicle;
    private final int distanceFromEntrance;
    private final int distanceFromElevator;

    public ParkingSlot(String slotId, VehicleType type, int distanceFromEntrance, int distanceFromElevator) {
        this.slotId = slotId;
        this.type = type;
        this.distanceFromEntrance = distanceFromEntrance;
        this.distanceFromElevator = distanceFromElevator;
        this.isOccupied = false;
    }

    public boolean isAvailable() { return !isOccupied; }
    public void assignVehicle(Vehicle vehicle) { this.parkedVehicle = vehicle; this.isOccupied = true; }
    public void removeVehicle() { this.parkedVehicle = null; this.isOccupied = false; }

    public String getSlotId() { return slotId; }
    public VehicleType getType() { return type; }
    public Vehicle getParkedVehicle() { return parkedVehicle; }
    public int getDistanceFromEntrance() { return distanceFromEntrance; }
    public int getDistanceFromElevator() { return distanceFromElevator; }
}