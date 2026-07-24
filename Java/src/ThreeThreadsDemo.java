class MorningThread extends Thread {
    public void run() {
        System.out.println("Good Morning");
    }
}

class AfternoonThread extends Thread {
    public void run() {
        System.out.println("Good Afternoon");
    }
}

class NightThread extends Thread {
    public void run() {
        System.out.println("Good Night");
    }
}

public class ThreeThreadsDemo {
    public static void main(String[] args) {
        MorningThread t1 = new MorningThread();
        AfternoonThread t2 = new AfternoonThread();
        NightThread t3 = new NightThread();

        t1.start();
        t2.start();
        t3.start();
    }
}