public abstract class Property {
    protected String address;
    protected double squareMeters;
    protected double basePrice;
    protected int age;

    public Property(String address, double squareMeters, double basePrice, int age) {
        this.address = address;
        this.squareMeters = squareMeters;
        this.basePrice = basePrice;
        this.age = age;
    }

    public double calculateFinalPrice() {
        double discount = (age < 25) ? 0.02 : 0.04;
        return basePrice * (1 - discount);
    }

    public abstract void showInfo();
}

