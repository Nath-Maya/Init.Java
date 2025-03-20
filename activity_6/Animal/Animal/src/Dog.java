public class Dog extends Animal {
    double radius;

    public Dog(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public void emitSound() {
        System.out.println(name + " ladrar: ¡Guauuu, guauuu");
    }
}
