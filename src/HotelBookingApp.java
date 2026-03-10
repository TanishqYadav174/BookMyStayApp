import java.util.HashMap;
import java.util.Map;

public class HotelBookingApp {
    static abstract class Room {
        protected String type;
        protected int beds;
        protected int size;
        protected double price;

        public Room(String type, int beds, int size, double price) {
            this.type = type;
            this.beds = beds;
            this.size = size;
            this.price = price;
        }
        public String getType() {
            return type;
        }

        public void displayDetails() {
            System.out.println(type + ":");
            System.out.println("Beds: " + beds);
            System.out.println("Size: " + size + " sqft");
            System.out.println("Price per night: " + price);
        }
    }


    static class SingleRoom extends Room {
        public SingleRoom() {
            super("Single Room", 1, 250, 1500.0);
        }
    }

    static class DoubleRoom extends Room {
        public DoubleRoom() {
            super("Double Room", 2, 400, 2500.0);
        }
    }

    static class SuiteRoom extends Room {
        public SuiteRoom() {
            super("Suite Room", 3, 750, 5000.0);
        }
    }



    static class RoomInventory {

        private HashMap<String, Integer> availability;

        public RoomInventory() {
            availability = new HashMap<>();

            availability.put("Single Room", 5);
            availability.put("Double Room", 3);
            availability.put("Suite Room", 2);
        }

        public int getAvailability(String roomType) {
            return availability.getOrDefault(roomType, 0);
        }

        public void updateAvailability(String roomType, int newCount) {
            availability.put(roomType, newCount);
        }

        public void displayInventory() {
            System.out.println("Current Room Inventory:");
            for (Map.Entry<String, Integer> entry : availability.entrySet()) {
                System.out.println(entry.getKey() + " Available: " + entry.getValue());
            }
        }
    }


    public static void main(String[] args) {

        System.out.println("Hotel Room Initialization\n");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        RoomInventory inventory = new RoomInventory();

        single.displayDetails();
        System.out.println("Available: " + inventory.getAvailability(single.getType()));
        System.out.println();

        doubleRoom.displayDetails();
        System.out.println("Available: " + inventory.getAvailability(doubleRoom.getType()));
        System.out.println();

        suite.displayDetails();
        System.out.println("Available: " + inventory.getAvailability(suite.getType()));
    }
}