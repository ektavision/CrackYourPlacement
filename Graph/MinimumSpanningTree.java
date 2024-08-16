class MST implements Comparable<MST>{
    int wt;
    int node;
    int par;
    public MST(int wt, int node, int par){
        this.wt = wt;
        this.node = node;
        this.par = par;
    }
    
    public int compareTo(MST other) {
        return this.wt - other.wt;
    }
}
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
       
        PriorityQueue<MST> q = new PriorityQueue<>();
        q.add(new MST(0,0,-1));
        boolean mst[]=new boolean[V];
        int cost =0;
        int pare[]=new int[V];
        
        while(!q.isEmpty()){
            MST pair=q.remove();
            int weight=pair.wt;
            int curr=pair.node;
            int parent=pair.par;
            if (mst[curr]) continue;
            mst[curr]=true;
            pare[curr]=parent; 
            cost=cost+weight;
            for(int i=0;i<adj.get(curr).size();i++){
           int v=adj.get(curr).get(i)[0];
           int wt=adj.get(curr).get(i)[1];
           if(!mst[v]){
               q.add(new MST(wt, v, curr)); 
           }
            }
        }
        return cost;
    }
}