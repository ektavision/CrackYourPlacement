class GfG
{
   int maxLen(int arr[], int n)
    {

        
         HashMap<Integer, Integer> mp = new HashMap<>();

       
        int sum = 0;
    int size=0;

        for(int i = 0; i< arr.length;i++){
            sum += arr[i];
            int diff = sum ;
           
            int x =  mp.getOrDefault(diff,0);
            if(mp.containsKey(diff)){
                size = Math.max(size , i-x );
            }
        else{
            if(sum ==0){
                size = Math.max(size, i+1);
            }
            else{
            mp.put(sum,i);
            }
        }

        }
        
        return size;

    }
}
