package src.parking;

import java.util.Comparator;
import java.util.List;

public class NearestToEntranceStrategy implements ParkingStrategy {
    public ParkingSlot selectSlot(List<ParkingSlot> slots) {
        return slots.stream().filter(ParkingSlot::isAvailable)
            .min(Comparator.comparingInt(ParkingSlot::getDistanceFromEntrance)).orElse(null);
    }
}