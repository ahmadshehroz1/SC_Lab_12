import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class Task1Test {

    // Test for binarySearchRecursive(int[] arr, int target, int low, int high)
    @Test
    public void testBinarySearchRecursiveInt() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;
        int result = Task1.binarySearchRecursive(arr, target, 0, arr.length - 1);
        assertEquals(3, result); // 7 is at index 3

        target = 10;
        result = Task1.binarySearchRecursive(arr, target, 0, arr.length - 1);
        assertEquals(-1, result); // 10 is not in the array
    }

    // Test for binarySearchRecursive(String[] arr, String target, int low, int high)
    @Test
    public void testBinarySearchRecursiveString() {
        String[] arr = {"apple", "banana", "cherry", "date", "elderberry"};
        String target = "date";
        int result = Task1.binarySearchRecursive(arr, target, 0, arr.length - 1);
        assertEquals(3, result); // "date" is at index 3

        target = "fig";
        result = Task1.binarySearchRecursive(arr, target, 0, arr.length - 1);
        assertEquals(-1, result); // "fig" is not in the array
    }

    // Test for binarySearchAllIndices(int[] arr, int target, int low, int high)
    @Test
    public void testBinarySearchAllIndicesInt() {
        int[] arr = {1, 3, 5, 5, 5, 7, 9};
        int target = 5;
        List<Integer> result = Task1.binarySearchAllIndices(arr, target, 0, arr.length - 1);
        assertEquals(3, result.size()); // 5 appears at indices 2, 3, 4
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
        assertTrue(result.contains(4));

        target = 6;
        result = Task1.binarySearchAllIndices(arr, target, 0, arr.length - 1);
        assertTrue(result.isEmpty()); // 6 is not in the array
    }

    // Test for binarySearchAllIndices(String[] arr, String target, int low, int high)
    @Test
    public void testBinarySearchAllIndicesString() {
        String[] arr = {"apple", "banana", "cherry", "cherry", "date", "elderberry"};
        String target = "cherry";
        List<Integer> result = Task1.binarySearchAllIndices(arr, target, 0, arr.length - 1);
        assertEquals(2, result.size()); // "cherry" appears at indices 2 and 3
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));

        target = "fig";
        result = Task1.binarySearchAllIndices(arr, target, 0, arr.length - 1);
        assertTrue(result.isEmpty()); // "fig" is not in the array
    }

    // Test for edge cases (empty arrays)
    @Test(expected = IllegalArgumentException.class)
    public void testBinarySearchRecursiveEmptyArray() {
        int[] arr = {};
        Task1.binarySearchRecursive(arr, 5, 0, arr.length - 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBinarySearchRecursiveNullArray() {
        Task1.binarySearchRecursive(null, 5, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBinarySearchAllIndicesEmptyArray() {
        int[] arr = {};
        Task1.binarySearchAllIndices(arr, 5, 0, arr.length - 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBinarySearchAllIndicesNullArray() {
        Task1.binarySearchAllIndices(null, "apple", 0, 0);
    }
}
