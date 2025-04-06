package service;

import model.Customer;
import java.io.*;
import java.util.*;

public class CustomerManager {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        if (findCustomerById(customer.getId()) == null) {
            customers.add(customer);
        }
    }

    public Customer findCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void updateCustomer(Customer updatedCustomer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId().equals(updatedCustomer.getId())) {
                customers.set(i, updatedCustomer);
                break;
            }
        }
    }

    public void saveCustomersToFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Customer customer : customers) {
                String line = String.join(",",
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getId(),
                        customer.getCompany(),
                        customer.getStatus()
                );
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public void loadCustomersFromFile(String filePath) throws IOException {
        customers.clear();
        File file = new File(filePath);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    Customer customer = new Customer(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    customers.add(customer);
                }
            }
        }
    }
}
