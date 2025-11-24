import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.io.FileWriter;
import java.io.IOException;

/* this class will acts like a backend for this project 
   all the processing and backgroud task is performed in this class */

public class MediManagerAppBackend {
    
    private ArrayList<MedicineInput> inventory = new ArrayList<>();

    public void registerProduct(String name, String batch, double price, int qty, String date) {
        MedicineInput item = new MedicineInput(name, batch, price, qty, date);
        inventory.add(item);
        System.out.println(">> Item logged successfully.");
        saveToDatabase();
    }

    public void showCurrentStock() {
        if (inventory.isEmpty()) {
            System.out.println(">> No items in database.");
        } else {
            System.out.println("\n--- Current Stock List ---");
            for (MedicineInput m : inventory) {
                System.out.println(m.toString());
            }
            System.out.println("--------------------------");
        }
    }

    public void processSale(String name, int qtyRequired) {
        boolean isFound = false;
        
        for (MedicineInput m : inventory) {
            if (m.getProdName().equalsIgnoreCase(name)) {
                isFound = true;
                
                if (m.getStockQty() >= qtyRequired) {
                    double finalPrice = qtyRequired * m.getUnitCost();
                    
                    m.setStockQty(m.getStockQty() - qtyRequired);
                    
                    System.out.println("\n*** SALES RECEIPT ***");
                    System.out.println("Product: " + m.getProdName());
                    System.out.println("Count: " + qtyRequired);
                    System.out.println("Total: $" + finalPrice);
                    System.out.println("*********************\n");
                } else {
                    System.out.println(">> Error: Low Stock. Available: " + m.getStockQty());
                }
                break;
            }
        }
        
        if (!isFound) {
            System.out.println(">> Error: Product not recognized.");
        }
    }

    public void alertExpiredMeds() {
        LocalDate currentDay = LocalDate.now();
        System.out.println("\n--- Safety Scan Results ---");
        boolean riskDetected = false;

        for (MedicineInput m : inventory) {
            long daysLeft = ChronoUnit.DAYS.between(currentDay, m.getExpDate());

            if (daysLeft < 0) {
                System.out.println("CRITICAL: " + m.getProdName() + " has EXPIRED! (Remove from shelf)");
                riskDetected = true;
            } else if (daysLeft <= 30) {
                System.out.println("ALERT: " + m.getProdName() + " expires in " + daysLeft + " days.");
                riskDetected = true;
            }
        }

        if (!riskDetected) {
            System.out.println(">> All items are safe.");
        }
    }

    public void saveToDatabase() {
        try (FileWriter fw = new FileWriter("pharmacy_db.txt")) {
            for (MedicineInput m : inventory) {
                fw.write(m.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Warning: Database save failed.");
        }
    }
}
