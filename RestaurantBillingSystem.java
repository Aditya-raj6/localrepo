import java.util.Scanner;

interface EcoFriendlyPartner {
    default void displayEcoGuidelines() {
        System.out.println("\nEco-Friendly Delivery Guidelines ");
        System.out.println("1. Use 100% paper-based or biodegradable packaging.");
        System.out.println("2. Minimize single-use plastic cutlery and containers.");
        System.out.println("3. Ensure segregation and proper waste disposal instructions.");
        System.out.println(" 4. Encourage customers to return packaging for reuse or recycling.");
    }
}

abstract class Restaurant {
    private String restaurantId;
    private String restaurantName;
    private String location;
    private double averageOrderValue;

    public Restaurant(String restaurantId, String restaurantName, String location, double averageOrderValue) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.location = location;
        this.averageOrderValue = averageOrderValue;
    }

    public double getAverageOrderValue() {
        return averageOrderValue;
    }

    public abstract double calculateTotalBill();

    public void displayBaseDetails() {
        System.out.println("\n BILL RECEIPT ");
        System.out.println("Restaurant ID   : " + restaurantId);
        System.out.println("Restaurant Name : " + restaurantName);
        System.out.println("Location        : " + location);
        System.out.printf("Order Value     : $%.2f\n", averageOrderValue);
    }
}

class VegetarianRestaurant extends Restaurant implements EcoFriendlyPartner {
    private double deliveryCharge;

    public VegetarianRestaurant(String id, String name, String loc, double orderValue, double deliveryCharge) {
        super(id, name, loc, orderValue);
        this.deliveryCharge = deliveryCharge;
    }

    public double calculateTotalBill() {
        return getAverageOrderValue() + deliveryCharge;
    }

    public void generateBill() {
        displayEcoGuidelines();
        displayBaseDetails();
        System.out.printf("Delivery Charge : $%.2f\n", deliveryCharge);
        System.out.printf("Total Bill      : $%.2f\n", calculateTotalBill());
        System.out.println("");
    }
}

class CloudKitchen extends Restaurant {
    private double packagingCharge;

    public CloudKitchen(String id, String name, String loc, double orderValue, double packagingCharge) {
        super(id, name, loc, orderValue);
        this.packagingCharge = packagingCharge;
    }

    public double calculateTotalBill() {
        return getAverageOrderValue() + packagingCharge;
    }

    public void generateBill() {
        displayBaseDetails();
        System.out.printf("Packaging Charge: $%.2f\n", packagingCharge);
        System.out.printf("Total Bill      : $%.2f\n", calculateTotalBill());
        System.out.println("");
    }
}

public class RestaurantBillingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select Restaurant Type:");
        System.out.println("1. Vegetarian Restaurant");
        System.out.println("2. Cloud Kitchen");
        System.out.print("Enter choice (1 or 2): ");
        int choice = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Restaurant ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Restaurant Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Location: ");
        String location = sc.nextLine();

        System.out.print("Enter Order Value: ");
        double orderValue = sc.nextDouble();

        if (choice == 1) {
            System.out.print("Enter Delivery Charge: ");
            double deliveryCharge = sc.nextDouble();

            VegetarianRestaurant vegRest = new VegetarianRestaurant(id, name, location, orderValue, deliveryCharge);
            vegRest.generateBill();
        } else if (choice == 2) {
            System.out.print("Enter Packaging Charge: ");
            double packagingCharge = sc.nextDouble();

            CloudKitchen kitchen = new CloudKitchen(id, name, location, orderValue, packagingCharge);
            kitchen.generateBill();
        } else {
            System.out.println("Invalid choice selected.");
        }

        sc.close();
    }
}