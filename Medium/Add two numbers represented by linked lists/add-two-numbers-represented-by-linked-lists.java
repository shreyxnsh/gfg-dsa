//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node num1 = new Node(val);
            Node tail = num1;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node num2 = new Node(val);
            tail = num2;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/


class Solution{
    static Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        Node n = null;
        while(curr != null){
            n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }
        return prev;
    }
    static Node addTwoLists(Node num1, Node num2){
        Node n1 = reverse(num1);
        Node n2 = reverse(num2);
        Node ans = new Node(-1);
        Node re = ans;
        int carry = 0;
        while(n1 != null || n2 != null){
            int sum = carry;
            if(n1 != null){
                sum += n1.data;
                n1 = n1.next;
            }
            if(n2 != null){
                sum += n2.data;
                n2 = n2.next;
            }
            Node temp = new Node(sum%10);
            ans.next = temp;
            ans = temp;
            carry = sum/10;
        }
        if(carry != 0){
            Node temp = new Node(carry);
            ans.next = temp;
            ans = temp;
        }
        Node a = reverse(re.next);
        while(a != null && a.data == 0){
            a = a.next;
        }
        if(a == null)return new Node(0);
        return a;
    }
}