

class Solution
{
        Integer[] store;
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
         store = new Integer[n+1];
       store[n] = cut(n,x,y,z);
       return store[n] == Integer.MIN_VALUE ? 0 : store[n];
    }
         public int cut(int n, int x, int y, int z)
    {
        if (n == 0) return 0;
        if (store[n] != null) return store[n];
        int result = 0;
        if (n >= x) result = Math.max(result,cut(n-x,x,y,z)+1);
        if (n >= y) result = Math.max(result,cut(n-y,x,y,z)+1);
        if (n >= z) result = Math.max(result,cut(n-z,x,y,z)+1);
        if (result == 0)
            store[n] = Integer.MIN_VALUE;
        else store[n] = result;
        return store[n];
    }
}
