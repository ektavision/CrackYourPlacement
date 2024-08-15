public class Main {

    static final int V = 4;

    static boolean isSafe(int v, boolean[][] graph, int[] color, int c) {
        for (int i = 0; i < V; i++)
            if (graph[v][i] && c == color[i])
                return false;
        return true;
    }
    static boolean graphColoringUtil(boolean[][] graph, int m, int[] color, int v) {
        if (v == V)
            return true;

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, color, c)) {
                color[v] = c;
                if (graphColoringUtil(graph, m, color, v + 1))
                    return true;
                color[v] = 0;
            }
        }

        return false;
    }

    static boolean graphColoring(boolean[][] graph, int m) {
        int[] color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;

        if (!graphColoringUtil(graph, m, color, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }
        printSolution(color);
        return true;
    }
    static void printSolution(int[] color) {
        System.out.print("Solution Exists: Following are the assigned colors\n");
        for (int i = 0; i < V; i++)
            System.out.print(" " + color[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        boolean[][] graph = {
            { false, true, true, true },
            { true, false, true, false },
            { true, true, false, true },
            { true, false, true, false }
        };

        int m = 3;

        graphColoring(graph, m);
    }
}