class Solution {
    static Node ptr1=null;
    static int max=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        
            ptr1=null;
        max=Integer.MIN_VALUE;
    
        search(root,key);
        if (ptr1!=null)
            pre[0]=ptr1;
     
        min=Integer.MAX_VALUE;
        ptr1=null;
        search2(root,key);
        if (ptr1!=null)
            suc[0]=ptr1;
    }
        public static void search(Node root,int key){
        if(root==null) return;
        if (root.data>max && root.data<key) {
            ptr1=root;
            max=Math.max(max, root.data);
            search(root.right,key);
        }
        else  search(root.left,key);
    }
    public static void search2(Node root,int key){
        if(root==null) return;
        if (root.data<min && root.data>key) {
            ptr1=root;
            min=Math.min(min, root.data);
            search2(root.left,key);
        }
        else search2(root.right,key);
    }
}