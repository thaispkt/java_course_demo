package Baitapbuoi03;//4. Viết chương trình cho phép nhập vào số nguyên có hai chữ số. Hãy in ra cách đọc của số nguyên này.
import java.util.Scanner;
public class Baitapbuoi3_bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a two-digit number: ");
        int n = scanner.nextInt();

        if (n >= 10 && n <= 99) {
            int chuSoHangChuc = n / 10;
            int chuSoHangDonVi = n % 10;

            String result = "";
            if (chuSoHangChuc == 1) {
                if (chuSoHangDonVi == 0) {
                    result = "mười";
                } else if (chuSoHangDonVi == 1) {
                    result = "mười một";
                } else {
                    result = "mười " + docChuSoHangDonVi(chuSoHangDonVi);
                }
            } else {
                result = docChuSoHangChuc(chuSoHangChuc) + " " + docChuSoHangDonVi(chuSoHangDonVi);
            }
            System.out.println("Cách đọc của số nguyên " + n + " là: " + result);
        } else {
            System.out.println("Vui lòng nhập số nguyên có hai chữ số.");
        }

        scanner.close();
    }

    private static String docChuSoHangDonVi(int chuSoHangDonVi) {
        switch (chuSoHangDonVi) {
            case 1:
                return "một";
            case 2:
                return "hai";
            case 3:
                return "ba";
            case 4:
                return "bốn";
            case 5:
                return "năm";
            case 6:
                return "sáu";
            case 7:
                return "bảy";
            case 8:
                return "tám";
            case 9:
                return "chín";
            default:
                return "";
        }
    }

    private static String docChuSoHangChuc(int chuSoHangChuc) {
        switch (chuSoHangChuc) {
            case 2:
                return "hai mươi";
            case 3:
                return "ba mươi";
            case 4:
                return "bốn mươi";
            case 5:
                return "năm mươi";
            case 6:
                return "sáu mươi";
            case 7:
                return "bảy mươi";
            case 8:
                return "tám mươi";
            case 9:
                return "chín mươi";
            default:
                return "";
        }
    }
}
