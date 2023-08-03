package Baitapbuoi8_bai3;

public class Student {
    String fullName;
    int age;
    float gpa;
    String gender;
    // Dinh nghia phuong thuoc khoi tao (constructor)
    // public ClassName() {logic code}
    public  Student( String fullName, int age, String gender) {
        // logic code
        this.fullName = fullName; // Student.fullname = fullname
        this.age = age;
        this.gender = gender;
    }
    public  Student( String fullName, float gpa, String gender) {
        // logic code
        this.fullName = fullName; // Student.fullname = fullname
        this.gpa = gpa;
        this.gender = gender;
    }
    public void printInfo() {
        System.out.println("Full name: "+ fullName);
        System.out.println("Age: " + age);
        System.out.println("Gender: "+ gender);
    }
}
