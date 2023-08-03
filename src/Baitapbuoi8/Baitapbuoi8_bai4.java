package Baitapbuoi8;
/*
Ngân hàng ABC muốn lưu trữ thông tin của mỗi tài khoản như sau:
Mỗi tài khoản chứa các thông tin:
- Số tài khoản ( Kiểu long),
- Tên tài khoản (kiểu chuỗi),
- Số tiền trong tài khoản (kiểu double)
(a). Thiết kế lớp Account để lưu trữ các thông tin, lớp bao gồm các phương thức  sau:
Constructor: Có 2 constructor ( mặc định và đầy đủ tham số)
- Các phương thức get, set cho từng thuộc tính
- Phương thức toString để trả về chuỗi chứa toàn bộ thông tin tài khoản, yêu cầu định dạng tiền tệ.
(b). Thêm cácthông  tin sau vào lớp Account
- Hằng số lãi suất có giá trị khởi tạo 0.035
Constructor có 2 đối số: số tài khoản, tên tài khoản. Constructor này sẽ khởi tạo số tiền mặc định là 50.
 Phương thức nạp tiền vào tài khoản: Lấy số tiền hiện tại trong tài khoản + số tiền nạp vào
- Phương thức rút tiền: Lấy số tiền hiện tại trong tài khoản – (số tiền muốn rút + phí rút tiền)
- Phương thức đáo hạn: Mỗi lần đến kỳ đáo hạn thì số tiền trong tài khoản = số tiền trong tài khoản + số tiền trong
tài  khoản * LAISUAT
- Phương thức chuyển khoản từ tài khoản này sang tài khoản khác Chú ý: Mỗi thao tác phải kiểm tra số tiền nạp, rút,
chuyển có hợp lệ hay không? (VD: tiền nhập vào)
 */
public class Baitapbuoi8_bai4 {
    public static void main(String[] args) {
        Account account1 = new Account(159357, "NGUYỄN ĐỖ TƯỜNG VÂN", 10000);
        Account account2 = new Account(493167, "ĐÀO XUÂN ĐINH", 8000);

        System.out.println("Account info:");
        System.out.println(account1.toString());
        System.out.println(account2.toString());

        account1.deposit(500);
        account2.withdraw(1000, 50);
        account1.transfer(account2, 300);
        account1.maturity();
        account2.maturity();

        System.out.println("Updated account info:");
        System.out.println(account1.toString());
        System.out.println(account2.toString());
    }
}
