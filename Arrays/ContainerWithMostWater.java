class Solution {
    public int maxArea(int[] height) {
         int biggestArea=0;
        int leftP=0;
        int rightP=height.length-1;
        int area=0;
                
        while(leftP<rightP){
        
             area= Math.min(height[leftP],height[rightP])*(rightP-leftP);
            
            if(area>biggestArea){
                biggestArea=area;
            }
            
            if(height[leftP]<height[rightP]){
            leftP++;
        }
        else{
            rightP--;
        }
        }
        
        return biggestArea;
 
    }
}