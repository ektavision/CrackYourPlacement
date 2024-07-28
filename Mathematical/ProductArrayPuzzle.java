
class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
        // code here
		long[] output = new long[n];
		 if(n==1){
		output[0] = 1;
		 return output;
        }
		for (int i = 0; i < n; i++) {
		
		long right = 1;
		for (int j = 0; j < n; j++) {			
		 if(i != j) right*=nums[j];
		
		}
		   output[i] = right;
		}
		return output;
	} 
} 
