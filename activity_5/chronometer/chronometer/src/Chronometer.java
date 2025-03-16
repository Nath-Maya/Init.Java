public class Chronometer {
    private static int hours = 0;
    private static int minutes = 0;
    private static int seconds = 0;
    private static boolean running = false;

    public static void start() {
        running = true;
        System.out.println("Cronometro iniciado.");
    }

    public static void stop() {
        running = false;
        System.out.println("Cronometro detenido.");
    }

    public static void reset() {
        hours = 0;
        minutes = 0;
        seconds = 0;
        System.out.println("Cronometro reseteado.");
    }

    public static void tick() {
        if (running) {
            seconds++;
            if (seconds == 60) {
                seconds = 0;
                minutes++;
                if (minutes == 60) {
                    minutes = 0;
                    hours++;
                }
            }
        }
    }

    public static void showTime() {
        System.out.printf("Tiempo: %02d:%02d:%02d\n", hours, minutes, seconds);
    }
}
