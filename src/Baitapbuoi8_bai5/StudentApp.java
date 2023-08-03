package Baitapbuoi8_bai5;

public class StudentApp {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "Nguyen Duy Thai";
        student1.age = 35;
        Student student2 = new Student();
        student2.name = "Tran Van Tuan";
        student2.age = 28;
        System.out.println("Student 1: " + student1.name + ", age: " + student1.age);
        System.out.println("Student 2: " + student2.name + ", age: " + student2.age);
    }
}
