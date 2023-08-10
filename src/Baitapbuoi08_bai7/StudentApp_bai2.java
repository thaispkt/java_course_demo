package Baitapbuoi08_bai7;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
2)	Xây dựng chương trình THEO HƯỚNG ĐỐI TƯỢNG cho phép người dùng nhập vào: Tên, Mã SV, điểm Toán, Lý Hóa. Cho phép
 nhập nhiều Sinh viên và thực hiện (Viết hàm tạo dữ liệu giả)
• Tính điểm trung bình từng sinh viên ( T + L + H)/3
• Xếp loại từng sinh viên theo: >=9 -> Xuất Sắc, 9<Giỏi<=8, 8<Khá<=7, <7<=6, <=5, còn lại Yếu. In ra danh sách theo mẫu
• In ra SV có ĐTB cao nhất. In ra danh sách theo mẫu
• In ra tất cả sinh viên Yếu. In ra danh sách theo mẫu
• Tìm sinh viên theo tên. In ra danh sách theo mẫu
• Tìm sinh viên theo mã. In ra danh sách theo mẫu
• Xóa 1 sinh viên theo mã
 */
public class StudentApp_bai2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the left new line character in buffer
        ArrayList<Student> students = new ArrayList<>();
        CreateDummyData(students, N);
        System.out.printf("%-20s %-10s %-15s %-15s %-15s\n", "Name", "ID", "Math mark", "Physic mark", "Chemistry " +
                "mark");
        for (Student student: students) {
            System.out.printf("%-20s %-10s %-15.2f %-15.2f %-15.2f\n", student.name, student.id, student.mathMark,
                    student.physicsMark, student.chemistryMark);
        }

        // In ra SV có ĐTB cao nhất. In ra danh sách theo mẫu
        System.out.println("Menu: ");
        System.out.println("1. Student ranking");
        System.out.println("2. Student with the top average score");
        System.out.println("3. List of students in weak rank");
        System.out.println("4. Enter the name of the student to search");
        System.out.println("5. Enter the student ID to search");
        System.out.println("6. Enter the student ID to delete");
        System.out.println("0. Exit");
        int choice;
        String studentIDSearch;
        do {
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Student Ranking:");
                    System.out.printf("%-20s %-10s %-15s %s%n", "Name", "ID", "Average Score", "Rank");
                    for (Student student : students) {
                        student.calcScoreAverage();
                        student.ranking();
                        System.out.printf("%-20s %-10s %-15.2f %s\n", student.name, student.id, student.averageScore, student.rank);
                    }
                    break;
                case 2:
                    System.out.println("Student with the highest average score:");
                    Student topScoreStudent = null;
                    double maxAverageScore = 0;
                    for (Student student : students) {
                        if (student.averageScore > maxAverageScore) {
                            maxAverageScore = student.averageScore;
                            topScoreStudent = student;
                        }
                    }
                    // Print the student with the top average score
                    if (topScoreStudent != null) {
                        System.out.println("\nStudent with the top average score:");
                        System.out.printf("%-20s %-10s %-15s %s\n", "Name", "ID", "Average Score", "Rank");
                        System.out.printf("%-20s %-10s %-15.2f %s\n", topScoreStudent.name, topScoreStudent.id,
                                topScoreStudent.averageScore, topScoreStudent.rank);
                    } else {
                        System.out.println("\nNo students found in the list.");
                    }

                    break;
                case 3:
                    // In ra tất cả sinh viên Yếu. In ra danh sách theo mẫu
                    System.out.println("List of students in weak rank");
                    for (Student student : students) {
                        if (student.rank.equals("Weak")) {
                            System.out.printf("%-20s %-10s %-15.2f %s\n", student.name, student.id,
                                    student.averageScore, student.rank);
                        }
                    }
                    break;
                case 4:
                    // Tìm sinh viên theo tên. In ra danh sách theo mẫu
                    System.out.print("Enter the name of the student to search: ");
                    String studentNameSearch = scanner.nextLine();
                    System.out.printf("%-20s %-10s %-15s %s%n", "Name", "ID", "Average Score", "Rank");
                    for (Student student : students) {
                        if (student.name.equals(studentNameSearch)) {
                            System.out.printf("%-20s %-10s %-15.2f %s\n", student.name, student.id,
                                    student.averageScore, student.rank);
                        }
                    }
                    break;
                case 5:
                    // Tìm sinh viên theo mã. In ra danh sách theo mẫu
                    System.out.print("Enter the ID of the student to search: ");
                    studentIDSearch = scanner.nextLine();
                    System.out.printf("%-20s %-10s %-15s %s%n", "Name", "ID", "Average Score", "Rank");
                    for (Student student : students) {
                        if (student.id.equals(studentIDSearch)) {
                            System.out.printf("%-20s %-10s %-15.2f %s\n", student.name, student.id,
                                    student.averageScore, student.rank);
                        }
                    }
                    break;
                case 6:
                    // Xóa 1 sinh viên theo mã
                    int studentRemovedIndex = -1;
                    System.out.print("Enter the student ID to delete: ");
                    String studentIDtoDelete = scanner.nextLine();

                    // Find and delete the student with the specified ID
                    boolean isStudentRemoved = false;
                    for (Student student : students) {
                        if (student.id.equals(studentIDtoDelete)) {
                            students.remove(student);
                            isStudentRemoved = true;
                            break;
                        }
                    }

                    // Print the updated list of students
                    if (isStudentRemoved) {
                        System.out.println("Student with ID " + studentIDtoDelete + " has been deleted.");
                    } else {
                        System.out.println("Student with ID " + studentIDtoDelete + " not found in the list.");
                    }

                    // Print the updated list of students after deletion
                    System.out.println("Updated list of students:");
                    System.out.printf("%-20s %-10s %-15s %-15s %-15s\n", "Name", "ID", "Math mark", "Physic mark",
                            "Chemistry mark");
                    for (Student student: students) {
                        System.out.printf("%-20s %-10s %-15.2f %-15.2f %-15.2f\n", student.name, student.id,
                                student.mathMark, student.physicsMark, student.chemistryMark);
                    }
                    break;
                case 0:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice. Try again:");
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }

    public static String generateRandomName() {
        Random random = new Random();
        String[] firstNames = {
                "Nguyễn", "Trần", "Lê", "Phạm", "Hồ", "Đỗ", "Huỳnh", "Phan", "Đặng", "Ngô",
                "Hoàng", "Võ", "Bùi"
        };
        String[] middleNames = {
                "Anh", "Chí", "Duy", "Hoàng", "Hương", "Khánh", "Minh",
                "Ngọc", "Quốc", "Thanh", "Thảo", "Trang", "Vân", "Việt", "Xuân", "Thị",
                "Văn", "Hữu", "Quang", "Thịnh"
        };
        String[] lastNames = {
                "Anh", "Bảo", "Bình", "Cường", "Đức", "Duy", "Hoàng", "Huy", "Nam",
                "Tuấn", "Việt", "Châu", "Chi", "Diệp", "Hương", "Linh", "Mai", "Ngọc",
                "Phương", "Quỳnh", "Trang", "Vân", "Hưng", "Trung", "Minh", "Hà", "Thành", "Quang"
        };

        String firstName = firstNames[random.nextInt(firstNames.length)];
        String middleName = middleNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];
        return firstName + " " + middleName + " " + lastName;
    }

    public static String generateRandomStudentID() {
        Random random = new Random();
        int randomNum = random.nextInt(900000) + 100000; // Generate a 6-digit number (100,000 to 999,999)
        return String.valueOf(randomNum);
    }

    public static double generateRandomMark() {
        Random random = new Random();
        // Generate a random integer from 0 to 50
        int randomNumber = random.nextInt(51);
        // Generate the mark with step resolution of 0.2
        double randomMark = randomNumber * 0.2;
        return randomMark;
    }

    public static void CreateDummyData(ArrayList<Student> students, int N) {
        for (int i = 0; i < N; i++) {
            String name = generateRandomName();
            String studentID = generateRandomStudentID();
            double mathScore = generateRandomMark();
            double physicsScore = generateRandomMark();
            double chemistryScore = generateRandomMark();
            students.add(new Student(name, studentID, mathScore, physicsScore, chemistryScore));
        }
    }
}