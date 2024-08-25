
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
          int c=0,totalprofit=0;
        Arrays.sort(arr,(x,y)->x.deadline-y.deadline);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            if(arr[i].deadline>pq.size())pq.add(arr[i].profit);
            else if(arr[i].deadline==pq.size()){
                if(arr[i].profit>pq.peek()){
                    pq.poll();
                    pq.add(arr[i].profit);
                }
            }
        }
        int ans[]=new int[2];
        c=pq.size();
        while(!pq.isEmpty())totalprofit+=pq.poll();
        ans[0]=c;
        ans[1]=totalprofit;
        return ans;
    }
}
