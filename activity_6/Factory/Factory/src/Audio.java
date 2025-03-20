import java.util.Scanner;

public class Audio implements Media {
    private int sampleRate;

    @Override
    public void readMediaData() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la frecuencia de muestreo del audio (Hz): ");
        this.sampleRate = scanner.nextInt();
    }

    @Override
    public void play() { System.out.println("Reproduciendo audio..."); }
    @Override
    public void stop() { System.out.println("Deteniendo audio..."); }
    @Override
    public void pause() { System.out.println("Pausando audio..."); }
    @Override
    public void forward() { System.out.println("Avanzando audio..."); }
    @Override
    public void backward() { System.out.println("Retrocediendo audio..."); }

    @Override
    public String toString() {
        return "Audio [Frecuencia de muestreo: " + sampleRate + " Hz]";
    }
}
