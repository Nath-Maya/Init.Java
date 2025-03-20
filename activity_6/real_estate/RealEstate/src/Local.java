public class Local extends Property {
    private int windows;

    public Local(String address, double squareMeters, double basePrice, int age, int windows) {
        super(address, squareMeters, basePrice, age);
        this.windows = windows;
    }

    @Override
    public double calculateFinalPrice() {
        double price = super.calculateFinalPrice();
        if (squareMeters > 50) {
            price *= 1.02; // Aumento del 2% si tiene más de 50m²
        }
        if (windows <= 1) {
            price *= 0.97; // Descuento del 3% si tiene 1 o ningún ventanal
        } else if (windows > 4) {
            price *= 1.03; // Aumento del 3% si tiene más de 4 ventanales
        }
        return price;
    }

    @Override
    public void showInfo() {
        System.out.println("Local ubicado en: " + address + ", Ventanas: " + windows + ", Precio final: " + calculateFinalPrice());
    }
}