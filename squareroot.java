import java.util.Scanner;

public class squareroot {
    public int squarerootofinteger(int x){
        if (x<2) return x;
        long left=1;
        long right=x/2;
        while(left<=right){
            long mid=left+((right-left)/2);
            long square=mid*mid;
            if (square==x){
                return (int) mid;
            }
            else if(square<x){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return (int) right;
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        squareroot obj=new squareroot();
        System.out.println("Enter a non-negative number:");
        int x=s.nextInt();
        int squarerootnumber=obj.squarerootofinteger(x);
        System.out.println("Square root of given number is " +squarerootnumber);
    }
}
