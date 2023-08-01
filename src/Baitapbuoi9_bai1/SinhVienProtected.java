package Baitapbuoi9_bai1;

public class SinhVienProtected {
    private String hoTen; // khi minh khai bao private thi class ngoai khong the truy xuat
    // .hoTen, phai thong qua constructor hoac setter/getter
    private int tuoi;
    private String gioiTinh;
    public SinhVienProtected() {}
    public SinhVienProtected(String hoTen, int tuoi, String gioiTinh) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
    }
    public void XuatGiaTri() {
        System.out.println("Ho ten: " + this.hoTen);
        System.out.println("Tuoi: "+ this.tuoi);
        System.out.println("Gioi Tinh: "+this.gioiTinh);
    }
}
