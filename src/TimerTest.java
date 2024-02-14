import java.util.Timer;
import java.util.concurrent.TimeUnit;
public class TimerTest {
    public TimerTest(){

    }
    public void waittest () {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (java.lang.InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main (String[] args) {
        System.out.println("before timer");

        TimerTest myTimerTest = new TimerTest();
        myTimerTest.waittest();

        System.out.println("after timer");
    }
}
