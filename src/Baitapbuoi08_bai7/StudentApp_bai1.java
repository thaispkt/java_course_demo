package Baitapbuoi08_bai7;

import java.util.Scanner;

/*
1)	Xây dựng chương trình cho phép người dùng nhập vào: Tên, Mã SV, điểm Toán, Lý Hóa. Thực hiện các nghiệp vụ dưới đây.
•	Tính điểm trung bình từng sinh viên ( T + L + H)/3
•	Xếp loại từng sinh viên theo: >=9 -> Xuất Sắc, 9<Giỏi<=8, 8<Khá<=7, <7<=6, <=5, còn lại Yếu.
 */
public class StudentApp_bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the left new line character in buffer
        Student[] students = new Student[N];
        for (int i = 0; i < students.length; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student id: ");
            String id = scanner.nextLine();
            System.out.print("Enter the student's math mark: ");
            double mathMark = scanner.nextDouble();
            System.out.print("Enter the student's physic mark : ");
            double physicsMark = scanner.nextDouble();
            System.out.print("Enter the student's chemistry mark : ");
            double chemistryMark = scanner.nextDouble();
            students[i] = new Student(name, id, mathMark, physicsMark, chemistryMark);
            scanner.nextLine();
        }
        System.out.println("Student Ranking:");
        System.out.printf("%-20s %-10s %-15s %s%n", "Name", "ID", "Average Score", "Rank");
        for (Student student : students) {
            student.calcScoreAverage();
            student.ranking();
            System.out.printf("%-20s %-10s %-15.2f %s%n", student.name, student.id, student.averageScore, student.rank);
        }
        scanner.close();
    }
}