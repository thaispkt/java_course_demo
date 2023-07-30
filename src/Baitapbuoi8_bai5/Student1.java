package Baitapbuoi8_bai5;
/*
1)	Xây dựng chương trình cho phép người dùng nhập vào: Tên, Mã SV, điểm Toán, Lý Hóa. Thực hiện các nghiệp vụ dưới đây.
•	Tính điểm trung bình từng sinh viên ( T + L + H)/3
•	Xếp loại từng sinh viên theo: >=9 -> Xuất Sắc, 9<Giỏi<=8, 8<Khá<=7, <7<=6, <=5, còn lại Yếu.
 */
public class Student1 {
    String name;
    String id;
    float mathMark;
    float physicsMark;
    float chemistryMark;
    float averageScore;
    String rank;
    public void calcScoreAverage() {
        this.averageScore = (this.mathMark + this.physicsMark + this.chemistryMark)/3;
    }
    public void ranking() {
        if(this.averageScore >= 9) {
            this.rank = "Excellence";
        } else if (this.averageScore >=8) {
            this.rank = "Good";
        } else if (this.averageScore >= 7) {
            this.rank = "Fair";
        } else if (this.averageScore >=6 ) {
            this.rank = "Fair-Average";
        } else if (this.averageScore >=5 ) {
            this.rank = "Average";
        } else {
            this.rank = "Weak";
        }
    }
}
