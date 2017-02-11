import java.util.Scanner;

/**
 * Created by tgulati on 8/29/16.
 */
class Processor extends Thread {

    private volatile boolean running = true;

    @Override
    public void run() {
        while(running) {
            System.out.println("Hello, world!");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void shutdown() {
        running = false;
    }
}

public class Class3 {

    public static void main(String... args) {
        Processor p1 = new Processor();

        p1.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        p1.shutdown();
    }
}
