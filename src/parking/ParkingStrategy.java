package src.parking;

import java.util.List;

public interface ParkingStrategy {
    ParkingSlot selectSlot(List<ParkingSlot> slots);
}