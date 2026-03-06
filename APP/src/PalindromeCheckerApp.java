public class PalindromeCheckerApp {

    // Method for UC10: Case-Insensitive & Space-Ignored Palindrome
    public static boolean isPalindrome(String input) {
        // Normalize string: remove spaces and convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Check palindrome using two-pointer technique
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Driver code
    public static void main(String[] args) {
        String test1 = "A man a plan a canal Panama";
        String test2 = "Never Odd Or Even";
        String test3 = "Hello World";

        System.out.println("\"" + test1 + "\" -> " + isPalindrome(test1));
        System.out.println("\"" + test2 + "\" -> " + isPalindrome(test2));
        System.out.println("\"" + test3 + "\" -> " + isPalindrome(test3));
    }
}
