
package linkedList;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class linkedList {
    public static void printLL(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + "-->");
            head = head.next;
        }
    }

    public static int countlength(Node<Integer> head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static int printIthEle(Node<Integer> node, int i) {
        int count = 0;
        int ans = 0;
        while (node != null) {
            if (count == i) {
                ans = node.data;
                break;
            }
            node = node.next;
            count++;
        }
        return ans;
    }
    public static Node<Integer> takeInput() {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null;
        Node<Integer> tail = null;
        while (data != -1) {
            Node<Integer> currentNode = new Node<Integer>(data);
            if (head == null) {
                head = currentNode;
                tail = currentNode;
            } else {
                tail.next = currentNode;
                tail = currentNode;
            }
            data = sc.nextInt();
        }
        return head;
    }
    public static Node<Integer> insertNode(Node<Integer> head, int data, int pos) {
        Node<Integer> newNode = new Node<Integer>(data);
        if (pos == 0) {
            newNode.next = head;
            return newNode;
        }
        int i = 0;
        Node<Integer> temp = head;
        while (i < pos - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    public static int findNodePos(Node<Integer> head, int node) {
        if (head == null) {
            return -1;
        }
        int i = 0;
        int ans = -1;
        while (head != null) {
            if (node == head.data) {
                ans = i;
            }
            i++;
            head = head.next;
        }
        return ans;
    }

    public static Node<Integer> nNodeToFirst(Node head, int k) {
        Node<Integer> temp = head;
        Node<Integer> tail = head;
        int i =0;
        while (i < 5- k-1){
            temp = temp.next;
            i++;
        }
        head = temp.next;
        temp.next = null;
        Node<Integer> tempTail = head;
        while (tempTail.next!=null){
            tempTail = tempTail.next;
        }
        tempTail.next = tail;
        return head;
    }
    public static Node removeDuplipate(Node head){
        Node<Integer> newHead = head;
        while(newHead.next!=null){
            if(newHead.data.equals(newHead.next.data)){
                newHead.next = newHead.next.next;
            }
            else {
                newHead = newHead.next;
            }
        }
        return head;
    }
    public static Node printResverse(Node head){
        Node<Integer> prev = null;
        Node<Integer> curr = head;
        Node<Integer> next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static Node mid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast !=null && fast.next !=null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Boolean isPalindrome(Node head){
        if(head==null){
            return true;
        }
        Node<Integer> mid = mid(head);
        Node<Integer> last = null;
        if(countlength(head)%2!=0) {
             last = printResverse(mid.next);
        }
        else{
            last = printResverse(mid);
        }
        Node<Integer> curr = head;
        while(last != null){
            if(curr.data !=last.data){
                return  false;
            }
            last = last.next;
            curr = curr.next;
        }
        return true;
    }
    public static Node recrev(Node head){
        if(head.next==null){
            return head;
        }
        Node rhead = recrev(head.next);
        head.next.next = head;
        head.next = null;
        return head;
    }
    public static void incLast(Node head){
        Node<Integer> temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }

        temp.data++;
    }
    public static Node delete(Node head,int pos ){
        if(pos==0){
            return head.next;
        }
        Node temp = head;
        int c = 0;
        while (c<pos-1){
            temp = temp.next;
            c++;
        }
        Node temp2 = temp.next;
        temp.next = temp2.next;
        return head;
    }
    public static Node<Integer> insertRecrussion(Node head, int ele ,int pos ){
        if(head ==null ){
            return head;
        }
        if(pos==0){
            Node<Integer> newNode = new Node<>(ele);
            newNode.next = head;
            return newNode;
        }
        else{
            Node<Integer> smallhead = insertRecrussion(head.next, ele,pos-1);
            head.next = smallhead;
            return head;
        }
    }
    public static Node<Integer> deleteRecrussion(Node head,int pos){
        if(head ==null){
            return head;
        }
        if(pos==0){
            return head.next;
        }
        else{
            head.next = deleteRecrussion(head.next, pos-1);
            return head;
        }
    }


    //MAIN FUNCTION
    public static void main(String[] args) {
        Node<Integer> head = takeInput();
//   head = insertNode(head,5,3);
//   printll(head);
//   System.out.println("The length of ll is :"+countlength(head));
//   System.out.println("the element at index i is:"+printIthEle(head,3));
//   System.out.println("the node is present at"+ findNodePos(head,3));
//
//
//        Node<Integer> h1 = nNodeToFirst(head,3);
//        Node<Integer> h2 = removeDuplipate(head);
        //System.out.print(isPalindrome(head));
//        printll(h3);
//        Node<Integer> mid = mid(head);
//        System.out.print(mid.data);

//        Node h1 = recrev(head);
//
//        Node h2 = printResverse(head);
//        printll(h2);
//        incLast(head);
//        printll(head);
        Node<Integer> h1 = deleteRecrussion(head,1);
        printLL(h1);

    }
}