import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode tempNode = new SinglyLinkedListNode(data);

        SinglyLinkedListNode pointer = head;
        for (int i = 1; ; i++) {
            if (pointer == null)
                break;
            if (i == position) {
                tempNode.next = pointer.next;
                pointer.next = tempNode;
                break;
            }
            pointer = pointer.next;
        }
        return head;
    }

    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {


        SinglyLinkedListNode current = head;
        SinglyLinkedListNode prev = null;
        if (position == 0) {
            head = head.next;
            return head;
        }
        for (int i = 1; i <= position; i++) {
            if (current.next != null) {
                prev = current;
                current = current.next;
            }
        }
        prev.next = current.next;
        return head;

    }
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {

        SinglyLinkedListNode current = head;
        SinglyLinkedListNode previous = null;
        SinglyLinkedListNode next = null;
        while(current!=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;

        return head;

    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode tempNode = new SinglyLinkedListNode(0);
        SinglyLinkedListNode tail = tempNode;
        while(true){
            if(head1==null){
                tail.next =head2;
                break;
            }

            if(head2==null){
                tail.next = head1;
                break;
            }

            if(head1.data<=head2.data){
                tail.next = head1;
                head1= head1.next;
            }
            else{
                tail.next = head2;
                head2 = head2.next;
            }

            tail = tail.next;
        }

        return tempNode.next;
    }



    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) throws IOException {
        while (node != null) {
            node = node.next;
            System.out.print(node);
            System.out.print(sep);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        int data = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int position = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);

        printSinglyLinkedList(llist_head, " ");

        scanner.close();
    }
}

