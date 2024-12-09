import java.util.ArrayList;
import java.util.List;

public class Task1 {

    // Binary search for integers
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is null or empty.");
        }

        if (low > high) {
            return -1;  // Base case: target not found
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid;  // Target found at index mid
        } else if (arr[mid] > target) {
            return binarySearchRecursive(arr, target, low, mid - 1);  // Search left
        } else {
            return binarySearchRecursive(arr, target, mid + 1, high);  // Search right
        }
    }

    // Binary search for strings
    public static int binarySearchRecursive(String[] arr, String target, int low, int high) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is null or empty.");
        }

        if (low > high) {
            return -1;  // Base case: target not found
        }

        int mid = low + (high - low) / 2;

        if (arr[mid].equals(target)) {
            return mid;  // Target found at index mid
        } else if (arr[mid].compareTo(target) > 0) {
            return binarySearchRecursive(arr, target, low, mid - 1);  // Search left
        } else {
            return binarySearchRecursive(arr, target, mid + 1, high);  // Search right
        }
    }

    // For finding all indices of a target in an integer array
    public static List<Integer> binarySearchAllIndices(int[] arr, int target, int low, int high) {
        List<Integer> indices = new ArrayList<>();

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is null or empty.");
        }

        if (low > high) {
            return indices;
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            indices.add(mid);
            // Search left side
            indices.addAll(binarySearchAllIndices(arr, target, low, mid - 1));
            // Search right side
            indices.addAll(binarySearchAllIndices(arr, target, mid + 1, high));
        } else if (arr[mid] > target) {
            indices.addAll(binarySearchAllIndices(arr, target, low, mid - 1));
        } else {
            indices.addAll(binarySearchAllIndices(arr, target, mid + 1, high));
        }

        return indices;
    }

    // For finding all indices of a target in a string array
    public static List<Integer> binarySearchAllIndices(String[] arr, String target, int low, int high) {
        List<Integer> indices = new ArrayList<>();

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is null or empty.");
        }

        if (low > high) {
            return indices;
        }

        int mid = low + (high - low) / 2;

        if (arr[mid].equals(target)) {
            indices.add(mid);
            // Search left side
            indices.addAll(binarySearchAllIndices(arr, target, low, mid - 1));
            // Search right side
            indices.addAll(binarySearchAllIndices(arr, target, mid + 1, high));
        } else if (arr[mid].compareTo(target) > 0) {
            indices.addAll(binarySearchAllIndices(arr, target, low, mid - 1));
        } else {
            indices.addAll(binarySearchAllIndices(arr, target, mid + 1, high));
        }

        return indices;
    }

}
