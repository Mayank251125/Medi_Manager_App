import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/*this class is to declear all the required variables,functions,methods etc which will be used in the project */

public class MedicineInput {                         
    private String prodName;
    private String batchCode;
    private double unitCost;
    private int stockQty;
    private LocalDate expDate;

    public MedicineInput(String name, String batch, double price, int qty, String dateStr) {
        this.prodName = name;
        this.batchCode = batch;
        this.unitCost = price;
        this.stockQty = qty;
        try {
            this.expDate = LocalDate.parse(dateStr);
        } catch (DateTimeParseException e) {
            System.out.println("Date error. Setting to current date.");
            this.expDate = LocalDate.now();
        }
    }

    public String getProdName() { return prodName; }
    
    public int getStockQty() { return stockQty; }
    public void setStockQty(int stockQty) { this.stockQty = stockQty; }

    public double getUnitCost() { return unitCost; }
    
    public LocalDate getExpDate() { return expDate; }

    @Override
    public String toString() {
        return String.format("Product: %-15s | Batch: %-10s | Cost: $%-6.2f | Stock: %-4d | Exp: %s",
                prodName, batchCode, unitCost, stockQty, expDate);
    }
}