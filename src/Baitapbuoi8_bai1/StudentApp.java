package Baitapbuoi8_bai1;

public class StudentApp {
    public static void main(String[] args) {
        Student studentA = new Student("Nguyen Van Tuan",18,"men"); // Neu nhu class ko dinh nghia
//        Student studentA = new Student("Nguyen Van Tuan",18f,"men");
        // constructor thi JAVA tu
        // tao 1 ham constructor mac dinh
//        studenA.fullName = "Nguyen Van Tuan";
//        studenA.age = 18;
//        studenA.gender = "Men";
//        System.out.println("Name of student A: " + studenA.fullName);
//        System.out.println("Age of student A: "+ studenA.age);
        Student studentB = new Student("Tran Thi Thao",21,"women");
//        studenB.fullName = "Tran Thi Thao";
//        studenB.gender = "women";
//        System.out.println("Name of student B: " + studenB.fullName);
//        System.out.println("Age of student B: "+ studenB.age);
        studentA.printInfo();
        studentB.printInfo();
    }
}
