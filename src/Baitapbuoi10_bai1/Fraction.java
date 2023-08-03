package Baitapbuoi10_bai1;
/*
Xây dựng lớp Phanso gồm:
•	Thuộc Tính: tuso, mauso.
•	Phương thức:
•	Hàm Khởi Tạo Không Tham Số,
•	Nhập , Xuất
•	Cong(), Tru(), Nhan(), Chia()
Tính Tổng, Hiệu, Tích, Thương 2 phân số tham số nhận vào là đối tượng (Phân Số) rồi in kết quả ra màn hình.
Phân số: Fraction
Tử số: numerator
mẫu số: denominator
 */
public class Fraction {
    int numerator;
    int denominator;
    public Fraction() {
        numerator = 0;
        denominator = 1;
    };
    public Fraction(int numerator, int denominator) {
        this.numerator=numerator;
        this.denominator=denominator;
    }
    public void importValue(int numberator, int denominator) {
        this.numerator = numberator;
        this.denominator = denominator;
    }
    @Override
    public String toString() {
        return(this.numerator +"/"+this.denominator);
    }
    public Fraction add( Fraction frac2) {
        int outNumerator =
                (this.numerator* frac2.denominator) + (this.denominator*frac2.numerator);
        int outDenominator = this.denominator*frac2.denominator;
        Fraction resultFraction = new Fraction(outNumerator,outDenominator);
        return resultFraction;
    }
    public Fraction subtract(Fraction frac2) {
        int outNumerator =
                (this.numerator* frac2.denominator) - (this.denominator*frac2.numerator);
        int outDenominator = this.denominator*frac2.denominator;
        Fraction resultFraction = new Fraction(outNumerator,outDenominator);
        return resultFraction;
    }
    public Fraction multiply(Fraction frac2) {
        int outNumerator = this.numerator*frac2.numerator;
        int outDenominator = this.denominator*frac2.denominator;
        Fraction resultFraction = new Fraction(outNumerator,outDenominator);
        return resultFraction;
    }
    public Fraction divide(Fraction frac2) {
        int outNumerator = this.numerator*frac2.denominator;
        int outDenominator = this.denominator*frac2.numerator;
        Fraction resultFraction = new Fraction(outNumerator,outDenominator);
        return resultFraction;
    }
}
