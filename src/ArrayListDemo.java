package Baitapbuoi8_bai5;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<StudentBK> students = new ArrayList<>();

        // Create and add some sample students to the list
        students.add(new StudentBK("John", "123", 3.8));
        students.add(new StudentBK("Alice", "456", 3.9));
        students.add(new StudentBK("Bob", "789", 3.6));

        System.out.println("List of students:");
        for (StudentBK student : students) {
            System.out.println(student.name + " - ID: " + student.id + " - GPA: " + student.GPA);
        }

        // Find the student with the largest GPA
        StudentBK studentWithLargestGPA = null;
        double maxGPA = Double.MIN_VALUE;
        for (StudentBK student : students) {
            if (student.GPA > maxGPA) {
                maxGPA = student.GPA;
                studentWithLargestGPA = student;
            }
        }

        // Print the student with the largest GPA
        if (studentWithLargestGPA != null) {
            System.out.println("\nStudent with the largest GPA:");
            System.out.println(studentWithLargestGPA.name + " - ID: " + studentWithLargestGPA.id + " - GPA: " + studentWithLargestGPA.GPA);
        } else {
            System.out.println("\nNo students found in the list.");
        }
    }
}

class StudentBK {
    String name;
    String id;
    double GPA;

    public StudentBK(String name, String id, double GPA) {
        this.name = name;
        this.id = id;
        this.GPA = GPA;
    }
}
