import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class BinaryCounter {
    private int counter;

    public BinaryCounter() {
        this.counter = 0;
    }

    public void printBinaryWithTimer() {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Convert the counter to an 8-bit binary representation
                String binaryRepresentation = convertToBinary(counter, 8);

                // Print the binary representation
                System.out.println(binaryRepresentation);

                // Increment the counter
                counter++;

                // Check if all values are printed
                if (counter >= 256) {
                    timer.cancel();
                    System.out.println("Binary counter printing completed.");
                }
            }
        };

        // Schedule the task to run every 2 seconds
        timer.scheduleAtFixedRate(task, 0, 2000);
    }

    private String convertToBinary(int number, int length) {
        // Convert the decimal number to binary representation with leading zeros
        String binary = Integer.toBinaryString(number);
        return String.format("%" + length + "s", binary).replace(' ', '0');
    }

    public static void main(String[] args) {
        System.out.println("Binary counter printing started.");

        BinaryCounter binaryCounter = new BinaryCounter();
        binaryCounter.printBinaryWithTimer();
    }
}
