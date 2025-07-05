package src.parking;
import java.util.Comparator;
import java.util.List;

public class NearestToElevatorStrategy implements ParkingStrategy {
    public ParkingSlot selectSlot(List<ParkingSlot> slots) {
        return slots.stream().filter(ParkingSlot::isAvailable)
            .min(Comparator.comparingInt(ParkingSlot::getDistanceFromElevator)).orElse(null);
    }
}