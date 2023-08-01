package Baitapbuoi9_bai1;

public class SinhVienPrivate {
    private String hoTen; // khi minh khai bao private thi class ngoai khong the truy xuat
    // .hoTen, phai thong qua constructor hoac setter/getter
    private int tuoi;
    private String gioiTinh;
    public SinhVienPrivate() {}
    public SinhVienPrivate(String hoTen, int tuoi, String gioiTinh) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
    }
    public void XuatGiaTri() {
        System.out.println("Ho ten: " + this.hoTen);
        System.out.println("Tuoi: "+ this.tuoi);
        System.out.println("Gioi Tinh: "+this.gioiTinh);
    }
//    public void setTuoi(int tuoi) {
//        // logic code de xu ly them neu can
//        this.tuoi = tuoi;
//    }
//    public int getTuoi() {
//        // logic code de xu ly them neu can
//        return this.tuoi;
//    }


    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
