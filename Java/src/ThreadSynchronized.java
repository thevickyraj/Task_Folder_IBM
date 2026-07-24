class Increment extends Thread {

    static int count = 0;

    synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " : " + count);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            increment();
        }
    }
}

public class ThreadSynchronized {
    public static void main(String[] args) {

        Increment t1 = new Increment();
        Increment t2 = new Increment();

        t1.setName("Thread 1");
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}