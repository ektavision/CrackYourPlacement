class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
          Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] pair : adjacentPairs){
            adj.putIfAbsent(pair[0], new ArrayList<>());
            adj.putIfAbsent(pair[1], new ArrayList<>());

            adj.get(pair[0]).add(pair[1]);
            adj.get(pair[1]).add(pair[0]);
        }

        // start pt
        int start = -1;
        for(int key : adj.keySet()){
            if(adj.get(key).size()==1){
                start = key;
                break;
            }
        }

        // dfs
        int[] res = new int[adjacentPairs.length+1];
        res[0] = start;
        res[1] = adj.get(start).get(0);

        int i=2;
        while(i < res.length){
            List<Integer> neighbors = adj.get(res[i-1]);

            for(int neighbor : neighbors){
                if(neighbor != res[i-2]){
                    res[i] = neighbor;
                }
            }

            i++;
        }

        return res;
    }
}