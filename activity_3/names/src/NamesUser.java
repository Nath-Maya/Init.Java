import java.util.Scanner;

public class NamesUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = new String[3];

        // Captura de los nombres
        for (int i = 0; i < names.length; i++) { 
            System.out.print("Ingrese el nombre " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }

        scanner.close();

        System.out.println("\nLista de usuarios:");
        for (String nombre : names) {
            String username = generarUsuario(nombre);
            System.out.println(username);
        }
    }

    
    public static String generarUsuario(String fullName) {
        String[] parts = fullName.trim().toLowerCase().split("\\s+");

        if (parts.length < 2) {
            return "Ingresar el nombre completo"; 
        }

         //Obtiene la primer palabara del nombre completo
        //Obtiene la primera letra de esa palabra

        char inicial = parts[0].charAt(0); 
        String lastName = parts[parts.length - 1]; 

        return inicial + lastName;
    }
}
