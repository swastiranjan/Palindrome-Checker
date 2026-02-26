import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = sc.nextLine();

        String reverse = "";
        int length = text.length();
        for (int i = length - 1; i >= 0; i--) {
            reverse = reverse + text.charAt(i);
        }
        if (text.equals(reverse))
            System.out.println("Entered string is a palindrome.");
        else
            System.out.println("Entered string isn't a palindrome.");
        sc.close();
    }
}