class GoodMorning01 extends Thread {
    public void run() {
        System.out.println(getName() + " : Good Morning");
    }
}

class GoodAfternoon02 extends Thread {
    public void run() {
        System.out.println(getName() + " : Good Afternoon");
    }
}

class GoodNight03 extends Thread {
    public void run() {
        System.out.println(getName() + " : Good Night");
    }
}

public class ThreadPriority {
    public static void main(String[] args) {

        GoodMorning01 T1 = new GoodMorning01();
        GoodAfternoon02 T2 = new GoodAfternoon02();
        GoodNight03 T3 = new GoodNight03();

        // Set thread names
        T1.setName("Morning");
        T2.setName("Afternoon");
        T3.setName("Evening");


        T1.setPriority(Thread.MAX_PRIORITY);
        T2.setPriority(Thread.NORM_PRIORITY);
        T3.setPriority(Thread.MIN_PRIORITY);


        T1.start();
        T2.start();
        T3.start();

        System.out.println(T1.getName()+" "+T1.getPriority());
        System.out.println(T2.getName()+" "+T2.getPriority());
        System.out.println(T3.getName()+" "+T3.getPriority());

    }
}

