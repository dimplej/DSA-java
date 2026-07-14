public class swapvowels { 
    public String reverseVowels(String s) {
        char[] word=s.toCharArray();
        int start=0;
        int end=s.length()-1;
        String vowels="AEIOUaeiou";
        while(start<end){
            while(start<end && vowels.indexOf(word[start])==-1){
                start++;
            }
            while(start<end && vowels.indexOf(word[end])==-1){
                end--;
            }
            char temp=word[start];
            word[start]=word[end];
            word[end]=temp;
        start++;
        end--;
        }
        
        return new String(word);
    }
    public static void main(String[] args){ 
        swapvowels obj=new swapvowels();
        String res=obj.reverseVowels("IceCream");
        System.out.println(res);

    }
}
    

