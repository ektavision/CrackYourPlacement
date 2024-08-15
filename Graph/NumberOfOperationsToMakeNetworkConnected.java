class Solution {
    
    class UF{
        int[] arr;
        int count;
    
        public UF(int n){
            count = n;
            arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = i;
            }
        }
    
        int find(int a){
            if(a != arr[a]){
                arr[a] = find(arr[a]);
            }
            return arr[a];
        }
    
        boolean union(int a, int b){
            if(find(a) != find(b)){
                arr[find(a)] = find(b);
                count--;
                return true;
            }
            return false;
        }
    
        int getCount(){
            return count;
        }
    }
    
        public int makeConnected(int n, int[][] connections) {
             int len = connections.length;
        if(n > len + 1) return -1;
    
        UF uf = new UF(n);
        for(int[] con : connections){
            uf.union(con[0],con[1]);
        }
        return uf.getCount() - 1; 
        }
    }