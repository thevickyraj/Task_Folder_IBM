class MorningThread1 extends Thread {
    public void run() {
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
            System.out.println("Good Morning");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class AfternoonThread2 extends Thread {
    public void run() {
        try {
            Thread.sleep(1000); // Sleep for 1 seconds
            System.out.println("Good Afternoon");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class NightThread3 extends Thread {
    public void run() {
        try {
            Thread.sleep(0); // Sleep for 0 seconds
            System.out.println("Good Night");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreeThreadsDemoSeconds {
    public static void main(String[] args) {
        MorningThread1 t1 = new MorningThread1();
        AfternoonThread2 t2 = new AfternoonThread2();
        NightThread3 t3 = new NightThread3();

        t1.start();
        t2.start();
        t3.start();
    }
}