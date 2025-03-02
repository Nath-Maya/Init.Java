import java.util.Scanner;

public class CesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario el texto a cifrar o descifrar
        System.out.print("CIFRADO CESAR. Ingrese un texto y una code de cifrado que debe ser un numero para cifrar el texto ingresado o en su defecto, decifrarlo. ");
        System.out.print("Ingrese un texto: ");
        String texto = scanner.nextLine();

        // La code de cifrado se usara para obtener el numero de desplazamiento. 
        System.out.print("Ingrese la clave de cifrado: ");
        int code = scanner.nextInt();
        

        scanner.nextLine();

        // Solicitar si se desea cifrar o descifrar
        System.out.print("Seleccion que desea hacer: cifrar (C) o descifrar (D)?: ");
        char opcion = scanner.nextLine().toUpperCase().charAt(0);
        
        scanner.close();

        String result;
        if (opcion == 'C') {
            result = encryptText(texto, code);
            System.out.println("CIFRADO: " + result);
        } else if (opcion == 'D') {
            result = encryptText(texto, -code); 
            System.out.println("DESCIFRADO: " + result);
        } else {
            System.out.println("Opción no válida. Debe ser 'C' o 'D'.");
        }
    }

    public static String encryptText(String texto, int code) {
        StringBuilder result = new StringBuilder();

        for (char character : texto.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char newCharacter = (char) ((character - base + code + 26) % 26 + base);
                result.append(newCharacter);
            } else {
                result.append(character); 
            }
        }
        return result.toString();
    }
}
