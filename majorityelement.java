public class majorityelement {
    static int findmajorityelementbruteforce(int[] nums){
        for(int i=0;i<nums.length;i++){
            int count=0;
            int majorityelement=nums[i];
            for(int j=0;j<nums.length;j++){
                if(majorityelement==nums[j]){
                    count++;
                }
            }
            if (count>nums.length/2){
                return majorityelement;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums={2,2,3,3,1,2,2,2,2,2};
        int res=findmajorityelementbruteforce(nums);
        if(res!=-1){
          System.out.println(res);
        }
        else{
          System.out.println("Majority element does not exist");
        }  
  }
    
}
