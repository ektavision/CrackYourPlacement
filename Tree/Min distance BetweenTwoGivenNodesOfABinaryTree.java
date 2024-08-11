class GfG {
    void help(Node root,ArrayList<Integer> curPath,ArrayList<Integer> pathA,ArrayList<Integer> pathB,int a,int b){
       if(root==null)return;
       curPath.add(root.data);
       if(root.data==a)pathA.addAll(curPath);
       if(root.data==b)pathB.addAll(curPath);
       help(root.left,curPath,pathA,pathB,a,b);
       help(root.right,curPath,pathA,pathB,a,b);
       curPath.remove(curPath.size()-1);
   }
   int findDist(Node root, int a, int b) {
       // Your code here
         ArrayList<Integer> curPath = new ArrayList<>();
       ArrayList<Integer> pathA = new ArrayList<>();
       ArrayList<Integer> pathB = new ArrayList<>();
       help(root,curPath,pathA,pathB,a,b);
       int i=0,j=0;
       while(i<pathA.size() && j<pathB.size()){
           if(pathA.get(i)!=pathB.get(j))break;
           i++;
           j++;
       }
       return pathA.size()-i+pathB.size()-j;
   }
}