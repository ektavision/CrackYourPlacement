class Solution {
    public int trap(int[] height) {
         if (height == null || height.length == 0) {
            return 0;
        }
        
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.empty()) {
                    continue;
                }
                int width = i - stack.peek() - 1;
                int heights = Math.min(height[i], height[stack.peek()]) - height[top];
                ans += width * heights;
            }
            stack.push(i);
        }
        
        return ans;
    }
}