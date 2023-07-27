package Baitapbuoi8_bai2;

/*
Xây dựng lớp đối tượng quản lý hình chữ nhật và cài đặt các phương thức tính chu vi và diện tích
của hình chữ nhật.
        • Bước 1: Xác định lớp đối tượng
        • Bước 2: Liệt kê tất cả các thuộc tính của đối tượng
        • Bước 3: Xây dựng các phương thức get, set cho từng thuộc tính
        • Bước 4: Xây dựng các phương thức khởi tạo
        • Bước 5: Xây dựng phương thức nhập, xuất
        • Bước 6: Xây dựng phương thức xử lý nghiệp vụ tính chu vi (tạo thêm thuộc
        tính chu vi để lưu trữ)
        • Bước 7: Xây dựng phương thức xử lý nghiệp vụ tính diện tích (tạo thêm
        thuộc tính diện tích để lưu trữ)
        • Bước 8: Vào lớp xử lý chính hoặc nơi cần xử lý, tạo ra đối tượng
        • Bước 9: Gọi các phương thức xử lý theo yêu cầu bài toán
 */
public class Rectangular {
    float width;
    float length;
    float area;
    float perimeter;

    Rectangular(float width, float length) {
        this.width = width;
        this.length = length;
    }

    public void setInfo(float width, float length) {
        this.width = width;
        this.length = length;
    }

    public void printInfo() {
        System.out.println("width=" + this.width);
        System.out.println("width=" + this.length);
    }

    public void calcArea() {
        this.area = this.width * this.length;
    }

    public void calcPerimeter() {
        this.perimeter = (this.width + this.length) * 2;
    }
}
