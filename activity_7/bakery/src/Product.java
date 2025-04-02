
public class Product {
    private String name;
    private double price;
    private String flavorOrSize;
    private int inventory;
    private int totalSold;

    public Product(String name, double price, String flavorOrSize, int inventory) {
        this.name = name;
        this.price = price;
        this.flavorOrSize = flavorOrSize;
        this.inventory = inventory;
        this.totalSold = 0;
    }

    // METODO PARA VENDER UN PRODUCTO
    public void sell(int quantity) throws Exception {
        if (quantity <= 0) {
            throw new Exception("Cantidad debe ser mayor que cero.");
        }
        if (quantity > inventory) {
            throw new Exception("No hay suficiente inventario de " + name);
        }
        inventory -= quantity;
        totalSold += quantity;
    }

    // GETTERS Y SETTERS
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getFlavorOrSize() {
        return flavorOrSize;
    }

    public int getInventory() {
        return inventory;
    }

    public int getTotalSold() {
        return totalSold;
    }
}

