//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String []element = line1.trim().split(" ");
		    int n = Integer.parseInt(element[0]);
		    int target = Integer.parseInt(element[1]);
		    
		    int arr[] = new int[n];
		    
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split(" ");
		    
		    for(int index = 0;index < n; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.findClosest(arr, n, target));
		        
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
    public static int findClosest(int arr[], int n, int target) 
    { 
        // Complete the function
                int start = 0;
        int end = n -1;
        int closest = arr[0]; // Initialize closest to the first element
        // arr = [1,3,6,7]
        // target = 4
        
        while(start<=end){
            int mid = start + (end-start) /2;
            
            // Update closest if current element is closer to target
            if (Math.abs(arr[mid] - target) < Math.abs(closest - target) ||
                (Math.abs(arr[mid] - target) == Math.abs(closest - target) && arr[mid] > closest)) {
                closest = arr[mid];
            }
            
            if (arr[mid] > target) {
                end = mid - 1;
            }
            // If target is greater than mid, search right half
            else if (arr[mid] < target) {
                start = mid + 1;
            }
            // If mid is the target, return mid
            else {
                return arr[mid];
            }
        }
        
        return closest;
    } 
}

