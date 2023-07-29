package Baitapbuoi5;

import java.util.Scanner;

//5.	Nhập tên và năm sinh của 3 sinh viên. Hãy viết chương trình xuất ra tên và năm sinh của sinh viên trẻ nhất.
public class Baitapbuoi5_bai5 {
    private static final int STUDENT_NUM_MAX = 3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student1[] students = new Student1[STUDENT_NUM_MAX];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student1();
            System.out.print("Enter name of student " + (i + 1) + ": ");
            students[i].name = scanner.nextLine();
            System.out.print("Enter birth year of student " + (i + 1) + ": ");
            students[i].birthYear = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left in the buffer
        }
        int birthYearMin = students[0].birthYear;;
        int birthYearMinIndex = 0;
        for (int i = 1; i < students.length; i++) {
            if (students[i].birthYear < birthYearMin) {
                birthYearMin = students[i].birthYear;
                birthYearMinIndex = i;
            }
        }
        System.out.println("The youngest student: " + students[birthYearMinIndex].name + ", birth year: "
                + students[birthYearMinIndex].birthYear);
        scanner.close();
    }
}


