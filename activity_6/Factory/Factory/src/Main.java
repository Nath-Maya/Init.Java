import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione tipo de media (1: Video, 2: Audio): ");
        int choice = scanner.nextInt();

        Media media = Factory.create(choice);
        if (media != null) {
            System.out.println("Objeto creado: " + media);
            media.play();
        } else {
            System.out.println("Opción inválida. No se creó ningún objeto.");
        }
        scanner.close();
    }
}
