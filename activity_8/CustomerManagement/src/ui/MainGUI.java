package ui;

import model.Customer;
import service.CustomerManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainGUI extends JFrame {

    // MANEJADOR DE CLIENTES
    private CustomerManager customerManager;

    // COMPONENTES DE LA INTERFAZ
    private JTextField nameField, lastNameField, idField, companyField;
    private JComboBox<String> statusBox;
    private JTextArea displayArea;

    public MainGUI() {
        // INICIALIZAR MANEJADOR
        customerManager = new CustomerManager();

        // CONFIGURAR VENTANA PRINCIPAL
        setTitle("Customer Manager");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // PANEL SUPERIOR CON CAMPOS DE ENTRADA
        JPanel inputPanel = new JPanel(new GridLayout(7, 2)); // 7 filas para incluir botón extra

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

        JButton listButton = new JButton("List Customers");
        listButton.addActionListener(this::listCustomers);
        inputPanel.add(listButton);

        JButton saveButton = new JButton("Save Customers");
        saveButton.addActionListener(this::saveCustomersToFile);
        inputPanel.add(saveButton);

        add(inputPanel, BorderLayout.NORTH);

        // ÁREA DE TEXTO PARA MOSTRAR CLIENTES
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // HACER VISIBLE
        setVisible(true);
    }

    private void addCustomer(ActionEvent e) {
        String firstName = nameField.getText();
        String lastName = lastNameField.getText();
        String id = idField.getText();
        String company = companyField.getText();
        String status = (String) statusBox.getSelectedItem();

        if (!firstName.isEmpty() && !lastName.isEmpty() && !id.isEmpty() && !company.isEmpty()) {
            Customer customer = new Customer(firstName, lastName, id, company, status);
            customerManager.addCustomer(customer);
            displayArea.append("Customer added: " + customer + "\n");
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        }
    }

    private void listCustomers(ActionEvent e) {
        List<Customer> customers = customerManager.getCustomers();
        displayArea.setText(""); // Limpiar el área
        for (Customer c : customers) {
            displayArea.append(c + "\n");
        }
    }

    private void saveCustomersToFile(ActionEvent e) {
        String path = "customers.txt"; // Puedes personalizar esta ruta
        try {
            customerManager.saveCustomersToFile(path);
            JOptionPane.showMessageDialog(this, "Clients saved in database: " + path);
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
