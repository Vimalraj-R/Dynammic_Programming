import java.util.Scanner;

/**
 * Problem: Longest Common Subsequence (Length + String Printing)
 * Time Complexity: O(M * N) for DP matrix building and O(M + N) for backtracking.
 * Space Complexity: O(M * N) to maintain the 2D state transition table.
 */
public class LongestCommonSubsequenceString {
    public static void printLCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        // Step 1: Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        int lcsLength = dp[m][n];
        System.out.println("Length of LCS: " + lcsLength);
        
        // Step 2: Backtrack to reconstruct the result string
        StringBuilder res = new StringBuilder();
        int i = m, j = n;
        
        while (i > 0 && j > 0) {
            // If characters match, they are part of the subsequence
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                res.append(str1.charAt(i - 1));
                i--;
                j--;
            } 
            // If they don't match, move in the direction of the maximum value
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        
        // Since we tracked backwards, reverse the accumulated characters
        String lcsString = res.reverse().toString();
        System.out.println("LCS Result String: \"" + lcsString + "\"");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        
        printLCS(str1, str2);
        
        sc.close();
    }
}
