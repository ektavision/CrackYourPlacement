class Solution {
         static void help(ArrayList<Integer> arr,int n,HashSet<ArrayList<Integer>> mm,int index){
      if(index==n){
          ArrayList<Integer> nn = new ArrayList<>(arr);
          mm.add(nn);
          return;
      }
      for(int i=index;i<n;i++){
          int a = arr.get(i);
          int b = arr.get(index);
          arr.set(i,b);
          arr.set(index,a);
          help(arr,n,mm,index+1);
          arr.set(i,a);
          arr.set(index,b);
      }
    }
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<ArrayList<Integer>> mm = new HashSet<>();
        help(arr,n,mm,0);
        for(ArrayList<Integer> temp:mm)ans.add(temp);
        Collections.sort(ans, new Comparator<List<Integer>>() {
            public int compare(List<Integer> a, List<Integer> b) {
                int i = 0;
                while(i<n) {
                    if(a.get(i).compareTo(b.get(i)) != 0)
                        return a.get(i).compareTo(b.get(i));
                    i++;
                }
                return 0;
            }
        });
        return ans;
        
    }
};