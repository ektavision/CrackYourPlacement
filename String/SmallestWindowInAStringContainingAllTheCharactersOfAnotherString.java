
class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
           HashMap<Character,Integer> map2 = new HashMap<>();
       String ans="";
       for(int i=0;i<p.length();i++){
           char ch = p.charAt(i);
           map2.put(ch,map2.getOrDefault(ch,0)+1);
       }
       
       HashMap<Character,Integer> map1 = new HashMap<>();
       int left=0;
       int right=0;
       int matchCount=0;
       int desriedMatchCount=p.length();
       while(true){
           boolean flag1=false;
            boolean flag2=false;
          
           while(right<s.length() && matchCount<desriedMatchCount ){
               char ch = s.charAt(right);
               map1.put(ch,map1.getOrDefault(ch,0)+1);
               
               if(map1.getOrDefault(ch,0)<=map2.getOrDefault(ch,0) ){
                   matchCount++;
               }
               right++;
               flag1=true;
           }
           

           while(left<right && matchCount==desriedMatchCount){
              String pAns=s.substring(left,right);
               if(ans.length()==0 || pAns.length()<ans.length()){
                   ans=pAns;
               }
               
               char ch = s.charAt(left);
               if(map1.get(ch)==1){
                   map1.remove(ch);
               }else{
                   map1.put(ch,map1.get(ch)-1);
               }
               
               if(map1.getOrDefault(ch,0) < map2.getOrDefault(ch,0)){
                   matchCount--;
               }
               left++;
                 flag2=true;
           }
           if(flag1==false && flag2==false){
               break;
           }
       }
       if(ans.length()==0){
           return "-1";
       }
       return ans;
    }
}