package Baitapbuoi8_bai6;

import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the left new line character left in the buff
        Student [] students = new Student[n];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            System.out.print("Enter student name: ");
            students[i].name = scanner.nextLine();
            System.out.print("Enter student age: ");
            students[i].age = scanner.nextInt();
            scanner.nextLine(); // Consume the left new line character left in the buffer
        }
        for (int i = 0; i < students.length; i++) {
            System.out.println("Student name: " + students[i].name + ", age: " + students[i].age);
        }
        scanner.close();
    }
}
