package src.parking;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.gates.EntranceGate;
import src.gates.ExitGate;
import src.vehicle.Vehicle;

public class ParkingLot {
    private final List<ParkingFloor> floors = new ArrayList<>();
    private final ParkingRateCalculator rateCalculator = new ParkingRateCalculator();
    private final Map<String, Ticket> activeTickets = new HashMap<>();
    private final Map<String, EntranceGate> entranceGates = new HashMap<>();
    private final Map<String, ExitGate> exitGates = new HashMap<>();

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public void addEntranceGate(EntranceGate gate) {
        entranceGates.put(gate.getGateId(), gate);
    }

    public void addExitGate(ExitGate gate) {
        exitGates.put(gate.getGateId(), gate);
    }

    public Ticket parkVehicle(Vehicle vehicle, String gateId) {
        EntranceGate gate = entranceGates.get(gateId);
        if (gate == null) throw new RuntimeException("Invalid entrance gate");

        for (ParkingFloor floor : floors) {
            ParkingSlot slot = floor.parkVehicle(vehicle);
            if (slot != null) {
                Ticket ticket = gate.generateTicket(vehicle, slot, floor.getFloorNumber());
                activeTickets.put(ticket.getTicketId(), ticket);
                return ticket;
            }
        }
        throw new RuntimeException("Parking full");
    }

    public Receipt unparkVehicle(String ticketId, String gateId) {
        ExitGate gate = exitGates.get(gateId);
        if (gate == null) throw new RuntimeException("Invalid exit gate");

        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) throw new RuntimeException("Invalid ticket");

        Duration duration = Duration.between(ticket.getEntryTime(), LocalDateTime.now());
        double fee = rateCalculator.calculateFee(ticket.getVehicle().getType(), duration);

        return gate.generateReceipt(ticket, fee);
    }
}
