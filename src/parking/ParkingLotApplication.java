package src.parking;

import src.gates.EntranceGate;
import src.gates.ExitGate;
import src.vehicle.Car;
import src.vehicle.Vehicle;
import src.vehicle.VehicleType;

public class ParkingLotApplication {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        // Register gates
        parkingLot.addEntranceGate(new EntranceGate("GATE-IN-1"));
        parkingLot.addExitGate(new ExitGate("GATE-OUT-1"));

        // Add floor with parking slots
        ParkingFloor floor0 = new ParkingFloor(0, new NearestToEntranceStrategy());
        floor0.addSlot(new ParkingSlot("SLOT-1", VehicleType.CAR, 5, 10));
        floor0.addSlot(new ParkingSlot("SLOT-2", VehicleType.CAR, 8, 6));
        floor0.addSlot(new ParkingSlot("SLOT-3", VehicleType.BIKE, 3, 7));
        parkingLot.addFloor(floor0);

        // Park a car
        Vehicle car = new Car("MH01AB1234");
        Ticket ticket = parkingLot.parkVehicle(car, "GATE-IN-1");
        System.out.println("Ticket issued: " + ticket.getTicketId() + " at gate: " + ticket.getEntryGateId());

        try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }

        // Unpark vehicle
        Receipt receipt = parkingLot.unparkVehicle(ticket.getTicketId(), "GATE-OUT-1");
        System.out.println("Receipt: Rs." + receipt.getAmount() + " ExitGate: " + receipt.getExitGateId());
    }
}