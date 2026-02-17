import java.util.Scanner;

class Vehicle {
    private String brand;
    private String model;
    private int year;
    private double mileage;
    private double engineCapacity;

    Vehicle(String brandName, String modelName, int manufactureYear,
            double currentMileage, double engineCC) {
        brand = brandName;
        model = modelName;
        year = manufactureYear;
        mileage = currentMileage;
        engineCapacity = engineCC;
    }

    String getBrand() { return brand; }
    String getModel() { return model; }
    int getYear() { return year; }
    double getMileage() { return mileage; }
    double getEngineCapacity() { return engineCapacity; }

    void addTripDistance(double distance) {
        mileage += distance;
    }
}

class VehicleApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[5];
        int count = 0;
        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println("       VEHICLE MANAGEMENT SYSTEM        ");
            System.out.println("========================================");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Display All Vehicles (Table)");
            System.out.println("3. Update Mileage After Trip");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            // Basic validation for non-integer menu inputs
            while (!sc.hasNextInt()) {
                System.out.print("Please enter a number: ");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (count >= vehicles.length) {
                        System.out.println("Error: Garage is full (Max 5 vehicles).");
                        break;
                    }
                    System.out.print("Enter brand: ");
                    String brand = sc.next();
                    System.out.print("Enter model: ");
                    String model = sc.next();
                    System.out.print("Enter year: ");
                    int year = sc.nextInt();
                    System.out.print("Enter current mileage: ");
                    double mileage = sc.nextDouble();
                    System.out.print("Enter engine capacity (cc): ");
                    double engineCapacity = sc.nextDouble();

                    vehicles[count++] = new Vehicle(brand, model, year, mileage, engineCapacity);
                    System.out.println("✔ Vehicle added successfully.");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("(!) No vehicles available.");
                    } else {
                        printTable(vehicles, count);
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("(!) No vehicles to update.");
                        break;
                    }
                    System.out.print("Enter vehicle ID (1-" + count + "): ");
                    int id = sc.nextInt();

                    if (id > 0 && id <= count) {
                        System.out.print("Enter trip distance (km): ");
                        double trip = sc.nextDouble();
                        vehicles[id - 1].addTripDistance(trip);
                        System.out.println("✔ Mileage updated.");
                    } else {
                        System.out.println("✘ Invalid Vehicle ID.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("✘ Invalid choice. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }

    // Tabular UI Helper Method
    private static void printTable(Vehicle[] vehicles, int count) {
        String separator = "+----+------------+------------+------+----------+---------+";
        System.out.println(separator);
        System.out.printf("| %-2s | %-10s | %-10s | %-4s | %-8s | %-7s |%n",
                "ID", "Brand", "Model", "Year", "Mileage", "CC");
        System.out.println(separator);

        for (int i = 0; i < count; i++) {
            System.out.printf("| %-2d | %-10s | %-10s | %-4d | %-8.1f | %-7.0f |%n",
                    (i + 1),
                    vehicles[i].getBrand(),
                    vehicles[i].getModel(),
                    vehicles[i].getYear(),
                    vehicles[i].getMileage(),
                    vehicles[i].getEngineCapacity());
        }
        System.out.println(separator);
    }
}