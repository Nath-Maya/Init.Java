import java.util.Scanner;

public class Video implements Media {
    private char ratioFormat;

    @Override
    public void readMediaData() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el formato de ratio del video (Ej: 16:9, 4:3): ");
        this.ratioFormat = scanner.next().charAt(0);
    }

    @Override
    public void play() { System.out.println("Reproduciendo video..."); }
    @Override
    public void stop() { System.out.println("Deteniendo video..."); }
    @Override
    public void pause() { System.out.println("Pausando video..."); }
    @Override
    public void forward() { System.out.println("Avanzando video..."); }
    @Override
    public void backward() { System.out.println("Retrocediendo video..."); }

    @Override
    public String toString() {
        return "Video [Formato de ratio: " + ratioFormat + "]";
    }
}
