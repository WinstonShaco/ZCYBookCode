package chapter_2_listproblem.Problem_16_ListSelectionSort;

/**
 * @Author: 于新泽
 * @Date: Created in 2019/5/24 09:35
 * @site :单链表的选择排序（士★☆☆☆）79
 * @Description :
 */
public class ListSelectionSort02_16_02 {

    public static class Node {
        int value;
        Node next;

        public Node (int data) {
            this.value = data;
        }
    }


    public static Node selectionSort (Node head){

        Node tail = null;
        Node cur = head;
        Node smallPre = null;
        Node small = null;

        while (cur != null) {
            small = cur;
            smallPre = getSmallestPreNode (cur);
            if (smallPre != null) {

            }
        }
        return head;
    }

    public static Node getSmallestPreNode (Node head) {

        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;

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
     * 打印输出单向列表
     */
    public static void printLinkedList (Node head) {
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
