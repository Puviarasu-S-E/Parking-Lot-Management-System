import java.util.*;

public class ParkingApp {
    private static Map<Integer, ParkingSlot> slots = new TreeMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Parking Lot Management System (Console)");
        System.out.println("Type 'help' for commands.");

        while (true) {
            System.out.print("> ");
            String input = sc.nextLine().trim();
            String[] parts = input.split(" ");
            if (parts.length == 0) continue;

            String cmd = parts[0].toLowerCase();

            switch (cmd) {
                case "addslot":
                    if (parts.length != 3) {
                        System.out.println("Usage: addslot <slotId> <CAR|BIKE|TRUCK>");
                        break;
                    }
                    int id = Integer.parseInt(parts[1]);
                    String type = parts[2].toUpperCase();
                    if (slots.containsKey(id)) {
                        System.out.println("Slot already exists!");
                    } else {
                        slots.put(id, new ParkingSlot(id, type));
                        System.out.println("Slot " + id + " added for " + type);
                    }
                    break;

                case "park":
                    if (parts.length != 3) {
                        System.out.println("Usage: park <regNo> <CAR|BIKE|TRUCK>");
                        break;
                    }
                    String regNo = parts[1];
                    String vType = parts[2].toUpperCase();
                    boolean parked = false;
                    for (ParkingSlot s : slots.values()) {
                        if (s.getType().equals(vType) && s.isFree()) {
                            s.parkVehicle(new Vehicle(regNo, vType));
                            System.out.println("Vehicle " + regNo + " parked at slot " + s.getSlotId());
                            parked = true;
                            break;
                        }
                    }
                    if (!parked) System.out.println("No free slot for " + vType);
                    break;

                case "leave":
                    if (parts.length != 3) {
                        System.out.println("Usage: leave <slotId> <hoursParked>");
                        break;
                    }
                    int slotId = Integer.parseInt(parts[1]);
                    int hours = Integer.parseInt(parts[2]);
                    ParkingSlot s = slots.get(slotId);
                    if (s == null || s.isFree()) {
                        System.out.println("Invalid slot or already free.");
                    } else {
                        String vtype = s.getVehicle().getType();
                        long fee = calculateFee(vtype, hours);
                        System.out.println("Vehicle " + s.getVehicle().getRegNo() +
                                " left. Fee = " + fee);
                        s.freeSlot();
                    }
                    break;

                case "status":
                    System.out.printf("%-6s %-8s %-12s %-6s%n", "Slot", "Type", "Vehicle", "Free?");
                    for (ParkingSlot slot : slots.values()) {
                        System.out.printf("%-6d %-8s %-12s %-6s%n",
                                slot.getSlotId(),
                                slot.getType(),
                                slot.isFree() ? "-" : slot.getVehicle().getRegNo(),
                                slot.isFree());
                    }
                    break;

                case "help":
                    System.out.println("Commands:");
                    System.out.println(" addslot <slotId> <CAR|BIKE|TRUCK>");
                    System.out.println(" park <regNo> <CAR|BIKE|TRUCK>");
                    System.out.println(" leave <slotId> <hoursParked>");
                    System.out.println(" status");
                    System.out.println(" help");
                    System.out.println(" exit");
                    break;

                case "exit":
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Unknown command. Type 'help'.");
            }
        }
    }

    private static long calculateFee(String type, int hours) {
        switch (type) {
            case "BIKE": return 20 + (hours - 1) * 10;
            case "CAR": return 40 + (hours - 1) * 20;
            case "TRUCK": return 80 + (hours - 1) * 40;
            default: return 0;
        }
    }
}
