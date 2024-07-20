class Solution {
    public int maxProfit(int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int pro = 0;

    for (int i=0; i<prices.length; i++){
        min_price = Math.min(min_price, prices[i]);
        pro = Math.max(pro, prices[i]-min_price);
    }
    return pro;

    }
}