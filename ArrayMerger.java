import java.util.Arrays;

public class ArrayMerger {
    // Method to merge two sorted arrays into one sorted array
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        // Compare elements from both arrays and merge them into mergedArray
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }

        // Copy any remaining elements from arr1, if any
        while (i < arr1.length) {
            mergedArray[k++] = arr1[i++];
        }

        // Copy any remaining elements from arr2, if any
        while (j < arr2.length) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }

    // Recursive method to merge sorted arrays
    public static int[] mergeSortedArraysRecursively(int[][] arrays) {
        // Base cases
        if (arrays.length == 0) {
            return new int[0]; // Empty array
        }

        if (arrays.length == 1) {
            return arrays[0]; // Only one array, return as is
        }

        // Divide the arrays into two halves
        int mid = arrays.length / 2;
        int[][] leftArrays = Arrays.copyOfRange(arrays, 0, mid);
        int[][] rightArrays = Arrays.copyOfRange(arrays, mid, arrays.length);

        // Recursively merge the left and right halves
        int[] leftMerged = mergeSortedArraysRecursively(leftArrays);
        int[] rightMerged = mergeSortedArraysRecursively(rightArrays);

        // Merge the left and right merged arrays
        return mergeSortedArrays(leftMerged, rightMerged);
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 4, 7, 9 };
        int[] arr2 = { 2, 3, 5, 8 };

        // Merge arr1 and arr2 using mergeSortedArrays method
        int[] mergedArray = mergeSortedArrays(arr1, arr2);
        System.out.println("Merged Array: " + Arrays.toString(mergedArray));

        int[][] arrays = { arr1, arr2 };

        // Merge arrays recursively using mergeSortedArraysRecursively method
        int[] mergedRecursive = mergeSortedArraysRecursively(arrays);
        System.out.println("Merged Recursive: " + Arrays.toString(mergedRecursive));
    }
}