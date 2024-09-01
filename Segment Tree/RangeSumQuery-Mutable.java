
class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        
       ArrayList<ArrayList<String>> res=new ArrayList<>();
       
       ArrayList<String> ans=new ArrayList<>();
       
       find(res,"",0,ans,S);
       return res;
   }
   public static void find(ArrayList<ArrayList<String>> res,String ans,int i,ArrayList<String> m,String s)
   {
       
       if(i==s.length())
       {
           if(palin(ans)) 
           {
               m.add(ans);
               res.add(new ArrayList<>(m));
               m.remove(m.size()-1);
           }
           return;
       }
       
       char ch=s.charAt(i);
       if(palin(ans)&&ans.length()>0){
             m.add(ans); 
           find(res,"",i,m,s);
           m.remove(m.size()-1); 
           find(res,ans+ch,i+1,m,s); 
       }
       else
       find(res,ans+ch,i+1,m,s); 
   }
   public static boolean palin(String s)
   {
       return s.equals(new StringBuilder(s).reverse().toString());
    }
};