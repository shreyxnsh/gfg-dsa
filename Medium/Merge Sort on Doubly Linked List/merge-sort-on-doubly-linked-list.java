//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int key) {
        data = key;
        next = prev = null;
    }
}

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                Node n1 = new Node(a);
                n1.prev = temp;
                temp.next = n1;
                temp = n1;
            }

            head = new Solution().sortDoubly(head);
            printList(head);
        }
    }

    public static void printList(Node node) {
        Node temp = node;
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/
class Solution {
    // Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node head) {
        // add your code here
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int n1=count/2;
        int n2=count-n1;
        int[]a=new int[n1];
        int[]b=new int[n2];
        temp=head;
        for(int i=0;i<n1;i++){
            a[i]=temp.data;
            temp=temp.next;
        }
        
        for(int j=0;j<n2;j++){
            b[j]=temp.data;
            temp=temp.next;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        
        Node head1=null;
        Node tail=null;
        int i=0;
        int j=0;
        while(i<n1&&j<n2){
           //Node tem=new Node(0);
           if(a[i]<=b[j]){
               Node t=new Node(a[i]);
               if(head1==null){
               head1=t;
               tail=t;
               }
               else{
                 // Node t=new Node(a[i]);
                  tail.next=t;
                  t.prev=tail;
                  tail=t;
               }
               i++;
           }
           else{
               Node t=new Node(b[j]);
              if(head1==null){
                  head1=t;
                  tail=t;
              }
              else{
                //  Node t=new Node(b[j]);
                  tail.next=t;
                  t.prev=tail;
                  tail=t;
              }
              j++;
           }
           
        }
        while(i<n1){
            Node t=new Node(a[i]);
            tail.next=t;
            t.prev=tail;
            tail=t;
            i++;
        }
        while(j<n2){
            Node t=new Node(b[j]);
            tail.next=t;
            t.prev=tail;
            tail=t;
            j++;
        }
        return head1;
    }
}