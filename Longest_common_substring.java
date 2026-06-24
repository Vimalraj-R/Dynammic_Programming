import java.util.Scanner;

/**
 * Problem: Longest Common Substring (2D Grid Dynamic Programming)
 * Time Complexity: O(M * N) where M and N are lengths of str1 and str2.
 * Space Complexity: O(M * N) for the 2D DP matrix.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        
        int n1 = str1.length();
        int n2 = str2.length();
        
        int[][] mat = new int[n1 + 1][n2 + 1];
        int max_len = 0;
        int endIndex = 0; // Tracks where the longest substring ends in str2
        
        // Compute DP state transitions
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                // Adjust for 0-indexed character lookups
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                    
                    // Track the maximum length and its ending position
                    if (mat[i][j] > max_len) {
                        max_len = mat[i][j];
                        endIndex = j;
                    }
                }
            }
        }
        
        // Output Results
        System.out.println("Length: " + max_len);
        if (max_len > 0) {
            System.out.println("Substring: " + str2.substring(endIndex - max_len, endIndex));
        } else {
            System.out.println("Substring: ");
        }
        
        sc.close();
    }
}
