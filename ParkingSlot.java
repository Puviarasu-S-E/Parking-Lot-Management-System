public class ParkingSlot {
    private int slotId;
    private String type;
    private Vehicle vehicle;

    public ParkingSlot(int slotId, String type) {
        this.slotId = slotId;
        this.type = type;
        this.vehicle = null;
    }

    public int getSlotId() {
        return slotId;
    }

    public String getType() {
        return type;
    }

    public boolean isFree() {
        return vehicle == null;
    }

    public void parkVehicle(Vehicle v) {
        this.vehicle = v;
    }

    public void freeSlot() {
        this.vehicle = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
