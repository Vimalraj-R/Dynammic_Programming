import java.util.Scanner;

/**
 * Problem: Fibonacci Number using Space-Optimized Dynamic Programming
 * Time Complexity: O(N) because we iterate exactly from 2 to N.
 * Space Complexity: O(1) as we only use variables instead of an array.
 */
public class Fibonacci {
    public static int getFibonacci(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        // Variables to store the previous two states
        int prev2 = 0; // F(i - 2)
        int prev1 = 1; // F(i - 1)
        int current = 0;
        
        // State transition loop
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2; // Transition formula
            prev2 = prev1;          // Update F(i - 2) for the next iteration
            prev1 = current;        // Update F(i - 1) for the next iteration
        }
        
        return current;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        if (n < 0) {
            System.out.println("Please enter a non-negative integer.");
        } else {
            int result = getFibonacci(n);
            System.out.println("Fibonacci number at position " + n + " is: " + result);
        }
        
        sc.close();
    }
}
