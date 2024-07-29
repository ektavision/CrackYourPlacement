public class Main {
    static void countSort(int arr[], int n, int place) {
      int[] count = new int[10];
      for (int i = 0; i < 10; i++) count[i] = 0;
      for (int i = 0; i < n; i++) count[(arr[i] / place) % 10]++; 
      for (int i = 1; i < 10; i++) count[i] = count[i - 1] + count[i]; 
  
      int[] res = new int[n];
      for (int i = n - 1; i >= 0; i--) {
        res[count[(arr[i] / place) % 10] - 1] = arr[i];
        count[(arr[i] / place) % 10]--;
      }
      for (int i = 0; i < n; i++) arr[i] = res[i];
  
    }
    static void radixSort(int arr[], int n) {
      int maxElement = arr[0];
      for (int i = 0; i < n; i++) {
        maxElement = Math.max(maxElement, arr[i]);
      }
      for (int place = 1; maxElement / place > 0; place *= 10) {
        countSort(arr, n, place);
      }
      for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
    }
    public static void main(String args[]) {
      int arr [] = { 326, 311, 3, 4, 920, 65}; 
      int n = 6;
      radixSort(arr, n);
    }
  }