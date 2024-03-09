//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String S = sc.next();
                    int R = sc.nextInt();
                    int N = sc.nextInt();
                    Solution obj = new Solution();
                    System.out.println(obj.nthCharacter(S,R,N));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        //code here
        StringBuilder temp = new StringBuilder();
        while(r!=0){
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1')temp.append("10");
                else temp.append("01");
                if(temp.length()>n)break;
            }
            s=temp.toString();
            temp.setLength(0);
            r--;
        }
        return s.charAt(n);
        
    }
}