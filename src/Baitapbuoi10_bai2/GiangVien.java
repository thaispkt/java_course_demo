package Baitapbuoi10_bai2;

import java.util.Scanner;

public class GiangVien extends SinhVien {
    String monDay;

    // Tu khoa dai dien cho class cha: super
    public GiangVien(String hoTen, int tuoi, String gioiTinh, String monDay) {
        super(hoTen, tuoi, gioiTinh);
        this.monDay = monDay;
    }
    public GiangVien(String hoTen, int tuoi, String gioiTinh) {
        super(hoTen, tuoi, gioiTinh);
    }
    public void nhap() {
        super.importInfo();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap mon day: ");
        this.monDay = scanner.nextLine();
    }

    /*
Override (ghi đè phương thức): nếu như bên class cha cha mà có phương thức nhưng phương thức
đó không thoar maxn được nhu cu xử lý của class thì class con sẽ định nghĩa lại phương thức đó
với logic mới giành riêng cho class con.
Dùng Override
overload( nạp chồng) : tức là các function có cùng tên nhưng khác nhau số lượng tham số
hoặc kiểu dữ liệu tham số
     */
    @Override
    public void printInfo() {
        super.printInfo(); // Dung super de goi method cua class cha
        System.out.println("Mon day la: " + this.monDay);
    }
}
