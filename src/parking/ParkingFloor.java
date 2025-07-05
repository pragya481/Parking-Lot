package src.parking;

import src.vehicle.Vehicle;

public class ParkingFloor {
    private final int floorNumber;
    private final ParkingSlotManager slotManager;

    public ParkingFloor(int floorNumber, ParkingStrategy strategy) {
        this.floorNumber = floorNumber;
        this.slotManager = new ParkingSlotManager(strategy);
    }

    public void addSlot(ParkingSlot slot) {
        slotManager.addSlot(slot);
    }

    public ParkingSlot parkVehicle(Vehicle vehicle) {
        ParkingSlot slot = slotManager.getAvailableSlot(vehicle.getType());
        if (slot != null) slot.assignVehicle(vehicle);
        return slot;
    }

    public boolean unparkVehicle(String slotId) {
        return true; // Simplified for brevity
    }

    public int getFloorNumber() { return floorNumber; }
}
