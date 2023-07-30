package Baitapbuoi8_bai5;

import java.util.Scanner;

/*
1)	Xây dựng chương trình cho phép người dùng nhập vào: Tên, Mã SV, điểm Toán, Lý Hóa. Thực hiện các nghiệp vụ dưới đây.
•	Tính điểm trung bình từng sinh viên ( T + L + H)/3
•	Xếp loại từng sinh viên theo: >=9 -> Xuất Sắc, 9<Giỏi<=8, 8<Khá<=7, <7<=6, <=5, còn lại Yếu.
 */
public class StudentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the left new line character in buffer
        Student[] students = new Student[N];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            System.out.print("Enter student name: ");
            students[i].name = scanner.nextLine();
            System.out.print("Enter student id: ");
            students[i].id = scanner.nextLine();
            System.out.print("Enter the student's math mark: ");
            students[i].mathMark = scanner.nextInt();
            System.out.print("Enter the student's physic mark : ");
            students[i].physicsMark = scanner.nextInt();
            System.out.print("Enter the student's chemistry mark : ");
            students[i].chemistryMark = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Student Ranking:");
        System.out.printf("%-20s %-10s %-15s %s%n", "Name", "ID", "Average Score", "Rank");
        for (Student student: students) {
            student.calcScoreAverage();
            student.ranking();
            System.out.printf("%-20s %-10s %-15.2f %s%n", student.name, student.id, student.averageScore, student.rank);
        }
        scanner.close();
    }
}