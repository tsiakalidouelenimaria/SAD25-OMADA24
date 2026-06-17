package test;
import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private Customer customer;
    private Employee employee;
    private String docType; 
    private List<TransactionLine> lines;

    public Order(Customer customer, Employee employee, String docType) {
        this.customer = customer;
        this.employee = employee;
        this.docType = docType;
        this.lines = new ArrayList<>();
    }

    
    public void addProduct(Product product, int quantity) {
        lines.add(new TransactionLine(product, quantity));
        product.reduceStock(quantity);
    }

    
    public void cancelOrder() {
        for (TransactionLine line : lines) {
            line.getProduct().increaseStock(line.getQuantity());
        }
    }

    public void printData() {
        System.out.println("Παραγγελία -> ΑΦΜ Πελάτη: " + customer.getAfm() + " | Παραστατικό: " + docType + 
                           " | Υπάλληλος: " + employee.getName());
        for (TransactionLine line : lines) {
            System.out.println("   - Προϊόν: " + line.getProduct().getName() + " | Ποσότητα: " + line.getQuantity());
        }
    }
}

