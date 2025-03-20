public class InheritanceTest {
    public static void main(String[] args) {
        Animal genericAnimal = new Animal("Animal generico");
        Dog dog = new Dog("Perro", 15.0);

        genericAnimal.emitSound();
        dog.emitSound();
    }
}
