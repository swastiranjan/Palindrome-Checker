class PalindromeChecker {
    private String input;

    // Constructor
    public PalindromeChecker(String input) {
        // Normalize string: remove spaces and convert to lowercase
        this.input = input.replaceAll("\\s+", "").toLowerCase();
    }

    // Public method to check palindrome
    public boolean checkPalindrome() {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

// Main application class
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        PalindromeChecker checker1 = new PalindromeChecker("Madam");
        PalindromeChecker checker2 = new PalindromeChecker("Racecar");
        PalindromeChecker checker3 = new PalindromeChecker("Hello World");

        System.out.println("Madam -> " + checker1.checkPalindrome());
        System.out.println("Racecar -> " + checker2.checkPalindrome());
        System.out.println("Hello World -> " + checker3.checkPalindrome());
    }
}
