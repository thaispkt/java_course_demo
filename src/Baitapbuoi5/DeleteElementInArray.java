package Baitapbuoi5;

public class DeleteElementInArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int elementToDelete = 3;

        // Find the index of the element to delete
        int indexToDelete = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elementToDelete) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Element not found in the array.");
            return;
        }

        // Check if the index is within the bounds of the array
        if (indexToDelete < 0 || indexToDelete >= arr.length) {
            System.out.println("Invalid index.");
            return;
        }

        // Shift the elements after the target index one position to the left
        for (int i = indexToDelete; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // Update the length of the array to reflect the "deleted" element

        System.out.println("]");
        // Update the length of the array to reflect the "deleted" element
//        int[] newArray = new int[arr.length - 1];
//        System.arraycopy(arr, 0, newArray, 0, arr.length - 1);

        // Print the original and updated arrays
        System.out.print("Original array: [");
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println("]");

        System.out.println("Element to delete: " + elementToDelete);
        // This step is optional if you want to keep track of the valid elements
        arr[arr.length - 1] = 0; // Optional: Set the last element to 0 or null
        System.out.print("Updated array: [");
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println("]");
//        System.out.print("Updated array: [");
//        for (int i = 0; i < newArray.length; i++) {
//            if (i != 0) {
//                System.out.print(", ");
//            }
//            System.out.print(newArray[i]);
//        }
//        System.out.println("]");
    }
}
