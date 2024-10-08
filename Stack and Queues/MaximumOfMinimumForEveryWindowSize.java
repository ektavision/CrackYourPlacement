
class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        // Your code here
         int [] ps=new int[n];
        int [] ns=new int[n];
    int [] ans=new int[n];
        for(int i=0;i<n;i++)
            ans[i]=Integer.MIN_VALUE;
        Stack<Integer> s=new Stack<>();
        for (int i=0;i<n;i++)
        {
            while(s.isEmpty()==false && arr[s.peek()]>=arr[i])
                s.pop();
            ps[i]=s.isEmpty()?-1:s.peek();
            s.push(i);
        }
        while(!s.isEmpty())s.pop();
        
        for (int i=n-1;i>=0;i--)
        {
            while(s.isEmpty()==false && arr[s.peek()]>=arr[i])
                s.pop();
            ns[i]=s.isEmpty()?n:s.peek();
            s.push(i);
        }
        for(int i=0;i<n;i++)
        {
            ns[i]=ns[i]-ps[i]-1;
        }
        for(int i=0;i<n;i++)
        {
            ans[ns[i]-1]=Math.max(arr[i],ans[ns[i]-1]);
        }
        for(int i=n-2;i>=0;i--)
            ans[i]=Math.max(ans[i],ans[i+1]);
        return ans;
    }
}