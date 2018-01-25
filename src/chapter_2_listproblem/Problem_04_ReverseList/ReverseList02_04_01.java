package chapter_2_listproblem.Problem_04_ReverseList;

/**
 * @Author: 于新泽
 * @Date: Created in 17:22 2018/1/25.
 * @site :
 * 反转单项链表和双向链表（士★☆☆☆）40
 */

public class ReverseList02_04_01 {
    /**
     * 单项链表的翻转
     */
    public static class Node {
        int value;
        Node next;
        Node(int data){
            this.value = data;
        }
    }

    public static Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void printNode(Node head){
        System.out.println("Linked List: ");
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 双向链表的翻转
     */

    public static class DoubleNode{
        int value;
        DoubleNode next;
        DoubleNode last;
        DoubleNode(int data){
            this.value = data;
        }
    }

    public static DoubleNode reverseList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre ;
    }

    public static void printDoubleNode(DoubleNode head){
        System.out.println("Double Linked List: ");
        DoubleNode end = null;
        while(head != null){
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("|");
        while(end != null){
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(8);
        n1.next.next = new Node(8);
        n1.next.next.next = new Node(4);
        n1.next.next.next.next = new Node(5);
        n1.next.next.next.next.next = new Node(7);
        n1.next.next.next.next.next.next = new Node(9);
        n1.next.next.next.next.next.next.next = new Node(2);
        n1.next.next.next.next.next.next.next.next = new Node(2);
        n1.next.next.next.next.next.next.next.next.next = new Node(1);
        n1.next.next.next.next.next.next.next.next.next.next = new Node(2);
        printNode(n1);
        n1 = reverseList(n1);
        printNode(n1);
        System.out.println("#################################");

        DoubleNode d1 = new DoubleNode(1);
        d1.next = new DoubleNode(3);
        d1.next.last = d1;
        d1.next.next = new DoubleNode(8);
        d1.next.next.last = d1.next;
        d1.next.next.next = new DoubleNode(4);
        d1.next.next.next.last = d1.next.next;
        d1.next.next.next.next = new DoubleNode(5);
        d1.next.next.next.next.last = d1.next.next.next;
        d1.next.next.next.next.next = new DoubleNode(8);
        d1.next.next.next.next.next.last = d1.next.next.next.next;
        d1.next.next.next.next.next.next = new DoubleNode(8);
        d1.next.next.next.next.next.next.last = d1.next.next.next.next.next;
        d1.next.next.next.next.next.next.next = new DoubleNode(9);
        d1.next.next.next.next.next.next.next.last = d1.next.next.next.next.next.next;
        d1.next.next.next.next.next.next.next.next = new DoubleNode(6);
        d1.next.next.next.next.next.next.next.next.last = d1.next.next.next.next.next.next.next;
        d1.next.next.next.next.next.next.next.next.next = new DoubleNode(1);
        d1.next.next.next.next.next.next.next.next.next.last = d1.next.next.next.next.next.next.next.next;
        d1.next.next.next.next.next.next.next.next.next.next = new DoubleNode(8);
        d1.next.next.next.next.next.next.next.next.next.next.last = d1.next.next.next.next.next.next.next.next.next;
        printDoubleNode(d1);
        d1 = reverseList(d1);
        printDoubleNode(d1);
    }
}
