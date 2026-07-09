import java.util.Arrays;
import java.util.Scanner;
public class reversearray{
    public static void reversearray(int[] arr,int len){
        for(int i=0;i<arr.length/2;i++){
            int temp=arr[i];
            arr[i]=arr[len-i-1];
            arr[len-i-1]=temp;  
        }
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n=s.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        reversearray(arr,n);
        System.out.println(Arrays.toString(arr));   
    }
}