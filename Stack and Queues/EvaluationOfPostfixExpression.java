
class Solution
{
    public static int evaluatePostFix(String S)
    {
        // Your code here
         Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < S.length() ; i++){
            
            if(S.charAt(i)>=48 && S.charAt(i) <= 57)
            {
                st.push(S.charAt(i)-'0'); 
            }
            
            else{
                
                int a1 = st.pop();
                int a2 = st.pop();
                
                 switch(S.charAt(i))
                {
                    case '+':
                    st.push(a2+a1);
                    break;
                     
                    case '-':
                    st.push(a2- a1);
                    break;
                     
                    case '/':
                    st.push(a2/a1);
                    break;
                     
                    case '*':
                    st.push(a2*a1);
                    break;
            }
                
            }
            
            
        }
        
        return st.pop();
    }
}