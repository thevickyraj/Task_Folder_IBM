class publicVar {
    public int number01 = 199;
}
class privateVar{
    private int number02 = 299;
    public void privateMethod(){
        System.out.println(number02);
    }
}

class protectedVar{
    protected int number03 = 399;
}

public class PublicPrivateProtected {
    public static void main(String[] args) {
        publicVar pv = new publicVar();
        System.out.println("public variable "+pv.number01);

        privateVar privateVar = new privateVar();
        privateVar.privateMethod();

        protectedVar protectedVar = new protectedVar();
        System.out.println(protectedVar.number03);

    }
}
