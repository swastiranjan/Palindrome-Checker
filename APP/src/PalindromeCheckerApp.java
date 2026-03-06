import java.util.Deque;
import java.util.LinkedList;

public class PalindromeCheckerApp{

    public static boolean isPalindrome(String input) {
        input = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new LinkedList<>();

        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }

    // Driver code
    public static void main(String[] args) {
        String test1 = "madam";
        String test2 = "racecar";
        String test3 = "hello";

        System.out.println(test1 + " -> " + isPalindrome(test1));
        System.out.println(test2 + " -> " + isPalindrome(test2));
        System.out.println(test3 + " -> " + isPalindrome(test3));
    }
}