package src.gates;

public abstract class Gate {
    protected final String gateId;
    public Gate(String gateId) { this.gateId = gateId; }
    public String getGateId() { return gateId; }
}