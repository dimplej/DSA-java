import java.util.Scanner;
class trapwater{
    public int trap(int[] height) {
        int n=height.length;
        int totalwater=0;
        int leftmax=0;
        int rightmax=0;
        int start=0;
        int end=n-1;
        while(start<end){
            leftmax=Math.max(leftmax,height[start]);
            rightmax=Math.max(rightmax,height[end]);
            if(leftmax<rightmax){
                totalwater+=leftmax-height[start];
                start++;
            }
            else{
                totalwater+=rightmax-height[end];
                end--;
            }
        }
        return totalwater;
    }
    public static void main(String[] args){
        trapwater obj=new trapwater();
        Scanner s=new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n=s.nextInt();
        int[] height=new int[n];
        System.out.println("Enter array:");
        for(int i=0;i<n;i++){
            height[i]=s.nextInt();
        }
        System.out.println("Totalwater : "+ obj.trap(height));
    }
}
    
