import java.util.Scanner;

public class Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // INPUT del usuario
        System.out.print("Por favor ingrese un number del 1 al 100: ");
        int number = scanner.nextInt();

        scanner.close();

        // Validacion para garantizar que el number ingresado por el usuario este dentro
        // del rango de 1 a 100
        if (number < 1 || number > 100) {
            System.out.println("number no permitido. Debe ser entre 1 y 100.");
        } else {
            // Convertimos el número en palabras y lo mostramos en pantalla
            System.out.println("El numero convertido en palabras es: " + numToWords(number));
        }
    }

    // Método para convertir el number en palabras
    public static String numToWords(int number) {

        String[] units = { "", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve" };
        String[] especiales = { "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete",
                "dieciocho", "diecinueve" };
        String[] tens = { "", "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta",
                "noventa" };

        if (number == 100) {
            return "cien";
        }

        if (number < 10) {
            return units[number];
        }

        if (number < 20) {
            return especiales[number - 10];
        }

        if (number % 10 == 0) {
            return tens[number / 10];
        }

        int decena = number / 10;
        int unidad = number % 10;

        return tens[decena] + " y " + units[unidad];
    }
}
