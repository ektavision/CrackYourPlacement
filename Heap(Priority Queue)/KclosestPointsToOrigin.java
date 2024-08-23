class Solution {
    public int[][] kClosest(int[][] points, int k) {
     Queue<int[]> maxHeap = new PriorityQueue<>((a,b)-> dist(b) - dist(a));
        
        for(int[] point : points){
            maxHeap.add(point);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        int[][] res = new int[k][2];
        int i = 0;
        while(maxHeap.isEmpty() == false){
            res[i++] = maxHeap.poll();
        }
        return res;
    }
    private int dist(int[] points){
        int x = points[0];
        int y = points[1];
        return x * x + y * y;
    }
}