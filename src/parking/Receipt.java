package src.parking;

import java.time.LocalDateTime;

public class Receipt {
    private final String receiptId;
    private final Ticket ticket;
    private final LocalDateTime exitTime;
    private final double amount;
    private final String exitGateId;

    public Receipt(String receiptId, Ticket ticket, double amount, String exitGateId) {
        this.receiptId = receiptId;
        this.ticket = ticket;
        this.exitTime = LocalDateTime.now();
        this.amount = amount;
        this.exitGateId = exitGateId;
    }

    public String getReceiptId() { return receiptId; }
    public Ticket getTicket() { return ticket; }
    public LocalDateTime getExitTime() { return exitTime; }
    public double getAmount() { return amount; }
    public String getExitGateId() { return exitGateId; }
}
