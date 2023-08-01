package Baitapbuoi9_bai2;

public class HieuTruong extends GiangVien {
    GiangVien[] danhSachGiangVien;

    public HieuTruong() {
    }

    public HieuTruong(String hoTen, int tuoi, String gioiTinh, String monDay) {
        super(hoTen, tuoi, gioiTinh); // <=> SinhVien()
        this.monDay = monDay;
    }

    public HieuTruong(String hoten, int tuoi, String gioiTinh,
                      String monDay, GiangVien[] listGiangVien) {
//        super(); // <=> SinhVien(): phuong thuc khoi tao rong
        super(hoten, tuoi, gioiTinh); // public SinhVien(String hoTen, int tuoi, String gioiTinh)
    }
    public void nhap(String hoTen, int tuoi, String gioiTinh, String monDay, GiangVien[] listGiangVien ) {
        super.nhap(hoTen, tuoi, gioiTinh, monDay);
        this.danhSachGiangVien = listGiangVien;
    }
}
