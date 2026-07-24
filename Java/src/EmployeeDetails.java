
class Employee{
    int method1(){
        int age = 23;
        System.out.println(age);
        return age;
    }
}
class Manager extends Employee{
      void method2(){
          super.method1();
      }
}
public class EmployeeDetails {
    public static void main(String[] args) {
        Manager manager1 = new Manager();
        manager1.method2();
    }
}
