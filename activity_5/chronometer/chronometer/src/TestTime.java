public class TestTime {
    public static void main(String[] args) {
        Chronometer chronometer = new Chronometer();

        chronometer.showTime();  
        chronometer.start();
        
        chronometer.tick();
        chronometer.tick();
        chronometer.tick();

        chronometer.showTime();  
        
        chronometer.stop();
        chronometer.showTime();  
        
        chronometer.reset();
        chronometer.showTime();  
    }
}
