class MyThread extends Thread {

    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("Thread running : " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        Thread.dumpStack();
    }
}

public class ThreadLoop {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();

        t1.start();
    }
}