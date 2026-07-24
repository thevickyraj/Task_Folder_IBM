//
//class Employee01{
//    void details(){
//        int age = 23;
//        System.out.println(age);
//    }
//}
//
//class Manager01 extends Employee01{
//
//    @Override
//    void details() {
//        super.details();
//    }
//}
//
//public class Upcasting {
//    public static void main(String[] args) {
//        Employee01 emp1 = new Employee01();
//        emp1.details();
//        Manager01 m01 = new Manager01();
//        m01.details();
//        Employee01 empMa = new Manager01();
//        empMa.details();
//    }
//}

class Employee01 {
    public int age = 23;
    int method1() {
        int age = 23;
        System.out.println(age);
        return age;
    }
}
    class Employee02 {
        void method1() {
            int age = 200;
            System.out.println(age);
        }
    }

        class Manager01 extends Employee02 {
            void method2() {
                super.method1();
            }

        }

        public class EmployeeDetails01 {
            public static void main(String[] args) {
                Manager01 manager1 = new Manager01();
                manager1.method2();
            }

        }
