package Baitapbuoi5;

public class DeleteElemInArray {
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

        // Create a new array with one less element
        int[] newArray = new int[arr.length - 1];
        int newIndex = 0;

        // Copy all elements except the one to be deleted to the new array
        for (int i = 0; i < arr.length; i++) {
            if (i != indexToDelete) {
                newArray[newIndex] = arr[i];
                newIndex++;
            }
        }

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

        System.out.print("Updated array: [");
        for (int i = 0; i < newArray.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(newArray[i]);
        }
        System.out.println("]");
    }
}

