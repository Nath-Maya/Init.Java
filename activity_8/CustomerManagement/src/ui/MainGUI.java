package ui;

import model.Customer;
import service.CustomerManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.io.IOException;

public class MainGUI extends JFrame {

    private CustomerManager customerManager;
    private JTextField nameField, lastNameField, idField, companyField;
    private JComboBox<String> statusBox;
    private JTextArea displayArea;
    private final String FILE_PATH = "customers.txt";

    public MainGUI() {
        customerManager = new CustomerManager();

        try {
            customerManager.loadCustomersFromFile(FILE_PATH);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading customers: " + e.getMessage());
        }

        setTitle("Customer Manager");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(9, 2));

        inputPanel.add(new JLabel("First Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        inputPanel.add(lastNameField);

        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Company:"));
        companyField = new JTextField();
        inputPanel.add(companyField);

        inputPanel.add(new JLabel("Status:"));
        statusBox = new JComboBox<>(new String[]{"Active", "Inactive"});
        inputPanel.add(statusBox);

        JButton addButton = new JButton("Add Customer");
        addButton.addActionListener(this::addCustomer);
        inputPanel.add(addButton);

        JButton editButton = new JButton("Edit Customer");
        editButton.addActionListener(this::editCustomer);
        inputPanel.add(editButton);

        JButton listButton = new JButton("List Customers");
        listButton.addActionListener(this::listCustomers);
        inputPanel.add(listButton);

        JButton saveButton = new JButton("Save Customers");
        saveButton.addActionListener(this::saveCustomersToFile);
        inputPanel.add(saveButton);

        JButton showActiveButton = new JButton("Show Active");
        showActiveButton.addActionListener(e -> filterCustomersByStatus("Active"));
        inputPanel.add(showActiveButton);

        JButton showInactiveButton = new JButton("Show Inactive");
        showInactiveButton.addActionListener(e -> filterCustomersByStatus("Inactive"));
        inputPanel.add(showInactiveButton);

        add(inputPanel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setVisible(true);
    }

    private void addCustomer(ActionEvent e) {
        String firstName = nameField.getText();
        String lastName = lastNameField.getText();
        String id = idField.getText();
        String company = companyField.getText();
        String status = (String) statusBox.getSelectedItem();

        if (!firstName.isEmpty() && !lastName.isEmpty() && !id.isEmpty() && !company.isEmpty()) {
            if (customerManager.findCustomerById(id) != null) {
                JOptionPane.showMessageDialog(this, "Customer with this ID already exists.");
                return;
            }

            Customer customer = new Customer(firstName, lastName, id, company, status);
            customerManager.addCustomer(customer);
            displayArea.append("Customer added: " + customer + "\n");
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        }
    }

    private void editCustomer(ActionEvent e) {
        String id = idField.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the ID of the customer to edit.");
            return;
        }

        Customer existing = customerManager.findCustomerById(id);
        if (existing == null) {
            JOptionPane.showMessageDialog(this, "Customer not found.");
            return;
        }

        String firstName = nameField.getText();
        String lastName = lastNameField.getText();
        String company = companyField.getText();
        String status = (String) statusBox.getSelectedItem();

        if (firstName.isEmpty() || lastName.isEmpty() || company.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please complete all fields to edit.");
            return;
        }

        Customer updated = new Customer(firstName, lastName, id, company, status);
        customerManager.updateCustomer(updated);

        try {
            customerManager.saveCustomersToFile(FILE_PATH);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving changes: " + ex.getMessage());
        }

        JOptionPane.showMessageDialog(this, "Customer updated successfully.");
        listCustomers(null);
        clearFields();
    }

    private void listCustomers(ActionEvent e) {
        List<Customer> customers = customerManager.getCustomers();
        displayArea.setText("");
        for (Customer c : customers) {
            displayArea.append(c + "\n");
        }
    }

    private void filterCustomersByStatus(String statusFilter) {
        List<Customer> customers = customerManager.getCustomers();
        displayArea.setText("");
        for (Customer c : customers) {
            if (c.getStatus().equalsIgnoreCase(statusFilter)) {
                displayArea.append(c + "\n");
            }
        }
    }

    private void saveCustomersToFile(ActionEvent e) {
        try {
            customerManager.saveCustomersToFile(FILE_PATH);
            JOptionPane.showMessageDialog(this, "Clients saved in database: " + FILE_PATH);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
        }
    }

    private void clearFields() {
        nameField.setText("");
        lastNameField.setText("");
        idField.setText("");
        companyField.setText("");
        statusBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGUI::new);
    }
}
