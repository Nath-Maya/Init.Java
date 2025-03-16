public class TestTime {
    public static void main(String[] args) {
        Chronometer.showTime();
        Chronometer.start();
        
        Chronometer.tick();
        Chronometer.tick();
        Chronometer.tick();

        Chronometer.showTime();
        
        Chronometer.stop();
        Chronometer.showTime();
        
        Chronometer.reset();
        Chronometer.showTime();
    }
}
