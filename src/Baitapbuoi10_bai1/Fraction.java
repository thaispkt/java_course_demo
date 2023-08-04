package Baitapbuoi10_bai1;

import java.util.Scanner;

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
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public void importData(int i) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numerator of fraction " + i + ": ");
        this.numerator = scanner.nextInt();
        System.out.print("Enter denominator of fraction " + i + ": ");
        this.denominator = scanner.nextInt();
//        scanner.close();
    }

    public String toString() {
        return (this.numerator + "/" + this.denominator);
    }

    public Fraction add(Fraction frac2) {
        int outNumerator =
                (this.numerator * frac2.denominator) + (this.denominator * frac2.numerator);
        int outDenominator = this.denominator * frac2.denominator;
        Fraction resultFraction = new Fraction(outNumerator, outDenominator);
        return resultFraction;
    }

    public Fraction subtract(Fraction frac2) {
        int outNumerator =
                (this.numerator * frac2.denominator) - (this.denominator * frac2.numerator);
        int outDenominator = this.denominator * frac2.denominator;
        Fraction resultFraction = new Fraction(outNumerator, outDenominator);
        return resultFraction;
    }

    public Fraction multiply(Fraction frac2) {
        int outNumerator = this.numerator * frac2.numerator;
        int outDenominator = this.denominator * frac2.denominator;
        Fraction resultFraction = new Fraction(outNumerator, outDenominator);
        return resultFraction;
    }

    public Fraction divide(Fraction frac2) {
        int outNumerator = this.numerator * frac2.denominator;
        int outDenominator = this.denominator * frac2.numerator;
        Fraction resultFraction = new Fraction(outNumerator, outDenominator);
        return resultFraction;
    }
}
