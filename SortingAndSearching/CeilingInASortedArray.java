import java.util.*;

class Solution {
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 8, 10, 10, 12, 19 };
        int n = arr.length;
        int x = 8;
        int idx = Arrays.binarySearch(arr, x);
        if (idx < 0) {
            idx = Math.abs(idx) - 1;
        }
        if (idx == n) {
            System.out.println(
                "Ceiling Element does not exist");
        }
        else {
            System.out.println("Ceiling Element of " + x
                               + " is " + arr[idx]);
        }
    }
}