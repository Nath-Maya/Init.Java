import java.util.Scanner;

public class PrintPlanner {

    // Uso el metodo para tipo de dato string convertirlo en MAYUSCULA
    public static String convertUppercase(String text) {
        return text.toUpperCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingreso tipo del producto
        System.out.println("------ // PRINT PLANNER // -----");
        System.out.println("You can calculate how much material you require for the production of flyers, brochures, business cards, postcards.");
        System.out.print("Product: ");
        String productName = scanner.nextLine();
        String jobName = convertUppercase(productName); 

        // Ingreso de la cantidad
        System.out.print("Enter the amount you want to plan: ");
        int quantity = scanner.nextInt();

        // Ingreso de las dimensiones como flotantes
        System.out.print("Product width: ");
        float widthSize = scanner.nextFloat();

        System.out.print("Product height: ");
        float heightSize = scanner.nextFloat();

        // Area del pliego estandar (19x25)
        float sheetWidth = 19;
        float sheetHeight = 25;
        float totalSheetArea = sheetWidth * sheetHeight;

        // Area del producto
        float productArea = widthSize * heightSize;

        // Validacion de si el tamaño esta dentro del tamaño maximo.
        if (widthSize > sheetWidth || heightSize > sheetHeight) {
            System.out.println("ERROR: Size exceeds the maximum allowed for printing.");
        } else {
            // Calcular cantidad de imposiciones por pliego
            int productsPerSheet = (int) (totalSheetArea / productArea);

            // Calcular area utilizada y area sobrante
            float usedArea = productsPerSheet * productArea;
            float remainingArea = totalSheetArea - usedArea;

            // Calcular porcentaje de papel no usado
            double paperWaste = ((double) remainingArea / totalSheetArea) * 100;

            // Calcular cantidad de hojas necesarias de 19x25
            int requiredSheets = (int) Math.ceil((double) quantity / productsPerSheet);

            // Mostrar las especificaciones del producto
            System.out.println("\n--- SPECS ---");
            System.out.println("Job Name: " + jobName);
            System.out.println("Quantity: " + quantity);
            System.out.println("Width: " + widthSize);
            System.out.println("Height: " + heightSize);

            // Mostrar detalles de planeacion 
            System.out.println("\n--- DETAILS ---");
            System.out.println("Imposicions 19x25 sheet: " + productsPerSheet);
            System.out.printf("Paper waste (19x25): %.2f%% \n", paperWaste);
            System.out.println("Total sheets required: " + requiredSheets);
        }

        scanner.close();
    }
}
