class Solution {
    Map<String, Double> valueMap = new HashMap<>();
    Map<String, List<String>> graph = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
         buildGraph(equations, values);
        int n = queries.size();
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            List<String> query = queries.get(i);
            result[i] = dfs(new HashSet<>(), query.get(0), query.get(1), 1.0);
            if (result[i] == 0.0) result[i] = -1.0;
        }

        return result;
    }
      private double dfs(Set<String> visited, String start, String end, double value) {
        if (visited.contains(start)) return 0.0;
        if (!graph.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;
        visited.add(start);

        double temp = 0.0;
        for (String next : graph.get(start)) {
            String nextKey = getKey(start, next);
            temp = dfs(visited, next, end, value * valueMap.get(nextKey));
            if (temp != 0.0) break;
        }
        return temp;
    }
    
    private void buildGraph(List<List<String>> equations, double[] values) {
        for (int i = 0; i < values.length; i++) {
            String x = equations.get(i).get(0), y = equations.get(i).get(1);
            valueMap.put(getKey(x, y), values[i]);
            valueMap.put(getKey(y, x), 1.0 / values[i]);
            graph.putIfAbsent(x, new ArrayList<>());
            graph.putIfAbsent(y, new ArrayList<>());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
    }
    
    private String getKey(String a, String b) {
        return String.format("%s->%s", a, b);
    }
}