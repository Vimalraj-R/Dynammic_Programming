**Unbounded or Iterative method in DP**

import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int target = sc.nextInt();
		int[] coins = new int[n];
		for(int ind=0; ind<n; ind++) {
			coins[ind] = sc.nextInt();
		}
		
		// FIX 1: Array size must be target + 1
		int[] dp = new int[target + 1];
        
		// FIX 2: Use (target + 1) to avoid Integer.MAX_VALUE overflow
		Arrays.fill(dp, target + 1);
		dp[0] = 0;
		
		for(int ind=1; ind<=target; ind++) {
			// FIX 3: Changed 'int[] coin' to 'int coin'
			for(int coin : coins){
				if(ind-coin >= 0) {
					dp[ind] = Math.min(dp[ind], dp[ind-coin] + 1);
				}
			}
		}
        
		if(dp[target] > target){ 
			System.out.println("Minimum number of coins to make target: " + -1);
		} else {
			System.out.println("Minimum number of coins to make target: " + dp[target]);
		}
	}
}
