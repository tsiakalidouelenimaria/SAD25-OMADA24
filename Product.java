package test;

public class Product {
	
	private int κωδικος_προιοντος ;
	private String ονομα;
    private String κατηγορια;
    private double price;
    private int stockQuantity;
    private int safetyLimit;

    public Product(String name, String category, double price, int stockQuantity, int safetyLimit) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.safetyLimit = safetyLimit;
    }

  
	
    public void reduceStock(int quantity) {
        this.stockQuantity -= quantity;
    }

    public void increaseStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public String getName() { return name; }
    public int getStockQuantity() { return stockQuantity; }
    public int getSafetyLimit() { return safetyLimit; }

    public void printData() {
        System.out.println("Προϊόν: " + name + " | Κατηγορία: " + category + " | Τιμή: " + price + 
                           "€ | Διαθέσιμο: " + stockQuantity + " | Όριο Ασφαλείας: " + safetyLimit);
    }
}


