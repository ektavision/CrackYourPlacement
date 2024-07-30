
class Solution {
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        // Your code here
        if(m>n)return -1;
        int min=arr[0],s=0;
        for(int i:arr){
            min=Math.min(i,min);
            s+=i;
        }
        int l=min,h=s,ans=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(valid(arr,mid,m)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
     public static boolean valid(int []A,int k,int M){
        int p=0,b=0;
        for(int i=0;i<A.length;i++){
            
            if(p+A[i]>k){
                b++;
                p=A[i];
                if(p>k)return false;
            }
            else{
                p+=A[i];
            }
            
        }
        if(b<M)return true;
        return false;
     }
};