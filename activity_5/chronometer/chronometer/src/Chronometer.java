public class Chronometer {
    private int hours;
    private int minutes;
    private int seconds;
    private boolean running;

    public Chronometer() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
        this.running = false;
    }

    public void start() {
        running = true;
        System.out.println("Cronometro iniciado.");
    }

    public void stop() {
        running = false;
        System.out.println("Cronometro detenido.");
    }

    public void reset() {
        hours = 0;
        minutes = 0;
        seconds = 0;
        System.out.println("Cronometro reseteado.");
    }

    public void tick() {
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

    public void showTime() {
        System.out.printf("Tiempo: %02d:%02d:%02d\n", hours, minutes, seconds);
    }
}
