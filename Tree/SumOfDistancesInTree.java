class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
         HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int[] count = new int[n];

        Arrays.fill(count, 1);

        int answer[] = new int[n];

        for(int edge[] : edges)
        {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        postOrder(0, -1, graph, count, answer);

        preOrder(0, -1, graph, count, answer, n);

        return answer;
    }
      private void postOrder(int node, int parent, HashMap<Integer, ArrayList<Integer>> graph, int count[], int answer[])
    {
        for(int child : graph.getOrDefault(node, new ArrayList<>()))
        {
            if(child != parent)
            {
                postOrder(child, node, graph, count, answer);
                count[node] += count[child];
                answer[node] += answer[child] + count[child];
            }
        }
    }

    private void preOrder(int node, int parent, HashMap<Integer, ArrayList<Integer>> graph, int count[], int answer[], int n)
    {
        for(int child : graph.getOrDefault(node, new ArrayList<>()))
        {
            if(child != parent)
            {
                answer[child] = answer[node] + (n - count[child]) - count[child];
                preOrder(child, node, graph, count, answer, n);
            }
        }
    }
}