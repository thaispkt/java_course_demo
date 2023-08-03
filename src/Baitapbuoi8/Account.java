package Baitapbuoi8;

import java.text.DecimalFormat;
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
(b). Thêm các thông tin sau vào lớp Account
- Hằng số lãi suất có giá trị khởi tạo 0.035
Constructor có 2 đối số: số tài khoản, tên tài khoản. Constructor này sẽ khởi tạo số tiền mặc định là 50.
 Phương thức nạp tiền vào tài khoản: Lấy số tiền hiện tại trong tài khoản + số tiền nạp vào
- Phương thức rút tiền: Lấy số tiền hiện tại trong tài khoản – (số tiền muốn rút + phí rút tiền)
- Phương thức đáo hạn: Mỗi lần đến kỳ đáo hạn thì số tiền trong tài khoản = số tiền trong tài khoản + số tiền trong
tài  khoản * LAISUAT
- Phương thức chuyển khoản từ tài khoản này sang tài khoản khác Chú ý: Mỗi thao tác phải kiểm tra số tiền nạp, rút,
chuyển có hợp lệ hay không? (VD: tiền nhập vào)
 */
public class Account {
    private long accountNumber;
    private String accountName;
    private double amount;
    private static final double INTEREST_RATE = 0.035;

    // Default constructor
    public Account() {
        this.accountNumber = 0;
        this.accountName = "";
        this.amount = 50.0;
    }

    // Constructor with full parameters
    public Account(long accountNumber, String accountName, double amount) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.amount = amount;
    }

    // Getters and setters for each property
    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Phương thức nạp tiền vào tài khoản: Lấy số tiền hiện tại trong tài khoản + số tiền nạp vào
    public void deposit(double depositAmount) {
        this.amount += depositAmount;
    }

    // Phương thức rút tiền: Lấy số tiền hiện tại trong tài khoản – (số tiền muốn rút + phí rút tiền)
    public void withdraw(double withdrawAmount, double withdrawFee) {
        double totalWithdrawAmount = withdrawAmount + withdrawFee;
        if (totalWithdrawAmount <= this.amount) {
            this.amount -= totalWithdrawAmount;
        } else {
            System.out.println("Error: Withdrawal amount must be greater than the sum of the amount and withdrawal " +
                    "fee");
        }
    }

    // Phương thức đáo hạn: Mỗi lần đến kỳ đáo hạn thì số tiền trong tài khoản = số tiền trong tài khoản + số tiền trong
    // tài  khoản * LAISUAT
    public void maturity() {
        this.amount = this.amount * (1 + INTEREST_RATE);
    }

    // Phương thức chuyển khoản từ tài khoản này sang tài khoản khác Chú ý: Mỗi thao tác phải kiểm tra số tiền nạp, rút,
    // chuyển có hợp lệ hay không? (VD: tiền nhập vào)
    public void transfer(Account destinationAccount, double transferAmount) {
        if (transferAmount <= this.amount) {
            this.amount -= transferAmount;
            destinationAccount.deposit(transferAmount);
        } else {
            System.out.println("Error: insufficient balance.");
        }
    }

    // Phương thức toString để trả về chuỗi chứa toàn bộ thông tin tài khoản, yêu cầu định dạng tiền tệ
    @Override
    public String toString() {
        DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");
        return "Account Number: " + accountNumber +  ", Account Name: " + accountName +
                ", Amount: $" + currencyFormat.format(amount);
    }
}
