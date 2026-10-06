
import java.util.ArrayList;
import java.util.Scanner;

class Vehicle {

    private int id;
    private String name;
    private String type;
    private double pricePerDay;
    private boolean available;

    // Constructor
    public Vehicle(int id, String name, String type, double pricePerDay) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.pricePerDay = pricePerDay;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rent() {
        available = false;
    }

    public void returnVehicle() {
        available = true;
    }

    @Override
    public String toString() {

        String status;

        if (available) {
            status = "Available";
        } else {
            status = "Rented";
        }

        return "ID: " + id +
                " | Name: " + name +
                " | Type: " + type +
                " | Price/Day: ₹" + pricePerDay +
                " | Status: " + status;
    }
}

public class VehicleRentalManagementSystem {

    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Sample vehicles
        vehicles.add(new Vehicle(101, "Honda City", "Car", 2000));
        vehicles.add(new Vehicle(102, "Royal Enfield", "Bike", 800));
        vehicles.add(new Vehicle(103, "Swift", "Car", 1500));

        while (true) {

            System.out.println("\n================================");
            System.out.println("     VEHICLE RENTAL SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View Vehicles");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Rent Vehicle");
            System.out.println("5. Return Vehicle");
            System.out.println("6. Delete Vehicle");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            try {

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        addVehicle();
                        break;

                    case 2:
                        viewVehicles();
                        break;

                    case 3:
                        searchVehicle();
                        break;

                    case 4:
                        rentVehicle();
                        break;

                    case 5:
                        returnVehicle();
                        break;

                    case 6:
                        deleteVehicle();
                        break;

                    case 7:
                        System.out.println("Thank you!");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {

                System.out.println("Please enter a valid number.");
                sc.nextLine();
            }
        }
    }

    // Add Vehicle
    static void addVehicle() {

        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // Check duplicate ID
        for (Vehicle vehicle : vehicles) {

            if (vehicle.getId() == id) {

                System.out.println("Vehicle ID already exists!");
                return;
            }
        }

        System.out.print("Enter Vehicle Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Vehicle Type: ");
        String type = sc.nextLine();

        System.out.print("Enter Price Per Day: ");
        double price = sc.nextDouble();

        Vehicle vehicle = new Vehicle(id, name, type, price);

        vehicles.add(vehicle);

        System.out.println("Vehicle added successfully!");
    }

    // View Vehicles
    static void viewVehicles() {

        if (vehicles.isEmpty()) {

            System.out.println("No vehicles found.");
            return;
        }

        System.out.println("\n--------- Vehicle List ---------");

        for (Vehicle vehicle : vehicles) {

            System.out.println(vehicle);
        }
    }

    // Search Vehicle
    static void searchVehicle() {

        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getId() == id) {

                System.out.println("\nVehicle Found!");
                System.out.println(vehicle);
                return;
            }
        }

        System.out.println("Vehicle not found.");
    }

    // Rent Vehicle
    static void rentVehicle() {

        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getId() == id) {

                if (!vehicle.isAvailable()) {

                    System.out.println("Vehicle is already rented.");
                    return;
                }

                vehicle.rent();

                System.out.println("Vehicle rented successfully!");
                System.out.println("Price per day: ₹"
                        + vehicle.getPricePerDay());

                return;
            }
        }

        System.out.println("Vehicle not found.");
    }

    // Return Vehicle
    static void returnVehicle() {

        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getId() == id) {

                if (vehicle.isAvailable()) {

                    System.out.println("Vehicle is already available.");
                    return;
                }

                vehicle.returnVehicle();

                System.out.println("Vehicle returned successfully!");
                return;
            }
        }

        System.out.println("Vehicle not found.");
    }

    // Delete Vehicle
    static void deleteVehicle() {

        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getId() == id) {

                vehicles.remove(vehicle);

                System.out.println("Vehicle deleted successfully!");
                return;
            }
        }

        System.out.println("Vehicle not found.");
    }
}
