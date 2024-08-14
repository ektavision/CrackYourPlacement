
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
         boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++){
            if(vis[i]==false){
                if(dfs(i,vis,adj,V,-1) ) return true;
            }
        }
        return false;
    }
     
    public boolean dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj,int V,int parentNode ){
        vis[node] = true;
        for(int adjacentNode :adj.get(node) ){
            if( vis[adjacentNode] == false ){
                if (dfs(adjacentNode,vis,adj,V, node)) return true;
            }
            else if( vis[adjacentNode] == true ){
                if( adjacentNode != parentNode  ) return true;
            }
            
        }
        return false;
    }
}