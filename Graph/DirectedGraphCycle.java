
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
          int[] vis=new int[V];
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                if(dfs(i,adj,vis)==true) return true;
            }
        }
        return false;
    }
      public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis)
    {
        vis[node]=1;
        for(Integer it: adj.get(node))
        {
            if(vis[it]==0)
            {
                if(dfs(it,adj,vis)==true) return true;
            }
            else if(vis[it]==1) return true;
        }
        vis[node]=2;
        return false;
    }
}