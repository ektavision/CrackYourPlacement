
import java.io.*;
import java.util.*;
 
class GFG {
    public static boolean
    subArrWithSumZero(int arr[], int start, int end, int n)
    {
        int sum[] = new int[n];
        HashMap<Integer, Integer> um
            = new HashMap<Integer, Integer>();
        sum[0] = arr[0];
        for (int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + arr[i];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (sum[i] == 0) {
                start = 0;
                end = i;
                maxLen = (i + 1);
            }
            else if (um.get(sum[i]) == null)
                um.put(sum[i], i);
            else {
                if (maxLen < (i - um.get(sum[i]))) {
                    maxLen = i - um.get(sum[i]);
                    start = i - um.get(sum[i]) + 1;
                    end = i;
                }
            }
        }
        if (maxLen == 0)
            return false;
        return true;
    }
    public static void
    maxAreaRectWithSumZero(int mat[][], int row, int col)
    {
        int temp[] = new int[row];
        int startRow = 0, endRow = 0;
        int finalLeft = -1, finalRight = -1, finalTop = -1,
            finalBottom = -1;
        int maxArea = 0;
        for (int left = 0; left < col; left++) {
            for (int right = left; right < col; right++) {
                for (int i = 0; i < row; i++)
                    temp[i]
                        += (mat[i][right] != 0) ? 1 : -1;
                if (subArrWithSumZero(temp, startRow,
                                      endRow, row)) {
                    int area = (right - left + 1)
                               * (endRow - startRow + 1);
                    if (maxArea < area) {
                        finalTop = startRow;
                        finalBottom = endRow;
                        finalLeft = left;
                        finalRight = right;
                        maxArea = area;
                    }
                }
            }
        }
        if (maxArea == 0)
            System.out.print(
                "No such rectangular submatrix exists:");
        else {
            System.out.println("(Top, Left): "
                               + "(" + finalTop + ", "
                               + finalLeft + ")");
 
            System.out.println("(Bottom, Right): "
                               + "(" + finalBottom + ", "
                               + finalRight + ")");
 
            System.out.println("Area: " + maxArea
                               + " sq.units");
        }
    }
    public static void main(String[] args)
    {
        int mat[][] = { { 0, 0, 1, 1 },
                        { 0, 1, 1, 0 },
                        { 1, 1, 1, 0 },
                        { 1, 0, 0, 1 } };
        int row = 4, col = 4;
        maxAreaRectWithSumZero(mat, row, col);
    }
}
 