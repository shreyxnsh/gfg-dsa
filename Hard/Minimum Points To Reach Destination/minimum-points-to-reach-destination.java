//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int points[][] = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) points[i][j] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minPoints(points, m, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int help(int i, int j, int m, int n, int[][] points, int[][] dp) {
        if (i == m - 1 && j == n - 1)
            return Math.max(1, 1 - points[i][j]); // Adjusted to handle cases when points[i][j] > 1
        if (i == m || j == n)
            return Integer.MAX_VALUE;
        if (dp[i][j] != -1)
            return dp[i][j];
        int a = help(i, j + 1, m, n, points, dp);
        int b = help(i + 1, j, m, n, points, dp);
        return dp[i][j] = Math.max(1, Math.min(a, b) - points[i][j]); // Corrected calculation
    }

    public int minPoints(int[][] points, int m, int n) {
        // Your code goes here
        int[][] dp = new int[m][n];
        for (int[] temp : dp)
            Arrays.fill(temp, -1);
        return help(0, 0, m, n, points, dp);
    }
}