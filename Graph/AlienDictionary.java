
class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
          
        List<List<Integer>> graph = new ArrayList<>(K);
        
        for (int i = 0; i < K; i++) {
             graph.add(new ArrayList<>());
        }
        
        
        for (int i = 0; i < N-1; i++) {
            String word1 = dict[i];
            String word2 = dict[i+1];
            
            int len = Math.min(word1.length(), word2.length());

            
            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    int from = word1.charAt(j) - 'a'; // cal the index
                    int to = word2.charAt(j) - 'a';
                    graph.get(from).add(to);
                    break;

                }
            }
        }
        
        boolean[] visited = new boolean[K];
        boolean[] recStack = new boolean[K];
        Stack<Integer> stack = new Stack<>();
        
        
        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
               if (topologicalSort(i, graph, visited, recStack, stack)) {
                  return ""; 
                }
            }
        }
        
        
        StringBuilder order = new StringBuilder();
        while (!stack.isEmpty()) {
            order.append((char) (stack.pop() + 'a'));
        }
        
        return order.toString();
    
        
    }
       private boolean topologicalSort(int v, List<List<Integer>> graph, boolean[] visited, boolean[] recStack, Stack<Integer> stack) {
        visited[v] = true;
        recStack[v] = true;
        
        for (int neighbor : graph.get(v)) {
            if (!visited[neighbor]) {
                if (topologicalSort(neighbor, graph, visited, recStack, stack)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                return true; 
            }
        }
        recStack[v] = false;
        stack.push(v);
        return false;
    }
}