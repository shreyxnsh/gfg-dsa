//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            obj.xor1ToN(n, arr);
            obj.printArr(n, arr);
            obj.setToZero(n, arr);
            obj.printArr(n, arr);
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Iterate through the array and prints each element followed by a space.
    public void printArr(int n, int arr[]) {
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

// Iterate through the array and sets each element to zero.

    public void setToZero(int n, int arr[]) {
        for(int i=0;i<n;i++){
            arr[i] = 0;
        }
    }

// Iterate through the array and performs a bitwise XOR operation between each element and its index.

    public void xor1ToN(int n, int arr[]) {
        for(int i=0;i<n;i++){
            arr[i] = arr[i] ^ i;
        }
    }
}