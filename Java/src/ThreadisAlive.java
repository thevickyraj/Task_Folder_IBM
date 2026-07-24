class IsAlive extends Thread {

    public void run() {
        System.out.println("Thread is running...");

        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread completed");
    }
}

public class ThreadisAlive {
    public static void main(String[] args) {

        IsAlive t1 = new IsAlive();

        // Check status before starting thread
        System.out.println("Before start: " + t1.isAlive());

        t1.start();

        // Check status after starting thread
        System.out.println("After start: " + t1.isAlive());

        try {
            t1.join(); // Wait for thread to finish
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // Check status after thread completes
        System.out.println("After completion: " + t1.isAlive());
    }
}
