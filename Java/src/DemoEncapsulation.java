
class Student{
    private String  name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class DemoEncapsulation {
    public static void main(String[] args) {
        Student st = new Student();
        st.setName("Vicky");
        st.setAge(23);
        System.out.println(st.getName());
        System.out.println(st.getAge());
        System.out.println(st.getClass());

    }
}
