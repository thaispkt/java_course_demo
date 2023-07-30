package Baitapbuoi8_bai5;
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
• Tìm sinh viên theo mã
• Xóa 1 sinh viên theo mã
 */
public class StudentApp_bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the left new line character in buffer
        Student2[] students = new Student2[N];
        CreateDummyData(students);
//        System.out.printf("%-20s %-10s %-15s %-15s %-15s\n", "Name", "ID", "Math mark", "Physic mark", "Chemistry " +
//                "mark");
//        for (Student2 student: students) {
//            System.out.printf("%-20s %-10s %-15.2f %-15.2f %-15.2f\n", student.name, student.id, student.mathMark,
//                    student.physicsMark, student.chemistryMark);
//        }
        System.out.println("Student Ranking:");
        System.out.printf("%-20s %-10s %-15s %s%n", "Name", "ID", "Average Score", "Rank");
        for (Student2 student: students) {
            student.calcScoreAverage();
            student.ranking();
            System.out.printf("%-20s %-10s %-15.2f %s\n", student.name, student.id, student.averageScore, student.rank);
        }
        scanner.close();
    }
    public static String generateRandomName() {
        Random random = new Random();
        String[] firstNames = {
                "Nguyễn", "Trần", "Lê", "Phạm", "Hồ", "Đỗ", "Huỳnh", "Phan", "Đặng", "Ngô",
                "Hoàng", "Võ", "Bùi"
        };
        String[] middleNames = {
                "Anh",  "Chí", "Duy", "Đức", "Hoàng", "Hương", "Khánh", "Linh", "Minh",
                "Ngọc", "Quốc", "Thanh", "Thảo", "Thi", "Trang", "Vân", "Việt", "Xuân", "Thị",
                "Văn", "Hữu", "Quang", "Thịnh"
        };
        String[] lastNames = {
                "Anh", "Bảo", "Bình", "Cường", "Đức", "Duy", "Hoàng", "Huy", "Minh", "Nam",
                 "Tuấn", "Việt", "Châu", "Chi", "Diệp", "Hương", "Linh", "Mai", "Ngọc",
                "Phương", "Quỳnh", "Trang", "Vân", "Hưng", "Trung", "Minh", "Hà", "Thành", "Quang"
        };

        String firstName = firstNames[random.nextInt(firstNames.length-1)];
        String middleName = middleNames[random.nextInt(firstNames.length-1)];
        String lastName = lastNames[random.nextInt(lastNames.length-1)];
        return firstName + " " + middleName + " "+ lastName;
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
    public static void CreateDummyData(Student2[] students) {
        for (int i = 0; i < students.length; i++) {
            String name = generateRandomName();
            String studentID = generateRandomStudentID();
            double mathScore = generateRandomMark();
            double physicsScore = generateRandomMark();
            double chemistryScore = generateRandomMark();
            students[i] = new Student2(name, studentID, mathScore, physicsScore, chemistryScore);
        }
    }
}