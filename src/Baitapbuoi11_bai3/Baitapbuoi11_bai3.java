package Baitapbuoi11_bai3;

/*
4 tinh chat trong huong doi tuong
1. Tinh ke thua (inheritance)
2. Tinh dong goi (encapsulation)
  - default: // Google keyword: default OOP in JAVA
  - private:
  - protected:
  - public:
3. Tinh truu tuong (abstraction): giống hoàn toàn class nhưng khác là không khởi tạo được.
4. Tinh da hinh (polymorphism): khi khai báo khởi tạo đối tượng thay vì khởi tạo chính bản thân
đối tượng thì sẽ khởi tạo thằng con của đối tượng.
*** INHERITANCE ***

Sinh Vietn: HoTen, tuoi, gioi tinh
Giang Vien: HoTen, tuoi, gioi tinh, mon day
Hieu Truong: hoTen, Tuoi, gioi tinh, mon day, danhSachGiangVien
Doi voi class thi 1 class con chi duoc phep ke thua 1 class cha
 */
public class Baitapbuoi11_bai3 {
    public static void main(String[] args) {
//        SinhVien sinhVien = new GiangVien();
        ChucNang chucNang = new GiangVien();
        chucNang.thoiGianDenTruong();
        chucNang.thoiGianDenTruong("10h");
    }
}
