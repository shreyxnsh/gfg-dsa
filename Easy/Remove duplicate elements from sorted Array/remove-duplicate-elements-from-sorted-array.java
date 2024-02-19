//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for(int i=0; i<N; i++)
                a[i] = sc.nextInt();
            
            Solution g = new Solution();
            int n = g.remove_duplicate(a,N);
            
            for(int i=0; i<n; i++)
                System.out.print(a[i]+" ");
            System.out.println();
            T--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int remove_duplicate(int A[],int N){
        // code here
         // let's use two-pointer approach
        
        // index 0 is always a unique element
        int i = 0;
        
        for(int j =1; j<N;j++){
            // so start checking from next element if any element does not match the index 0 then save it aside
            if(A[j] != A[i]){
                A[i+1] = A[j];
                i++;
            }
        }
        return i+1;
    }
}