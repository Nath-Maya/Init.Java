package model;

public class Customer {
    private String firstName;
    private String lastName;
    private String id;
    private String company;
    private boolean active;

    public Customer(String firstName, String lastName, String id, String company, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.company = company;
        this.active = status.equalsIgnoreCase("active");
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getId() { return id; }
    public String getCompany() { return company; }
    public String getStatus() { return active ? "active" : "inactive"; }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setId(String id) { this.id = id; }
    public void setCompany(String company) { this.company = company; }
    public void setStatus(String status) { this.active = status.equalsIgnoreCase("active"); }

    // Para guardar en archivo
    public String toCSV() {
        return firstName + "," + lastName + "," + id + "," + company + "," + getStatus();
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + " | ID: " + id + " | Company: " + company + " | Status: " + getStatus();
    }
}
