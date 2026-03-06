public class PalindromeCheckerApp {

    // Recursive method to check palindrome
    public static boolean isPalindromeRecursive(String s, int start, int end) {
        // Base case: if start crosses end, it's a palindrome
        if (start >= end) {
            return true;
        }

        // If mismatch found
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }

        // Recursive call: move inward
        return isPalindromeRecursive(s, start + 1, end - 1);
    }

    // Public method to call recursion
    public static boolean isPalindrome(String input) {
        input = input.replaceAll("\\s+", "").toLowerCase();
        return isPalindromeRecursive(input, 0, input.length() - 1);
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
