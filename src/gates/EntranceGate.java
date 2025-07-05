package src.gates;

import java.util.UUID;

import src.parking.ParkingSlot;
import src.parking.Ticket;
import src.vehicle.Vehicle;

public class EntranceGate extends Gate {
    public EntranceGate(String gateId) { super(gateId); }
    public Ticket generateTicket(Vehicle vehicle, ParkingSlot slot, int floorNumber) {
        return new Ticket(UUID.randomUUID().toString(), slot.getSlotId(), floorNumber, vehicle, gateId);
    }
}
