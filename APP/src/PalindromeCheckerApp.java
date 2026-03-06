import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class PalindromeCheckerApp {

    // --- Strategy 1: Stack-based ---
    public static boolean stackPalindrome(String input) {
        input = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) return false;
        }
        return true;
    }

    // --- Strategy 2: Deque-based ---
    public static boolean dequePalindrome(String input) {
        input = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    // --- Strategy 3: Recursive ---
    public static boolean recursivePalindrome(String input, int start, int end) {
        if (start >= end) return true;
        if (input.charAt(start) != input.charAt(end)) return false;
        return recursivePalindrome(input, start + 1, end - 1);
    }

    // --- Performance Comparison ---
    public static void comparePerformance(String input) {
        System.out.println("Comparing performance for: \"" + input + "\"");

        // Stack Strategy
        long startTime = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long stackTime = System.nanoTime() - startTime;

        // Deque Strategy
        startTime = System.nanoTime();
        boolean dequeResult = dequePalindrome(input);
        long dequeTime = System.nanoTime() - startTime;

        // Recursive Strategy
        startTime = System.nanoTime();
        boolean recursiveResult = recursivePalindrome(
                input.replaceAll("\\s+", "").toLowerCase(),
                0, input.replaceAll("\\s+", "").toLowerCase().length() - 1
        );
        long recursiveTime = System.nanoTime() - startTime;

        // Display results
        System.out.println("StackStrategy: " + stackResult + " | Time: " + stackTime + " ns");
        System.out.println("DequeStrategy: " + dequeResult + " | Time: " + dequeTime + " ns");
        System.out.println("RecursiveStrategy: " + recursiveResult + " | Time: " + recursiveTime + " ns");
    }

    // Driver code
    public static void main(String[] args) {
        comparePerformance("A man a plan a canal Panama");
        comparePerformance("racecar");
        comparePerformance("hello world");
    }
}
