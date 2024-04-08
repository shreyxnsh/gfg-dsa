//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(n, arr)); 
        }
    }
    
    
}
// } Driver Code Ends



class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int n, int arr[])
    {
        // Your code here
        long[][] dp = new long[n][n];
        for(long[]e:dp){
            Arrays.fill(e,-1);
        }
        return helper(arr,dp,0,arr.length-1,0);
    }
    
    static long helper(int[] arr,long[][] dp,int l,int r,int p){
        if(l>r)
            return 0;
        if(dp[l][r]!=-1)
            return dp[l][r];
        long total = 0;
        long res = p == 1 ? Long.MAX_VALUE : Long.MIN_VALUE;
        total = arr[l];
        if(p==0){
            res = Math.max(res,total+helper(arr,dp,l+1,r,1));
        }
        else
            res = Math.min(res,helper(arr,dp,l+1,r,0));
        total = arr[r];
        if(p==0){
            res = Math.max(res,total+helper(arr,dp,l,r-1,1));
        }
        else
            res = Math.min(res,helper(arr,dp,l,r-1,0));
        return dp[l][r] = res;
    }
}
