import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BakeryTest {
    private Map<String, Product> inventory;
    private double totalSales;

    public BakeryTest() {
        inventory = new HashMap<>();
        totalSales = 0;
    }

    // METODO PARA AÑADIR UN PRODUCTO AL INVENTARIO
    public void addProduct(String name, double price, String flavorOrSize, int quantity) {
        inventory.put(name, new Product(name, price, flavorOrSize, quantity));
    }

    // METODO PARA VENDER UN PRODUCTO
    public void sellProduct(String name, int quantity) {
        try {
            Product product = inventory.get(name);
            if (product != null) {
                product.sell(quantity);
                totalSales += product.getPrice() * quantity;
                System.out.println("Venta exitosa! Se vendieron " + quantity + " " + name);
            } else {
                System.out.println("Producto no encontrado.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // METODO PARA MOSTRAR EL INVENTARIO
    public void showInventory() {
        System.out.println("\nInventario actual:");
        for (Product product : inventory.values()) {
            System.out.println(product.getName() + " - " + product.getInventory() + " disponibles, Precio: $" + product.getPrice());
        }
    }

    // METODO PARA MOSTRAR EL TOTAL DE VENTAS
    public void showTotalSales() {
        System.out.println("\nTotal de ventas: $" + totalSales);
        for (Product product : inventory.values()) {
            System.out.println(product.getName() + " - " + product.getTotalSold() + " vendidos");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BakeryTest bakery = new BakeryTest();

        // AÑADIENDO PRODUCTOS AL INVENTARIO
        bakery.addProduct("Panqueso", 1.5, "Integral", 100);
        bakery.addProduct("Pandebono", 0.8, "Campesino", 50);
        bakery.addProduct("Pastel", 2.0, "Fresa", 30);
        bakery.addProduct("Postre", 3.0, "Vainilla", 20);

        while (true) {
            System.out.println("\nPASTEL PAN LA 52");
            System.out.println("Opciones:");
            System.out.println("1. Ver vitrina");
            System.out.println("2. Vender producto");
            System.out.println("3. Ver total de ventas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bakery.showInventory();
                    break;
                case 2:
                    System.out.print("Introduzca el nombre del producto a vender: ");
                    String productName = scanner.next();
                    System.out.print("Cantidad a vender: ");
                    int quantity = scanner.nextInt();
                    bakery.sellProduct(productName, quantity);
                    break;
                case 3:
                    bakery.showTotalSales();
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema Bakery Sistem");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        }
    }
}
