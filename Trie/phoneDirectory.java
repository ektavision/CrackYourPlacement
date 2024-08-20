class Solution{
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        ArrayList<String> data;
        
        public Node(){
            data = new ArrayList<>();
            for(int i =0;i<26;i++){
                children[i] = null;
            }
        }
    }
    
    public static Node root = null;
    public static ArrayList<ArrayList<String>> ans;
    
    public static void insert(String key){
        Node curr = root;
        for(int i = 0;i<key.length();i++){
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr.children[idx].data.add(key);
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    
    public static void displayContact(String str){
        Node curr = root;
        for(int i = 0;i<str.length();i++){
            int idx = str.charAt(i) - 'a';
            
            if(curr.children[idx] != null && i == str.length() -1 ){
                ArrayList<String> list = curr.children[idx].data;
                Collections.sort(list);
                ans.add(list);
            }
            
            if(curr.children[idx] == null){
                ArrayList<String> temp = new ArrayList<>();
                temp.add("0");
                ans.add(temp);
                
                return;
            }
            curr = curr.children[idx];
            
        }
    }
    
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        root = new Node();
        ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        
        for(String st : contact){
            set.add(st);
        }
        
        for(String str : set){
            insert(str);   
        }
        
        for(int i = 1;i<=s.length();i++){
            displayContact(s.substring(0,i));
        }
        
        return ans;
    }
}
