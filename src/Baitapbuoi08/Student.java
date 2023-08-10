package Baitapbuoi08;
/*
Viết chương trình OOP quản lý sinh viên đơn giản: Nhập, xuất thông tin, tính điểm TB.
- Viết lớp Sinh viên như sau:
Attributes (private):
- Mã sinh viên là số nguyên.
- Họ tên: chuỗi ký tự.
- Điểm LT, điểm TH : float
Constructor:
- Constructor mặc định (để khởi tạo đối tượng với các thông tin kiểu số là 0, kiểu chuỗi là chuỗi rỗng).
- Constructor thứ hai nhận đầy đủ thông tin để khởi tạo giá trị cho tất cả các biến instance.
Methods:
- Các getter và setter cho mỗi thuộc tính.
- Tính điểm trung bình.
- Phương thức toString để diễn tả đối tượng ở dạng chuỗi.

sv1 chứa thông tin của chính mình (tạo bằng constructor đủ thông số, thông tin biết rồi khỏi nhập từ bàn phím).
- sv2 là thông tin người bạn thân nhất của em (tạo bằng constructor đủ thông số, thông tin biết rồi khỏi nhập từ bàn
 phím).
- sv3 tạo bằng constructor mặc định. Nhập các thông tin cho sv3 từ bàn phím rồi sau đó dùng các setter để gán vào cho
  các thuộc tính tương ứng.
 */
class Student {
    private int id;
    private String name;
    private float theoryScore;
    private float practiceScore;

    // Default constructor
    public Student() {
        this.id = 0;
        this.name = "";
        this.theoryScore = 0.0f;
        this.practiceScore = 0.0f;
    }

    // Constructor with all parameters
    public Student(int id, String name, float theoryScore, float practiceScore) {
        this.id = id;
        this.name = name;
        this.theoryScore = theoryScore;
        this.practiceScore = practiceScore;
    }

    // Getters and setters for each property
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTheoryScore() {
        return theoryScore;
    }

    public void setTheoryScore(float theoryScore) {
        this.theoryScore = theoryScore;
    }

    public float getPracticeScore() {
        return practiceScore;
    }

    public void setPracticeScore(float practiceScore) {
        this.practiceScore = practiceScore;
    }

    public float calcAverageScore() {
        return (theoryScore + practiceScore) / 2;
    }

    // The getInfo() method to represent the object in string form
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Theory Score: " + theoryScore + ", Practice Score: "
                + practiceScore;
    }
}
