package Baitapbuoi09_bai2;

import java.util.Scanner;

public class GiangVien extends SinhVien {
    String monDay;

    public GiangVien() {

    }

    public GiangVien(String hoten, int tuoi) {
        this.hoTen = hoten;
        this.tuoi = tuoi;
    }

    // Tu khoa dai dien cho class cha: super
    public GiangVien(String hoten, int tuoi, String gioiTinh) {
//        super(); // <=> SinhVien(): phuong thuc khoi tao rong
        super(hoten, tuoi, gioiTinh); // public SinhVien(String hoTen, int tuoi, String gioiTinh)
    }
    public void nhap() {
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap mon day: ");
        this.monDay = scanner.nextLine();
    }
}
