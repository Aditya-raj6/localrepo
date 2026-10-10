import java.util.*;
class Warehouse {
    private int stock = 0;

    
    public synchronized void purchaseProduct(String customerName, int quantity) {
        System.out.println(customerName + " arrived to buy " + quantity + " unit(s). [Available: " + stock + "]");

    
        while (stock < quantity) {
            System.out.println("[OUT OF STOCK] " + customerName + " is WAITING for restock...");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Waiting interrupted for " + customerName);
            }
        }

    
        stock -= quantity;
        System.out.println("[PURCHASE COMPLETE] " + customerName + " bought " + quantity + " unit(s). Remaining stock: " + stock);
        System.out.println("--------------------------------------------------");
    }

    
    public synchronized void replenishStock(int addedStock) {
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        stock += addedStock;
        System.out.println("\n>>> [INVENTORY RESTOCKED] " + addedStock + " unit(s) added! New total stock: " + stock + " <<<");
        

        notifyAll();
    }
}

class CustomerShopper extends Thread {
    private Warehouse warehouse;
    private String name;
    private int quantity;

    public CustomerShopper(Warehouse warehouse, String name, int quantity) {
        this.warehouse = warehouse;
        this.name = name;
        this.quantity = quantity;
    }


    public void run() {
        warehouse.purchaseProduct(name, quantity);
    }
}


class InventoryRestocker extends Thread {
    private Warehouse warehouse;
    private int amount;

    public InventoryRestocker(Warehouse warehouse, int amount) {
        this.warehouse = warehouse;
        this.amount = amount;
    }

    
    public void run() {
        warehouse.replenishStock(amount);
    }
}

public class OnlineShoppingApplication {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(); 

        
        CustomerShopper custA = new CustomerShopper(warehouse, "Customer-Aditya", 3);
        CustomerShopper custB = new CustomerShopper(warehouse, "Customer-Bablu", 2);

        
        InventoryRestocker restocker = new InventoryRestocker(warehouse, 5);

        custA.start();
        custB.start();
        restocker.start();
    }
}