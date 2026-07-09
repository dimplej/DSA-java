import java.util.PriorityQueue;
import java.util.Scanner;

public class kthlargest {
    public int kthlargestelement(int[] arr,int k){
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        for(int num:arr){
            minheap.add(num);
            if(minheap.size()>k){
                minheap.poll();
            }
        }
        return minheap.peek();
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        kthlargest obj=new kthlargest();
        System.out.println("Enter number of elements in array:");
        int n=s.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        System.out.println("Enter the kth value:");
        int k=s.nextInt();
        if(k>0 && k<=n){
            int res=obj.kthlargestelement(arr,k);
            System.out.println("The " + k +" th largest element is "+res);
        }
        else{
            System.out.println("Invalid k value!");
        }
        s.close();       
    }
}
