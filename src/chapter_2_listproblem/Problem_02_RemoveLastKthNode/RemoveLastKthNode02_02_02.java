package chapter_2_listproblem.Problem_02_RemoveLastKthNode;

/**
 * @Author: 于新泽
 * @Date: Created in 16:01 2018/1/25.
 * @site :
 * 在单链表和双链表中删除倒数第K个节点（士★☆☆☆）35
 */

public class RemoveLastKthNode02_02_02 {

    public static class Node{
        int value;
        Node next;
        Node(int data){
            this.value = data;
        }
    }

    public static Node removeLastKNode(Node head,int k){
        if(head == null || k < 1){
            return head;
        }
        Node cur = head;
        while(cur != null){
            k--;
            cur = cur.next;
        }
        if(k == 0){
            return head;
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

    public static void printNode(Node head){
        System.out.println("单链表：");
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static class DoubleNode{
        int value;
        DoubleNode next;
        DoubleNode last;
        DoubleNode(int data){
            this.value = data;
        }
    }

    public static DoubleNode removeLastKDoubleNode(DoubleNode head ,int k){
        if(head == null || k < 1 ){
            return head;
        }
        DoubleNode cur = head;
        while(cur != null){
            k--;
            cur = cur.next;
        }
        if(k == 0){
            return head;
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

    public static void printDoubleNode(DoubleNode head){
        System.out.println("双链表：");
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
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
        n1 = removeLastKNode(n1,4);
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
        d1 = removeLastKDoubleNode(d1,4);
        printDoubleNode(d1);
    }
}
