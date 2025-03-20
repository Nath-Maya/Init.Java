public class Apartment extends Property {
    private int floor;

    public Apartment(String address, double squareMeters, double basePrice, int age, int floor) {
        super(address, squareMeters, basePrice, age);
        this.floor = floor;
    }

    @Override
    public double calculateFinalPrice() {
        double price = super.calculateFinalPrice();
        if (floor >= 3) {
            price *= 1.05; // Aumento del 5% si es tercer piso o más
        }
        return price;
    }

    @Override
    public void showInfo() {
        System.out.println("Piso ubicado en: " + address + ", Piso: " + floor + ", Precio final: " + calculateFinalPrice());
    }
}