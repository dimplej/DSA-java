public class maxwater {
    public int Area(int[] height){
        int left=0;
        int right=height.length-1;
        int maximum_Area=0;
        while(left<right){
            int curArea=Math.min(height[left],height[right])*(right-left);
            maximum_Area=Math.max(maximum_Area,curArea);
            if(height[left]<height[right])
                left++;
            else
                right--;
        }

        return maximum_Area;
    }
    public static void main(String[] args){
        maxwater obj=new maxwater();
        int[] height={1,1};
        System.out.println("Maximum area: "+obj.Area(height));

    }
}
    
