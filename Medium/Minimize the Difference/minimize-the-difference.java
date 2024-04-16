//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.minimizeDifference(n, k, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int minimizeDifference(int n, int k, int[] arr) {
        // code here
         int []max=new int[n];
        max[n-1]=arr[n-1];
       int []min=new int[n];
        min[n-1]=arr[n-1];
        
        for(int i=n-2;i>=0;i--){
        max[i]=Math.max(arr[i],max[i+1]);
        min[i]=Math.min(arr[i],min[i+1]);
        }
        int min1=Integer.MAX_VALUE;
        int max1=Integer.MIN_VALUE;
        
        int res=Integer.MAX_VALUE;
        
       // System.out.println(Arrays.toString(min));
       // System.out.println(Arrays.toString(max));
        for(int i=k;i<n;i++){
            int a=Math.max(max[i],max1);
            int b=Math.min(min[i],min1);
         // System.out.println(a+" "+b);
            res=Math.min(res,a-b);
            min1=Math.min(min1,arr[i-k]);
            max1=Math.max(max1,arr[i-k]);
           
        }
        
        res=Math.min(res,max1-min1);
        return res;
    }
}
        
