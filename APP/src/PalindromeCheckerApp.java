import java.util.Stack;
public class PalindromeCheckerApp{

    public static boolean isPalindrome(String input) {
        String cleanText = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char c : cleanText.toCharArray()) {
            stack.push(c);
        }

        for (int i = 0; i < cleanText.length(); i++) {
            if (cleanText.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String test1 = "A man, a plan, a canal: Panama";
        String test2 = "Java Programming";

        System.out.println("\"" + test1 + "\" is a palindrome: " + isPalindrome(test1));
        System.out.println("\"" + test2 + "\" is a palindrome: " + isPalindrome(test2));
    }
}