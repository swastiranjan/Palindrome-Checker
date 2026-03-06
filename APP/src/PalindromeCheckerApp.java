import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

// Step 1: Define the Strategy interface
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

// Step 2: Implement concrete strategies

// Using Stack

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        input = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack;
        stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}


class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        input = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// Step 3: Context class that uses a strategy
class PalindromeService {
    private PalindromeStrategy strategy;

    // Inject strategy at runtime
    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String input) {
        return strategy.checkPalindrome(input);
    }
}

// Step 4: Main application
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // Choose Stack strategy
        PalindromeService stackService = new PalindromeService(new StackStrategy());
        System.out.println("Using StackStrategy:");
        System.out.println("Madam -> " + stackService.validate("Madam"));
        System.out.println("Hello -> " + stackService.validate("Hello"));

        // Choose Deque strategy
        PalindromeService dequeService = new PalindromeService(new DequeStrategy());
        System.out.println("\nUsing DequeStrategy:");
        System.out.println("Racecar -> " + dequeService.validate("Racecar"));
        System.out.println("World -> " + dequeService.validate("World"));
    }
}