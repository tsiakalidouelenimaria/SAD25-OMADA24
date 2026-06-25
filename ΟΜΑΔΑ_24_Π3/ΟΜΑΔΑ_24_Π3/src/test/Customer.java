package test;

public class Customer {
    private String name;
    private String type; 
    private String afm;
    private String doy;
    private String status;

    public Customer(String name, String type, String afm, String doy, String status) {
        this.name = name;
        this.type = type;
        this.afm = afm;
        this.doy = doy;
        this.status = status;
    }

    public String getAfm() { return afm; }
    
    public void printData() {
        System.out.println("Πελάτης: " + name + " | Τύπος: " + type + " | ΑΦΜ: " + afm +  
                           " | ΔΟΥ: " + doy + " | Κατάσταση: " + status);
    }
}