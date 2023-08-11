package Baitapbuoi11_bai3;
/*
Chỉ dùng để khai báo hàm và khai báo biến
-Lưu ý: nếu biến được khai báo ở interface thì biến đó sẽ là hằng
- Giữa abstract và interface khác nhau điểm nào ?
Ans: abstract: 1 class chỉ kế thừa được 1 abstract class. Tương tự class có thể khai báo biến,
hàm, xử lý logic code.
- interface: 1 class có thể kế thừa nhiều interface, chỉ dùng để khai báo hàm và biến dưới dạng
hằng số
 */
public interface ChucNang {
    void thoiGianDenTruong();
    void thoiGianDenTruong(String thoiGian);
}
