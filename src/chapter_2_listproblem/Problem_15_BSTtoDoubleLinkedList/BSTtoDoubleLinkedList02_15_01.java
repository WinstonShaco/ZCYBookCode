package chapter_2_listproblem.Problem_15_BSTtoDoubleLinkedList;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: 于新泽
 * @Date: Created in 2018/9/25 10:28
 * @site : 将搜索二叉树转换成双向链表（尉★★☆☆）74
 * @Description :
 */
public class BSTtoDoubleLinkedList02_15_01 {

    public static class Node {
        int value;
        Node left;
        Node right;
        Node (int data){
            this.value = data;
        }
    }

    /**
     * 用队列等容器收集二叉树中序遍历结果的方法。时间复杂度为O（N），额外空间复杂度O（N）
     * @param head
     * @return
     */
    public static Node convert1(Node head){
        Queue<Node> queue = new LinkedList<Node>();
        inOrderToQueue(head, queue);
        if(queue.isEmpty()){
            return head;
        }
        head = queue.poll();
        Node previous = head;
        previous.left = null;
        Node current = null;
        while (!queue.isEmpty()){
            current = queue.poll();
            previous.right = current;
            current.left = previous;
            previous = current;
        }
        previous.right = null;
        return head;
    }

    /**
     * 二叉树中序遍历
     * @param head
     * @param queue
     */
    public static void inOrderToQueue(Node head, Queue<Node> queue){
        if(head == null){
            return;
        }
        inOrderToQueue(head.left,queue);
        queue.offer(head);
        inOrderToQueue(head.right,queue);
    }

    /**
     * 利用递归函数，除此之外不用任何容器的方法
     * 时间复杂度为O（N）,额外空间复杂度O(h)
     * h为二叉树的高度
     * @param head
     * @return
     */
    public static Node convert2(Node head){
        if (head == null){
            return null;
        }
        Node last = process(head);
        head = last.right;
        last.right = null;
        return head;
    }

    /**
     * 将一棵搜索二叉树转换为一个结构有点特殊的有序双向链表
     * 结构特殊是指这个双向链表尾节点的right指针指向该双向链表的头节点
     * @param head
     * @return ：最终返回这个链表的为节点
     */
    public static Node process(Node head){
        if (head == null){
            return null;
        }
        //递归 leftEnd 和 rightEnd 分别为  左子树的头节点和右子树的头节点
        Node leftEnd = process(head.left);
        Node rightEnd = process(head.right);
        Node leftStart = leftEnd != null ? leftEnd.right : null;
        Node rightStart = rightEnd != null ? rightEnd.right : null;
        if(leftEnd != null && rightEnd != null){
            leftEnd.right = head;
            head.left = leftEnd;
            head.right = rightStart;
            rightStart.left = head;
            rightEnd.right = leftStart;
            return rightEnd;
        } else if (leftEnd != null){
            leftEnd.right = head;
            head.left = leftEnd;
            head.right = leftStart;
            return head;
        } else if (rightEnd != null){
            head.right = rightStart;
            rightStart.left = head;
            rightEnd.right = head;
            return rightEnd;
        } else {
            head.right = head;
            return head;
        }
    }

    /**
     * 输出二叉树
     * @param head
     */
    public static void printBSTInOrder (Node head) {
        System.out.print("BST in-order: ");
        if(head != null){
            inOrderPrint(head);
        }
        System.out.println();
    }

    /**
     * 二叉树中序遍历
     * @param head
     */
    public static void inOrderPrint(Node head){
        if(head == null){
            return;
        }
        inOrderPrint(head.left);
        System.out.print(head.value + " ");
        inOrderPrint(head.right);
    }

    public static void printDoubleLinkedList(Node head){
        System.out.print("Double Linked List: ");
        Node end = null;
        while (head != null){
            System.out.print(head.value + " ");
            end = head;
            head = head.right;
        }
        System.out.print(" | ");
        while (end != null){
            System.out.print(end.value + " ");
            end = end.left;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(2);
        head.right = new Node(9);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.left.right.right = new Node(4);
        head.right.left = new Node(7);
        head.right.right = new Node(10);
        head.left.left = new Node(1);
        head.right.left.left = new Node(6);
        head.right.left.right = new Node(8);

        printBSTInOrder(head);
        head = convert1(head);
        printDoubleLinkedList(head);

        head = new Node(5);
        head.left = new Node(2);
        head.right = new Node(9);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.left.right.right = new Node(4);
        head.right.left = new Node(7);
        head.right.right = new Node(10);
        head.left.left = new Node(1);
        head.right.left.left = new Node(6);
        head.right.left.right = new Node(8);

        printBSTInOrder(head);
        head = convert2(head);
        printDoubleLinkedList(head);
    }
}
