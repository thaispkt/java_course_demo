package Baitapbuoi10_bai2;

import java.util.Scanner;

public class SinhVien {
    protected String hoTen;
    protected int tuoi;
    protected String gioiTinh;

    public SinhVien() {
    }

    public SinhVien(String hoTen, int tuoi, String gioiTinh) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
    }

    public void printInfo() {
        System.out.println("Ho ten: " + this.hoTen);
        System.out.println("Tuoi: " + this.tuoi);
        System.out.println("Gioi Tinh: " + this.gioiTinh);
    }
    public void importInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        this.hoTen = scanner.nextLine();
        System.out.print("Nhap tuoi: ");
        this.tuoi = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhap gioi tinh: ");
        this.gioiTinh = scanner.nextLine();
    }
    public void calcAverageScore() {
        System.out.println("Chi la ham tinh diem trung binh");
    }
    public void calcAverageScore(int diem1, int diem2) {
        System.out.println("Average score: " + (diem1+diem2)/2);
    }
    public void export(){
        System.out.println("Ho ten: " + this.hoTen);
        System.out.println("Tuoi: " + this.tuoi);
        System.out.println("Gioi Tinh: " + this.gioiTinh);
    }
}
