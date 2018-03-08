package chapter_2_listproblem.Problem_02_RemoveLastKthNode;

/**
 * @Author: 于新泽
 * @Date: Created in 14:26 2018/1/22.
 * @site :
 * 在单链表和双链表中删除倒数第K个节点（士★☆☆☆）35
 */

public class RemoveLastKthNode02_02_01 {

    /**
     * 单链表部分
     */
    public static class Node{
        int value;
        Node next;
        Node(int data) {
            this.value = data;
        }
    }

    public static Node removeLastKthNode(Node head,int k){
        if(head == null || k < 1){
            return head;
        }
        Node cur = head;
        while(cur != null){
            k--;
            cur = cur.next;
        }
        if(k == 0){
            head = head.next;
        }
        if(k < 0){
            cur = head;
            while(++k != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void printLinkedList(Node head){
        System.out.print("Linked List: ");
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 双链表部分
     */
    public static class DoubleNode{
        int value;
        DoubleNode last;
        DoubleNode next;
        DoubleNode(int data){
            this.value = data;
        }
    }

    public static DoubleNode removeLastKDoubleNode(DoubleNode head,int k){
        if(head == null || k < 0){
            return head;
        }
        DoubleNode cur = head;
        while(cur != null){
            k--;
            cur = cur.next;
        }
        if(k == 0){
            head = head.next;
            head.last = null;
        }
        if(k < 0){
            cur = head;
            while(++k != 0){
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if(newNext != null){
                newNext.last = cur;
            }
        }
        return head;
    }

    public static void printDoubleLinkedList(DoubleNode head){
        System.out.println(" : ");
        DoubleNode end = null;
        while(head != null){
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while(end != null){
            System.out.print(end.value + "-");
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
        printLinkedList(n1);
        n1 = removeLastKthNode(n1,4);
        printLinkedList(n1);
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
        printDoubleLinkedList(d1);
        d1 = removeLastKDoubleNode(d1,4);
        printDoubleLinkedList(d1);

    }
}
