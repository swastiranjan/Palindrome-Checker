import java.util.Scanner;
public class PalindromeCheckerApp {
    public static void main(String[] args){
        String text= "ok";
        int n=text.length()-1;
        boolean b=false;
        for(int i=0;i<n;i++){
            if(text.charAt(i)==text.charAt(n-i)){
                b=true;
            }
        }
        if(b==true){
            System.out.println(text + " is a palindrome");
        }
        else{
            System.out.println(text+" is not a palindrome");
        }
    }
}
