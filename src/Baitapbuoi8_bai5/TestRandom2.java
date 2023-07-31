package Baitapbuoi8_bai5;
import java.util.Random;

public class TestRandom2 {
    public static void main(String[] args) {
        Random random = new Random();

        String[] names = {
                "Anh", "Bảo", "Bình", "Cường", "Đức", "Duy", "Hoàng", "Huy", "Nam",
                "Tuấn", "Việt", "Châu", "Chi", "Diệp", "Hương", "Linh", "Mai", "Ngọc",
                "Phương", "Quỳnh", "Trang", "Vân", "Hưng", "Trung", "Minh", "Hà", "Thành", "Quang"
        };

//        String lastName = names[random.nextInt(names.length - 1)];
        String name;
        for (int i = 0; i < 200; i++) {
            name = names[random.nextInt(names.length)];
            System.out.println("name: " + name);
        }
    }
}
