class GoodMorning extends Thread {
    public void run() {
        System.out.println(getName() + " : Good Morning");
    }
}

class GoodAfternoon extends Thread {
    public void run() {
        System.out.println(getName() + " : Good Afternoon");
    }
}

class GoodNight extends Thread {
    public void run() {
        System.out.println(getName() + " : Good Night");
    }
}

public class ThreadNames {
    public static void main(String[] args) {

        GoodMorning T1 = new GoodMorning();
        GoodAfternoon T2 = new GoodAfternoon();
        GoodNight T3 = new GoodNight();

        // Set thread names
        T1.setName("Morning");
        T2.setName("Afternoon");
        T3.setName("Evening");

        T1.start();
        T2.start();
        T3.start();
    }
}