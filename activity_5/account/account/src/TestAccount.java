import java.util.Scanner;

public class TestAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Crea tu cuenta.");
        System.out.print("Ingresa tu nombre de usuario: ");
        String username = scanner.nextLine();

        // Validacion antes de generar cuenta
        if (!username.matches("^[a-zA-Z][a-zA-Z0-9]{0,15}$")) {
            System.out.println("Error: El nombre de usuario no cumple con las reglas.");
        } else {
            
            Account account = new Account(username);
            account.showAccount();
        }

        scanner.close();
    }
}
