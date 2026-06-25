package test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        List<Product> productsCatalog = new ArrayList<>();
        List<Customer> customersCatalog = new ArrayList<>();
        List<Employee> employeesCatalog = new ArrayList<>();
        List<Order> ordersCatalog = new ArrayList<>();
        List<SupplierOrder> supplierOrdersCatalog = new ArrayList<>();

        System.out.println("1. ΔΗΜΙΟΥΡΓΙΑ ΠΡΟΪΟΝΤΩΝ ===");
        Product product1 = new Product("Thermometer", "paramedical", 12.50, 100, 30);
        Product product2 = new Product("Shoes", "paramedical", 35.00, 45, 20);
        Product product3 = new Product("Cream", "cosmetic", 18.00, 40, 40);
        Product product4 = new Product("makeup", "cosmetic", 22.00, 60, 25);
        
        productsCatalog.add(product1); System.out.println("Object product1 has been created");
        productsCatalog.add(product2); System.out.println("Object product2 has been created");
        productsCatalog.add(product3); System.out.println("Object product3 has been created");
        productsCatalog.add(product4); System.out.println("Object product4 has been created");

        System.out.println("\n2. ΔΗΜΙΟΥΡΓΙΑ ΠΕΛΑΤΩΝ ===");
        Customer customer1 = new Customer("Farmakeio Papadopoulou", "Pharmacy", "099845210", "DOY Kalamarias", "OK");
        Customer customer2 = new Customer("Farmakeio Nikolaidis", "Pharmacy", "078632145", "DOY Evosmou", "OK");
        Customer customer3 = new Customer("Georgiou Maria", "Retail", "112233445", "DOY Thessalonikis", "OK");
        
        customersCatalog.add(customer1); System.out.println("Object customer1 has been created");
        customersCatalog.add(customer2); System.out.println("Object customer2 has been created");
        customersCatalog.add(customer3); System.out.println("Object customer3 has been created");

        System.out.println("\n3. ΔΗΜΙΟΥΡΓΙΑ ΥΠΑΛΛΗΛΩΝ ===");
        Employee employee1 = new Employee("Antoniou", "Warehouse", "warehouse_user");
        Employee employee2 = new Employee("Eleftheriou", "Customer Service", "service_user");
        Employee employee3 = new Employee("Sotiriou", "Cashier", "cashier_user");
        Employee employee4 = new Employee("Seller1", "Sales", "sales_user");
        
        employeesCatalog.add(employee1); System.out.println("Object employee1 has been created");
        employeesCatalog.add(employee2); System.out.println("Object employee2 has been created");
        employeesCatalog.add(employee3); System.out.println("Object employee3 has been created");
        employeesCatalog.add(employee4); System.out.println("Object employee4 has been created");

        System.out.println("\n4. ΔΗΜΙΟΥΡΓΙΑ ΠΑΡΑΓΓΕΛΙΩΝ ===");
        Order order1 = new Order(customer1, employee4, "Τιμολόγιο");
        order1.addProduct(product1, 10);
        order1.addProduct(product3, 5);
        ordersCatalog.add(order1); System.out.println("Object order1 has been created");

        Order order2 = new Order(customer1, employee4, "Τιμολόγιο");
        order2.addProduct(product2, 8);
        order2.addProduct(product4, 12);
        ordersCatalog.add(order2); System.out.println("Object order2 has been created");

        Order order3 = new Order(customer2, employee4, "Τιμολόγιο");
        order3.addProduct(product3, 20);
        order3.addProduct(product4, 10);
        order3.addProduct(product1, 6);
        ordersCatalog.add(order3); System.out.println("Object order3 has been created");

        Order order4 = new Order(customer3, employee3, "Απόδειξη");
        order4.addProduct(product1, 1);
        order4.addProduct(product4, 2);
        ordersCatalog.add(order4); System.out.println("Object order4 has been created");

        System.out.println("\n5. ΔΙΑΓΡΑΦΗ ΠΑΡΑΓΓΕΛΙΑΣ order2 ===");
        order2.cancelOrder(); // Καλεί την cancelOrder() όπως στο διάγραμμα
        System.out.println("Object order2 has been deleted (canceled) and stock restored");

        System.out.println("\n6. ΑΝΑΠΛΗΡΩΣΗ ΑΠΟΘΕΜΑΤΟΣ ===");
        for (Product p : productsCatalog) {
            if (p.getStockQuantity() < p.getSafetyLimit()) {
                SupplierOrder supplierOrder1 = new SupplierOrder(p, 50, "Το απόθεμα έπεσε κάτω από το όριο ασφαλείας");
                supplierOrdersCatalog.add(supplierOrder1);
                System.out.println("Object supplierOrder1 created for product: " + p.getName());
            }
        }

        System.out.println("\n=============================================");
        System.out.println("7. ΤΕΛΙΚΗ ΕΚΤΥΠΩΣΗ ΚΑΤΑΛΟΓΩΝ (printData) ===");
        System.out.println("=============================================\n");
        
        System.out.println("--- Κατάλογος Προϊόντων ---");
        for (Product p : productsCatalog) { p.printData(); }

        System.out.println("\n--- Κατάλογος Πελατών ---");
        for (Customer c : customersCatalog) { c.printData(); }

        System.out.println("\n--- Κατάλογος Υπαλλήλων ---");
        for (Employee e : employeesCatalog) { e.printData(); }

        System.out.println("\n--- Κατάλογος Παραγγελιών ---");
        for (Order o : ordersCatalog) { o.printData(); }

        System.out.println("\n--- Κατάλογος Παραγγελιών Προμηθευτή ---");
        for (SupplierOrder so : supplierOrdersCatalog) { so.printData(); }
    }
}