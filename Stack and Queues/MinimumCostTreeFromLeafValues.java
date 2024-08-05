class Solution {
    public int mctFromLeafValues(int[] arr) {
          Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i <= arr.length; i++) {
            int num = i == arr.length ? Integer.MAX_VALUE : arr[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                int x = stack.pop();
                ans += stack.isEmpty() ? (num == Integer.MAX_VALUE ? 0 : num * x) : x * Math.min(stack.peek(), num);
            }
            stack.push(num);
        }
        return ans;
    }
}