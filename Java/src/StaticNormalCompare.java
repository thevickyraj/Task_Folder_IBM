
class Counter{
    static int staticCount = 0;
    int normalCount = 0;

    void increment(){
        staticCount++;
        normalCount++;
        System.out.println("staticCount "+ staticCount);
        System.out.println("normalCount "+ normalCount );
    }
}

public class StaticNormalCompare {
    public static void main(String[] args) {
        Counter obj1 = new Counter();
        Counter obj2 = new Counter();
        System.out.println("Object 1 value");
        obj1.increment();

        System.out.println("Object 1 value again");
        obj1.increment();

        System.out.println("Object 2 value");
        obj2.increment();

    }

}
