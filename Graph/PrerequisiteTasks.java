
class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
          int[] vis = new int[N];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < P; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < N; i++) {
            if (dfs(i, adj, vis) == true) {
                return false;
            }
        }

        return true;
    }
     public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[node] = 1;

        for (int i : adj.get(node)) {
            if (vis[i] == 0) {
                if (dfs(i, adj, vis) == true) {
                    return true;
                }
            } else if (vis[i] == 1) {
                return true;
            }
        }

        vis[node] = 2;
        return false;
    }
    
}