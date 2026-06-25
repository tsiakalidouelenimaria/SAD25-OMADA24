package test;

public class Employee {
	
	private String name;
    private String role;
    private String accountType;

    public Employee(String name, String role, String accountType) {
        this.name = name;
        this.role = role;
        this.accountType = accountType;
    }

    public String getName() { return name; }

    public void printData() {
        System.out.println("Υπάλληλος: " + name + " | Ρόλος: " + role + " | Λογαριασμός: " + accountType);
    }
}