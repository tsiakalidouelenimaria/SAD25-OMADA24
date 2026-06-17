package test;

public class SupplierOrder {
	
	private Product product;
    private int quantity;
    private String reason;

    public SupplierOrder(Product product, int quantity, String reason) {
        this.product = product;
        this.quantity = quantity;
        this.reason = reason;
    }

    public void printData() {
        System.out.println("Παραγγελία Προμηθευτή -> Προϊόν: " + product.getName() + " | Ποσότητα: " + 
                           quantity + " | Λόγος: " + reason);
    }
}


