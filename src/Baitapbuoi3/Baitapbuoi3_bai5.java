package Baitapbuoi3;//Hãy viết chương trình Chào Hỏi các thành viên của gia đình có đặc điểm sau đây: đầu tiên máy sẽ hỏi ai đang sử dụng máy. Sau đó căn cứ vào câu trả lời nhận được mà máy cần  đưa ra một câu chào hợp lý, dễ thương. Giả sử trong gia đình có 4 thành viên là : Bố (B), Mẹ (H), anh trai (A) và em gái (E)

import java.util.Scanner;
public class Baitapbuoi3_bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ai đang sử dụng máy tính này ? (B/H/A/E): ");
        String user = scanner.next();

        if (user.equalsIgnoreCase("B")) {
            System.out.println("Con chào bố ạ");
        } else if (user.equalsIgnoreCase("H")) {
            System.out.println("Con chào mẹ, nóc ngôi nhà ạ");
        } else if (user.equalsIgnoreCase("A")) {
            System.out.println("Em chào anh trai ki bo ạ");
        } else if (user.equalsIgnoreCase("E")) {
            System.out.println("Anh chào em gái xí xọn");
        } else {
            System.out.println("Xin lỗi, tôi không nhận ra thành viên gia đình");
        }
        scanner.close();
    }
}
