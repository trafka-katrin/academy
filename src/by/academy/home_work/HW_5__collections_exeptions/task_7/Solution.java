package by.academy.home_work.HW_5__collections_exeptions.task_7;

import javax.imageio.IIOException;
import java.util.Scanner;

public class Solution {
    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep) throws IIOException {
        while (node != null) {
            System.out.print(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode { int data; DoublyLinkedListNode next;
     * DoublyLinkedListNode prev; }
     *
     */

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode node = head;

        while (node!= null){
            DoublyLinkedListNode tempNext = node.next;
            node.next = node.prev;
            node.prev = tempNext;
            if (node.prev == null) {
                break;
            }
            node = tempNext;
        }
        return node;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IIOException {

        DoublyLinkedList llist = new DoublyLinkedList();

        System.out.println("Введите количество элементов");
        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println("Введите элементы");
        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }
        System.out.println("Реверс");
        DoublyLinkedListNode llist1 = reverse(llist.head);

        printDoublyLinkedList(llist1, " ");
        scanner.close();
    }


}
