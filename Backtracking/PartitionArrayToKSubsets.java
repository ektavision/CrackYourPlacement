
class Solution
{
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	// Your code here
	 int sum=0;
        for(int i:a) sum+=i;
        if(sum%k!=0) return false;
        Arrays.sort(a);
        
        return (dfs(n-1,a,new int[k],k,sum/k));
    }
    public boolean dfs(int ind,int[] a,int[] sum, int k,int target){
        if(ind == -1)return true;
        for(int i=0;i<k;i++){
            if((sum[i] + a[ind]>target) || (i>0 && sum[i] == sum[i-1]))continue;
            
            sum[i]+=a[ind];
            
            if(dfs(ind-1,a,sum,k,target))return true;
            sum[i]-= a[ind];
        }
        return false;
    }
}
