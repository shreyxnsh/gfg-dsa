//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;
 class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
class GFG {

static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
  public static void main(String[] args) throws IOException {
    BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
    int T=Integer.parseInt(bu.readLine());
    while (T-- > 0) {
      
      String s=bu.readLine();
      Node root = buildTree(s);
       if (root == null)
        continue;
      if (root.left == null && root.right == null)
        continue;
      Solution obj = new Solution();
      int ans = obj.absolute_diff(root);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

/*The Node structure is defined as
struct Node {
    int data;
    Node *left;
    Node *right;

};
*/
class MinMaxAns{
    int min;
    int max;
    int ans;
    MinMaxAns(int min, int max, int ans){
        this.min = min;
        this.max = max;
        this.ans = ans;
    }
}
class Solution
{
    
    int absolute_diff(Node root)
    {
        //Your code here
       return helper(root).ans;
    }
    
    MinMaxAns helper(Node root){
        // leaf node
        if(root.left == null && root.right == null){
            return new MinMaxAns(root.data, root.data, Integer.MAX_VALUE);
        }
        MinMaxAns leftchild  = null, rightchild = null;
        
        if(root.left != null){
            leftchild = helper(root.left);
        }
        if(root.right != null){
            rightchild = helper(root.right);
        }
        
        if(leftchild == null){
          rightchild.ans = Math.min(rightchild.ans, rightchild.min - root.data);
          rightchild.min = root.data;
          return rightchild;
        } 
        if(rightchild == null){
          leftchild.ans = Math.min(leftchild.ans, root.data - leftchild.max);
          leftchild.max = root.data;
          return leftchild;  
        } 
        int ans = Math.min(root.data - leftchild.max, rightchild.min - root.data);
        return new MinMaxAns(leftchild.min, rightchild.max, Math.min(ans, Math.min(rightchild.ans, leftchild.ans)));
    }
}
