import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Arrays;
/**
 * This class performs a recursive binary search on a sorted array.
 * @author Tony Tran
 * @version 1.0
 * @since 2025-05-01
 */
final class RecBinSearch {
    /**
     * This is a private constructor to satisfy style checker.
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private RecBinSearch() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This function performs a recursive binary search on a sorted array.
     * @param arr the sorted array of integers
     * @param target the integer value to search for
     * @param left the left index of the subarray to search
     * @param right the right index of the subarray to search
     * @return the index of the target value in the array, or -1 if not found
     */
    public static int binarySearch(final int[] arr, final int target,
             final int left, final int right) {
        // Base case: if the left index exceeds the right index,
        // the target is not found
        if (left > right) {
            return -1;
        }

        // Calculate the middle index of the current subarray
        int mid = left + (right - left) / 2;

        // Check if the target value is at the middle index
        if (arr[mid] == target) {
            return mid; // Target found, return its index
        }

        // If the target is less than the middle value, search left subarray
        if (target < arr[mid]) {
            return binarySearch(arr, target, left, mid - 1);
        }

        // If the target is greater than the middle value, search right subarray
        return binarySearch(arr, target, mid + 1, right);
    }

    /**
     * This the main method to run the program.
     * @param args
     */
    public static void main(final String[] args) throws Exception {
        // Create a Scanner object to read from the input file
        Scanner input = new Scanner(new File(args[0]));
        // Create a FileWriter object to write to the output file
        FileWriter writer = new FileWriter("output.txt");
        // Loop through space-separated integers in the input file
        try {
            // Read size of array and the target value from the input file
            int size = Integer.parseInt(input.next());
            int target = Integer.parseInt(input.next());

            // Create an array to store the integers
            int[] arr = new int[size];

            // Read the integers into the array
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(input.next());
            }
            // Ensure the array is sorted before performing binary search
            Arrays.sort(arr);
            // Perform binary search on the array
            int resultIndex = binarySearch(arr, target, 0, size - 1);

            // Write the result to the output file
            writer.write(resultIndex + "\n");
        } catch (Exception e) {
            // Handle exceptions that occur during input parsing or processing
            e.printStackTrace();
        }
        // Close the FileWriter and Scanner objects
        writer.close();
        input.close();
    }
}
