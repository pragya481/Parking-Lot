package src.parking;

import java.time.LocalDateTime;

import src.vehicle.Vehicle;

public class Ticket {
    private final String ticketId;
    private final String slotId;
    private final int floorNumber;
    private final Vehicle vehicle;
    private final LocalDateTime entryTime;
    private final String entryGateId;

    public Ticket(String ticketId, String slotId, int floorNumber, Vehicle vehicle, String entryGateId) {
        this.ticketId = ticketId;
        this.slotId = slotId;
        this.floorNumber = floorNumber;
        this.vehicle = vehicle;
        this.entryTime = LocalDateTime.now();
        this.entryGateId = entryGateId;
    }

    public String getTicketId() { return ticketId; }
    public String getSlotId() { return slotId; }
    public int getFloorNumber() { return floorNumber; }
    public Vehicle getVehicle() { return vehicle; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public String getEntryGateId() { return entryGateId; }
}
