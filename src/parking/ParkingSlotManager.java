package src.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.vehicle.VehicleType;

public class ParkingSlotManager {
    private final Map<VehicleType, List<ParkingSlot>> slotMap = new HashMap<>();
    private final ParkingStrategy strategy;

    public ParkingSlotManager(ParkingStrategy strategy) {
        this.strategy = strategy;
    }

    public void addSlot(ParkingSlot slot) {
        slotMap.putIfAbsent(slot.getType(), new ArrayList<>());
        slotMap.get(slot.getType()).add(slot);
    }

    public ParkingSlot getAvailableSlot(VehicleType type) {
        return strategy.selectSlot(slotMap.getOrDefault(type, new ArrayList<>()));
    }
}
