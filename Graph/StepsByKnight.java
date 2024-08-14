
class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
          boolean[][] vis = new boolean[N + 1][N + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{KnightPos[0], KnightPos[1], 0});
        int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
        int[] dy = {2, -2, 2, -2, -1, 1, 1, -1};
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int steps = queue.peek()[2];
            if (x == TargetPos[0] && y == TargetPos[1]) {
                min = Math.min(min, steps);
            }
            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 1 && newY >= 1 && newX <= N && newY <= N && !vis[newX][newY]) {
                    queue.add(new int[]{newX, newY, steps + 1});
                    vis[newX][newY] = true;
                }
            }
            queue.poll();
        }
        return min;
    }
}