package Baitapbuoi08;
/*
Viết chương trình JAVA OOP quản lý sinh viên đơn giản: Nhập, xuất thông tin, tính điểm TB.
- Viết lớp Sinh viên như sau:
Attributes (private):
- Mã sinh viên là số nguyên.
- Họ tên: chuỗi ký tự.
- Điểm LT, điểm TH : float
Constructor:
- Constructor mặc định (để khởi tạo đối tượng với các thông tin kiểu số là 0, kiểu chuỗi là chuỗi rỗng).
- Constructor thứ hai nhận đầy đủ thông tin để khởi tạo giá trị cho tất cả các biến instance.
Methods:
- Các getter và setter cho mỗi thuộc tính.
- Tính điểm trung bình.
- Phương thức toString để diễn tả đối tượng ở dạng chuỗi.

sv1 chứa thông tin của chính mình (tạo bằng constructor đủ thông số, thông tin biết rồi khỏi nhập từ bàn phím).
- sv2 là thông tin người bạn thân nhất của em (tạo bằng constructor đủ thông số, thông tin biết rồi khỏi nhập từ bàn
 phím).
- sv3 tạo bằng constructor mặc định. Nhập các thông tin cho sv3 từ bàn phím rồi sau đó dùng các setter để gán vào cho
  các thuộc tính tương ứng.
 */
import java.util.Scanner;

public class Baitapbuoi8_bai3 {
    public static void main(String[] args) {
        Student sv1 = new Student(753159, "Nguyễn Thanh An", 7, 6);
        Student sv2 = new Student(381729, "Lê Thành Đạt", 9, 8);
        Student sv3 = new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID for sv3: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name for sv3: ");
        String name = scanner.nextLine();

        System.out.print("Enter theory score for sv3: ");
        float theoryScore = scanner.nextFloat();

        System.out.print("Enter practice score for sv3: ");
        float practiceScore = scanner.nextFloat();

        // Use setters to assign the corresponding properties for sv3
        sv3.setId(id);
        sv3.setName(name);
        sv3.setTheoryScore(theoryScore);
        sv3.setPracticeScore(practiceScore);

        System.out.println("sv1 info:");
        System.out.println(sv1.toString());
        System.out.println("Average score: " + sv1.calcAverageScore());

        System.out.println("sv2 info:");
        System.out.println(sv2.toString());
        System.out.println("Average score: " + sv2.calcAverageScore());

        System.out.println("sv3 info:");
        System.out.println(sv3.toString());
        System.out.println("Average score: " + sv3.calcAverageScore());

        scanner.close();
    }
}
