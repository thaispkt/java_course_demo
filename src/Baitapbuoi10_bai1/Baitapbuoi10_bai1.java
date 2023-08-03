package Baitapbuoi10_bai1;

/*
Xây dựng lớp Phanso gồm:
•	Thuộc Tính: tuso, mauso.
•	Phương thức:
•	Hàm Khởi Tạo Không Tham Số,
•	Nhập , Xuất
•	Cong(), Tru(), Nhan(), Chia()
Tính Tổng, Hiệu, Tích, Thương 2 phân số tham số nhận vào là đối tượng (Phân Số) rồi in kết quả ra
 màn hình.
Phân số: Fraction
Tử số: numerator
mẫu số: denominator
 */
public class Baitapbuoi10_bai1 {
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(2, 3);
        Fraction fraction2 = new Fraction(1, 4);
        Fraction fractionSum  = fraction1.add(fraction2);
        Fraction fractionDiff = fraction1.subtract(fraction2);
        Fraction fractionMul  = fraction1.multiply(fraction2);
        Fraction fractionDiv  = fraction1.divide(fraction2);
        System.out.println("Sum of 2 fractions: " + fractionSum.toString());
        System.out.println("Diff of 2 fractions: " + fractionDiff.toString());
        System.out.println("Product of 2 fractions: " + fractionMul.toString());
        System.out.println("Quotient of 2 fractions: " + fractionDiv.toString());
    }
}
