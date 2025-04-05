package service;

import model.Customer;
import java.io.*;
import java.util.*;

public class CustomerManager {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void saveCustomersToFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Customer customer : customers) {
                writer.write(customer.toString());
                writer.newLine();
            }
        }
    }
}
