//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        // code here
        
        int ansR = -1, ansC = -1 ;
        
        int r = 0 , c = 0 ;
        char direction = 'r' ;
        
        // char[][] copyMat = new char[n][m] ;
        // for (int i = 0 ; i < n; i++) {
        //     for (int j = 0 ; j < m; j++) {
        //         copyMat[i][j] = matrix[i][j] == 0 ? '0' : '1' ;
        //     }
        // }
        
        while (r >= 0 && r < n && c >= 0 && c < m) {
            ansR = r ;
            ansC = c ;
            
            
            if (matrix[r][c] == 1) { // we have to change the direction and move a step
                matrix[r][c] = 0;
                if (direction == 'r') direction = 'd' ;
                else if (direction == 'd') direction = 'l' ;
                else if (direction == 'l') direction = 'u' ;
                else direction = 'r' ;
            }
            
            // copyMat[r][c] = direction ;
            
            // if its 0, we have to move a step in the same direction
            if (direction == 'r') c++ ;
            else if (direction == 'd') r++ ;
            else if (direction == 'l') c-- ;
            else r-- ;
        }
        
        // for (char[] row : copyMat) {
        //     System.out.println(Arrays.toString(row)) ;
            
        // }
        
        return new int[]{ansR, ansC} ;
    }
}