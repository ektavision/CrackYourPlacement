
class Solution
{
     static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    
    public static Node root=null;
    
    public static void insert(String key){
        Node curr=root;
        for(int level=0;level<key.length();level++){
            int i=key.charAt(level)-'a';
            if(curr.children[i]==null)
            curr.children[i]=new Node();
            
            curr=curr.children[i];
        }
        curr.eow=true;
    }
    
    public static boolean search(String key){
        Node curr=root;
        for(int level=0;level<key.length();level++){
            int i=key.charAt(level)-'a';
            if(curr.children[i]==null)
            return false;
            
            curr=curr.children[i];
        }
        return curr.eow==true;
    }
    
    public static boolean solve(String A){
        if(A.length()==0)
        return true;
        
        for(int i=1;i<=A.length();i++){
            if(search(A.substring(0,i)) && solve(A.substring(i)))
            return true;
        }
        return false;
    }
    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
           root=new Node();
        for(String word:B){
            insert(word);
        }
        
        int ans=solve(A)==true?1:0;
        return ans;
    }
    
}