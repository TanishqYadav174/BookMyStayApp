
public class HotelBookingApp {

    // Abstract Room class
    static abstract class Room {
        protected int beds;
        protected int size;
        protected double price;

        public Room(int beds, int size, double price) {
            this.beds = beds;
            this.size = size;
            this.price = price;
        }

        public void displayDetails(int available) {
            System.out.println("Beds: " + beds);
            System.out.println("Size: " + size + " sqft");
            System.out.println("Price per night: " + price);
            System.out.println("Available: " + available);
            System.out.println();
        }
    }

    // Single Room class
    static class SingleRoom extends Room {
        public SingleRoom() {
            super(1, 250, 1500.0);
        }
    }

    // Double Room class
    static class DoubleRoom extends Room {
        public DoubleRoom() {
            super(2, 400, 2500.0);
        }
    }

    // Suite Room class
    static class SuiteRoom extends Room {
        public SuiteRoom() {
            super(3, 750, 5000.0);
        }
    }

    // Main method (program entry point)
    public static void main(String[] args) {

        System.out.println("Hotel Room Initialization\n");

        // Create room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display room information
        System.out.println("Single Room:");
        single.displayDetails(singleAvailable);

        System.out.println("Double Room:");
        doubleRoom.displayDetails(doubleAvailable);

        System.out.println("Suite Room:");
        suite.displayDetails(suiteAvailable);
    }
}