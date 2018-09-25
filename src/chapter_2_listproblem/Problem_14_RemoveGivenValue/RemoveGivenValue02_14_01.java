package chapter_2_listproblem.Problem_14_RemoveGivenValue;

import java.util.Stack;

/**
 * @Author: 于新泽
 * @Date: Created in 2018/9/21 10:37
 * @site :
 * @Description :
 * 在单链表中删除指定值的节点（士★☆☆☆）73
 */
public class RemoveGivenValue02_14_01 {

    public static class Node {
        int value;
        Node next;
        Node (int data) {
            this.value = data;
        }
    }

    /**
     * 利用栈或者其他容器收集节点的方法。时间复杂度O（N）,额外空间复杂度O（N）
     * @param head ： 节点
     * @param num ： 要删除的值
     * @return
     */
    public static Node removeValue1(Node head,int num){
        Stack<Node> stack = new Stack<Node>();
        while (head != null){
            if(head.value != num){
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()){
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    /**
     * 不利用任何容器而直接调整方法。时间复杂度O（N）,额外空间复杂度O(1)
     * @param head ：节点
     * @param num ： 要删除的值
     * @return
     */
    public static Node removeValue2(Node head, int num){
        while (head != null){
            if(head.value != num){
                break;
            }
            head = head.next;
        }
        Node previous = head;
        Node current = head;
        while (current != null){
            if(current.value == num){
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }
        return head;
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
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next = new Node(1);
        head = removeValue1(head, 1);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next = new Node(1);
        head = removeValue2(head, 1);
        printLinkedList(head);
    }
}
