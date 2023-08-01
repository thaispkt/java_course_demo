package Baitapbuoi5;

import java.util.ArrayList;

public class DeleteEelementInArray {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.remove(0); // Remove the element at index 0

        System.out.println(list); // Output: [2, 3, 4, 5]

    }
}
