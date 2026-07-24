class Addition{
    int add(int a, int b){
        return a+b;
    }
    int add(char a, int b){
        return a+b;
    }
    double add(double a, int b){
        return a+b;
    }
    float add(int a, float b){
        return a+b;
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
       Addition add = new Addition();
        System.out.println(add.add(1,2));
        System.out.println(add.add('1', 9));
        System.out.println(add.add(1,3.66f));
        System.out.println(add.add(2.2,89));

    }
}
