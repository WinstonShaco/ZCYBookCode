package chapter_2_listproblem.Problem_16_ListSelectionSort;

import javax.xml.stream.FactoryConfigurationError;
import java.util.SortedMap;

/**
 * @Author: 于新泽
 * @Date: Created in 2019/5/23 10:32
 * @site : 单链表的选择排序（士★☆☆☆）79
 * @Description :
 */
public class ListSelectionSort02_16_01 {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data){
            this.value = data;
        }
    }

    /**
     * 排序
     * @param head ：链表头节点
     * @return ：输出链表
     */
    public static Node selectionSort(Node head){
        Node tail = null; // 排序部分的尾部
        Node cur = head; // 未排序部分的头部
        Node smallPre = null; // 最小节点的前序节点
        Node small = null; // 最小的节点

        // 每次把最小的值放到最后
        while(cur != null) {
            small = cur;
            smallPre = getSmallestPreNode(cur);
            if (smallPre != null){
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (tail == null) {
                head = small;
            } else {
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }

    /**
     *  获得最小节点的前序节点
     * @param head ：链表首节点
     * @return ： 前序节点
     */
    public static Node getSmallestPreNode (Node head){
        Node smallPre = null;
        Node small = head;
        // pre 和 cur 可视为绑定在一起
        Node pre = head;
        Node cur = head.next;
        // 找到最小的节点值
        while (cur != null) {
            if (cur.value < small.value) {
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }

    /**
     *  输出
     * @param head
     */
    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        System.out.print("第一组链表是： ");
        printLinkedList(head);
        head = selectionSort(head);
        System.out.print("第一组链表排序后： ");
        printLinkedList(head);

        head = new Node(1);
        System.out.print("第二组链表是： ");
        printLinkedList(head);
        head = selectionSort(head);
        System.out.print("第二组链表排序后： ");
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        System.out.print("第三组链表是： ");
        printLinkedList(head);
        head = selectionSort(head);
        System.out.print("第三组链表排序后： ");
        printLinkedList(head);

        head = new Node(2);
        head.next = new Node(1);
        System.out.print("第四组链表是： ");
        printLinkedList(head);
        head = selectionSort(head);
        System.out.print("第四组链表排序后： ");
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        System.out.print("第五组链表是： ");
        printLinkedList(head);
        head = selectionSort(head);
        System.out.print("第五组链表排序后： ");
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        System.out.print("第六组链表是： ");
        printLinkedList(head);
        head = selectionSort(head);
        System.out.print("第六组链表排序后： ");
        printLinkedList(head);

        head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(3);
        System.out.print("第七组链表是： ");
        printLinkedList(head);
        head = selectionSort(head);
        System.out.print("第七组链表排序后： ");
        printLinkedList(head);

        head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(1);
        System.out.print("第八组链表是： ");
        printLinkedList(head);
        head = selectionSort(head);
        System.out.print("第八组链表排序后： ");
        printLinkedList(head);

        head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(2);
        System.out.print("第九组链表是： ");
        printLinkedList(head);
        head = selectionSort(head);
        System.out.print("第九组链表排序后： ");
        printLinkedList(head);

        head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(1);
        System.out.print("第十组链表是： ");
        printLinkedList(head);
        head = selectionSort(head);
        System.out.print("第十组链表排序后： ");
        printLinkedList(head);

        head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(4);
        head.next.next.next = new Node(2);
        System.out.print("第十一组链表是： ");
        printLinkedList(head);
        head = selectionSort(head);
        System.out.print("第十一组链表排序后： ");
        printLinkedList(head);
    }
}
