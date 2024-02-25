//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            int A[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0;i < n;i++)
            {
                A[i] = Integer.parseInt(s[i]);
            }
            int key = Integer.parseInt(in.readLine().trim());
            
            out.println(new Solution().search(A, 0, n - 1, key));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int search(int arr[], int l, int h, int key)
    {
        if (l > h)
            return -1;
 
        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;
 
        /* If arr[l...mid] first subarray is sorted */
        if (arr[l] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return search(arr, mid + 1, h, key);
        }
 
        /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarray*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid + 1, h, key);
 
        return search(arr, l, mid - 1, key);
    }
}