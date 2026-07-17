import java.util.Scanner;
class mediansortedarrays{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int d=n+m;
        int[] arr=new int[d];
        int i=0,j=0,k=0;
        while(i<n && j<m){
            if(nums1[i] < nums2[j]){
                arr[k++] = nums1[i++];
            }
            else{
                arr[k++] = nums2[j++];
            }
        }

        while(i<n){
            arr[k++] = nums1[i++];
        }

        while(j<m){
            arr[k++] = nums2[j++];
        }
        if(d%2==0) return (arr[d/2-1]+arr[d/2])/2.0;
        else return arr[d/2];          
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        mediansortedarrays obj=new mediansortedarrays();
        System.out.println("Enter no. of elements in array 1:");
        int n=s.nextInt();
        int[] nums1=new int[n];
        System.out.println("Enter sorted array 1:");
        for(int i=0;i<n;i++){
            nums1[i]=s.nextInt();
        }
        System.out.println("Enter no. of elements in array 2:");
        int m=s.nextInt();
        int[] nums2=new int[m];
        System.out.println("Enter sorted array 2:");
        for(int i=0;i<m;i++){
            nums2[i]=s.nextInt();
        }
        System.out.println("Median : "+obj.findMedianSortedArrays(nums1,nums2));
        s.close();
    }
}