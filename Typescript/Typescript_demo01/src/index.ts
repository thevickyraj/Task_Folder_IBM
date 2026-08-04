

const message: string = "Hello, TypeScript!";
console.log(message);


let a = "vicky";
console.log(a);

function greet(msg : string) : string {
    return msg;
}

console.log(greet("Hi Vicky"));

interface Student{
    id : number;
    name : string;
    age : number;
    address? : string
}

const student1 : Student = {
    id : 1,
    name : "vicky",
    age : 23
};

console.log(student1);


class Student {

    id: number = 0;
    name: string = "";

    constructor();
    constructor(name : string);
    constructor(name? : string){
        console.log("Parameterized constructor");
        
    }
}

// const s1 = new Student();
const s2 = new Student("vicky");

console.log(s2.id);
console.log(s2.name);


class Employee {

    public id: number;
    private salary: number;
    protected department: string;

    constructor(id: number, salary: number, department: string) {
        this.id = id;
        this.salary = salary;
        this.department = department;
    }

    public display(): void {
        console.log("Employee ID:", this.id);
        console.log("Salary:", this.salary);
        console.log("Department:", this.department);
    }
}

const emp = new Employee(101, 50000, "IT");

console.log(emp.id);       
emp.display();



function display<T>(value: T): T {
    return value;
}

console.log(display<number>(100));
console.log(display<string>("Vicky"));
console.log(display<boolean>(true));


// Example 2: Generic Class

class Student1<T> {

    value: T;

    constructor(value: T) {
        this.value = value;
    }

    display(): void {
        console.log(this.value);
    }
}

const s1 = new Student1<number>(101);
const s3 = new Student1<string>("Vicky");

s1.display();
s3.display();

