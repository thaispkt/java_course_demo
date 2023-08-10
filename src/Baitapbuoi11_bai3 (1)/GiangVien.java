package Baitapbuoi11_bai3;

import java.util.Scanner;

public class GiangVien extends SinhVien implements ChucNang{
    String monDay;
    public GiangVien() {}
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

    @Override
    public void printInfo() {
        super.printInfo(); // Dung super de goi method cua class cha
        System.out.println("Mon day la: " + this.monDay);
    }
    @Override
    public void thoiGianDenTruong() {
        System.out.println("Thời gian đi làm không có tham số");
    }
    @Override
    public void thoiGianDenTruong(String thoiGian) {
        System.out.println("Thời gian đi làm có tham số: " + thoiGian );
    }
}
