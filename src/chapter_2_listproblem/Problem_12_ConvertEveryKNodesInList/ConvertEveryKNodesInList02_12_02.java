package chapter_2_listproblem.Problem_12_ConvertEveryKNodesInList;

import com.sun.corba.se.impl.corba.NamedValueImpl;

import java.util.Stack;

/**
 * @Author: 于新泽
 * @Date: Created in 8:10 2018/8/7.
 * @site :
 */

public class ConvertEveryKNodesInList02_12_02 {

    public static class Node {
        int value;
        Node next;
        Node (int data){
            this.value = data;
        }
    }

    public static Node reverseKNodes1 (Node head, int K){
        if(K < 2){
            return head;
        }
        Stack<Node> stack = new Stack<Node>();
        Node newHead = head;
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null){
            next = cur.next;
            stack.push(cur);
            if(stack.size() == K){
                pre = resign1(stack, pre, next);
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }
        return newHead;
    }

    /**
     * 利用栈空间将链表逆序
     * @param stack ： 栈空间
     * @param left ：左边的节点
     * @param right ：
     * @return
     */
    public static Node resign1(Stack<Node> stack,Node left ,Node right){
        Node cur = stack.pop();
        if(left != null){
            left.next = cur;
        }
        Node next = null;
        while (!stack.isEmpty()){
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }

    public static Node reverseKNodes2(Node head, int K) {
        if(K < 2){
            return head;
        }
        Node cur = head;
        Node start = null;
        Node pre = null;
        Node next = null;
        int count = 1;
        while(cur != null){
            next = cur.next;
            if(count == K){
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                resign2(pre, start, cur, next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    /**
     *
     * @param left : 每段的最左侧节点
     * @param start ： 开始的节点
     * @param end ： 结束的节点
     * @param right ： 每段的最右侧节点
     */
    public static void resign2(Node left, Node start, Node end, Node right){
        Node previous = start;
        Node current = start.next;
        Node next = null;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        if(left != null){
            left.next = end;
        }
        start.next = right;
    }

    public static void printLinkedList(Node head){
        System.out.println("Linked List: ");
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = null;
        int K = 3;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        K = 3;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        K = 2;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        K = 3;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        K = 2;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        K = 3;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

    }
}
