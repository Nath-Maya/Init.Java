import java.security.SecureRandom;
import java.util.regex.Pattern;

public class Account {
    private String username;
    private String password;
    
    // Expresión regular para validar username
    private static final String USERNAME_REGEX = "^[a-zA-Z][a-zA-Z0-9]{0,15}$";
    
    // Caracteres para generar el password
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIALS = "*,-,+,/";
    private static final String ALL_CHARS = UPPERCASE + LOWERCASE + NUMBERS + SPECIALS;

    // Constructor
    public Account(String username) {
        if (!isValidUsername(username)) {
            throw new IllegalArgumentException("Error: El nombre de usuario no cumple con las reglas.");
        }
        this.username = username;
        this.password = generatePassword();
    }

    // Valida si el username cumple con las reglas
    private boolean isValidUsername(String username) {
        return Pattern.matches(USERNAME_REGEX, username);
    }

    // Genera un password seguro
    private String generatePassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Asegurar que tenga al menos un caracter de cada tipo
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        password.append(SPECIALS.charAt(random.nextInt(SPECIALS.length())));

        // Completar el resto del password con caracteres aleatorios
        for (int i = 4; i < 9; i++) {
            password.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
        }

        // Mezclar los caracteres para mayor seguridad
        return shuffleString(password.toString());
    }

    // Mezcla los caracteres del password generado
    private String shuffleString(String str) {
        char[] characters = str.toCharArray();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }

    // Métodos para obtener los datos
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Método para mostrar la cuenta creada
    public void showAccount() {
        System.out.println("Cuenta creada con exito!");
        System.out.println("Usuario: " + username);
        System.out.println("Password generado: " + password);
    }
}
