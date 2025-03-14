import java.util.Scanner;

public class TestMotorcycle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Creación de la moto
        Motorcycle moto = new Motorcycle("Azul", "Discover", 2024, 0.05, 14, 5);
        
        while (true) {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Informacion de la moto");
            System.out.println("2. Rodar");
            System.out.println("3. Tanquear");
            System.out.println("4. Salir");
            System.out.print("Elegir una opcion: ");
            
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    moto.showData();
                    break;
                case 2:
                    System.out.print("Cuantos kms quieres  recorrer: ");
                    int distancia = scanner.nextInt();
                    double kmRestantes = moto.run(distancia);
                    System.out.println("Recorrido finalizado. Km restantes: " + kmRestantes);
                    break;
                case 3:
                    System.out.print("Ingresa los litros a llenar: ");
                    int litros = scanner.nextInt();
                    int sobrante = moto.fillTank(litros);
                    if (sobrante > 0) {
                        System.out.println("Se lleno el tanque y sobraron " + sobrante + " litros.");
                    } else {
                        System.out.println("Tanque llenado correctamente.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no permitida.");
            }
        }
    }
}

