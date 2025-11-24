import java.util.Scanner;

/* this class will contain the main function of the project
   and the execution (like user input,respective output based on input,etc)
   will be handled from here only*/

public class MediManagerApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MediManagerAppBackend store = new MediManagerAppBackend();

        store.registerProduct("Aspirin", "X200", 4.50, 50, "2026-05-20");
        store.registerProduct("OldSyrup", "Z100", 10.00, 10, "2022-01-01");

        while (true) {
            System.out.println("\n=== PHARMACY MANAGEMENT PORTAL ===");
            System.out.println("1. New Item Entry");
            System.out.println("2. List All Items");
            System.out.println("3. Process Billing");
            System.out.println("4. Expiry Risk Scan");
            System.out.println("5. Quit Application");
            System.out.print("Select Action: ");

            if (!input.hasNextInt()) {
                System.out.println("Input Error. Enter a digit.");
                input.next();
                continue;
            }

            int userOpt = input.nextInt();
            input.nextLine();

            switch (userOpt) {
                case 1:
                    System.out.print("Product Name: ");
                    String pName = input.nextLine();
                    
                    System.out.print("Batch Code: ");
                    String pBatch = input.nextLine();
                    
                    System.out.print("Unit Cost: ");
                    double pPrice = input.nextDouble();
                    
                    System.out.print("Stock Count: ");
                    int pQty = input.nextInt();
                    
                    System.out.print("Expiry (YYYY-MM-DD): ");
                    String pDate = input.next();
                    
                    store.registerProduct(pName, pBatch, pPrice, pQty, pDate);
                    break;

                case 2:
                    store.showCurrentStock();
                    break;

                case 3:
                    System.out.print("Item Name to Bill: ");
                    String sName = input.nextLine();
                    System.out.print("Units Sold: ");
                    int sQty = input.nextInt();
                    store.processSale(sName, sQty);
                    break;

                case 4:
                    store.alertExpiredMeds();
                    break;

                case 5:
                    System.out.println("Closing portal. Have a good day.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Choose a valid option");
            }
        }
    }
}
