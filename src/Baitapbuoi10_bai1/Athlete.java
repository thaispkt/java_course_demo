package Baitapbuoi10_bai1;
/*
Xây dựng lớp vận động viên gồm:
•	Thuộc tính: tên (chuỗi ký tự), tuổi (số nguyên), môn thi đấu (chuỗi ký tự), cân nặng (số
thực),  chiều cao (số thực).
•	Phương thức:
•	Khởi tạo không tham số.
•	Khởi tạo 5 tham số
•	Viết phương thức nhập
•	Viết phương thức xuất
•	Viết phương thức so sánh 2 vận động viên > (một vận động viên là lớn hơn nếu chiều cao lớn hơn,
trong trường hợp chiều cao bằng nhau thì xét cân nặng lớn hơn)
 */
public class Athlete {
    /*
    •	Thuộc tính: tên (chuỗi ký tự), tuổi (số nguyên), môn thi đấu (chuỗi ký tự), cân nặng (số
thực),  chiều cao (số thực).
     */
    private String name;
    private int age;
    private String sport;
    private float weight;
    private float height;
    public Athlete() {};
    public Athlete(String name, int age, String sport, float weight, float height) {
        this.name = name;
        this.age = age;
        this.sport = sport;
        this.weight = weight;
        this.height = height;
    }
}
