package src.gates;

import java.util.UUID;

import src.parking.Receipt;
import src.parking.Ticket;

public class ExitGate extends Gate {
    public ExitGate(String gateId) { super(gateId); }
    public Receipt generateReceipt(Ticket ticket, double amount) {
        return new Receipt(UUID.randomUUID().toString(), ticket, amount, gateId);
    }
}
