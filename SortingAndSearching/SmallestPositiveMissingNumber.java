class Solution
{
    static int missingNumber(int arr[], int size)
    {
        // Your code here
          for(int i = 0; i < size; ++ i) {
            while(arr[i] >= 1 && arr[i] <= size && arr[i] != arr[arr[i]-1])
                {
                    int t = arr[arr[i] - 1]; arr[arr[i] - 1] = arr[i];  arr[i]=t;
                }
        }
        
        for(int i = 0; i < size; ++ i)
            if(arr[i] != i + 1)
                return i + 1;
        
        return size + 1;
    }
}