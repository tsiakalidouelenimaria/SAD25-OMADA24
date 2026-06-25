package test;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private Employee employee;
    private String docType; 
    private List<TransactionLine> lines;
    private String orderStatus; // Active ή Cancelled

    public Order(Customer customer, Employee employee, String docType) {
        this.customer = customer;
        this.employee = employee;
        this.docType = docType;
        this.lines = new ArrayList<>();
        this.orderStatus = "Active";
    }

    // Μέθοδος addProduct όπως καλείται στο διάγραμμα για την εισαγωγή προϊόντων
    public void addProduct(Product product, int quantity) {
        lines.add(new TransactionLine(product, quantity));
        product.reduceStock(quantity); // Καλεί τη reduceStock του Product
    }

    // Μέθοδος cancelOrder όπως ακριβώς φαίνεται στο Sequence Diagram της ακύρωσης
    public void cancelOrder() {
        this.orderStatus = "Cancelled";
        for (TransactionLine line : lines) {
            line.getProduct().increaseStock(line.getQuantity()); // Επιστρέφει το stock
        }
    }

    public void printData() {
        System.out.println("Παραγγελία -> ΑΦΜ Πελάτη: " + customer.getAfm() + " | Παραστατικό: " + docType +  
                           " | Υπάλληλος: " + employee.getName() + " | Κατάσταση: " + orderStatus);
        for (TransactionLine line : lines) {
            System.out.println("   - Προϊόν: " + line.getProduct().getName() + " | Ποσότητα: " + line.getQuantity());
        }
    }
}