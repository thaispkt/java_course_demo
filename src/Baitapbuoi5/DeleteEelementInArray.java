package Baitapbuoi5;

import java.util.ArrayList;

public class DeleteEelementInArray {
//    In Java, the primitive array type (e.g., int[], double[], etc.) does not have a built-in remove method. The
//    remove method you mentioned is not available for primitive arrays because arrays in Java have a fixed size once they are created, and their length cannot be changed dynamically.
//
//    The remove method is commonly used with dynamic data structures like ArrayList, which is part of the Java Collections Framework. ArrayList allows you to add, remove, and resize elements dynamically, unlike primitive arrays.
//
//    Here's an example of how you can use the remove method with an ArrayList:
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
