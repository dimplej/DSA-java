public class removeelement{
    static int removeelement(int[] nums,int val){
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
public static void main(String[] args){
    int[] nums={1,2,2,3,4,6,2};
    int val=2;
    System.out.println(removeelement(nums,val));
}
}