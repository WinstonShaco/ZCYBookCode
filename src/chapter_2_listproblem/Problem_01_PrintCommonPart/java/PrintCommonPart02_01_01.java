package chapter_2_listproblem.Problem_01_PrintCommonPart.java;

/**
 * @Author: 于新泽
 * @Date: Created in 11:27 2018/1/22.
 * @site :
 * ###是有序链表###
 * 打印两个有序链表的公共部分（士★☆☆☆）34
 */

public class PrintCommonPart02_01_01 {

    public static class Node{
        int value;
        Node next;
        Node(int data){
            this.value = data;
        }
    }

    public static void printCommonPart(Node head1,Node head2){
        System.out.print("Common Part: ");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.print(head1.value + "-> ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();

    }
    public static void printLinkedList(Node node){
        System.out.println("Linked List: ");
        while(node != null){
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node n1 = new Node(1001);
        n1.next = new Node(1008);
        n1.next.next = new Node(1008);
        n1.next.next.next = new Node(2004);
        n1.next.next.next.next = new Node(2005);
        n1.next.next.next.next.next = new Node(2007);
        n1.next.next.next.next.next.next = new Node(2009);
        n1.next.next.next.next.next.next.next = new Node(3002);
        n1.next.next.next.next.next.next.next.next = new Node(3002);
        n1.next.next.next.next.next.next.next.next.next = new Node(4001);
        n1.next.next.next.next.next.next.next.next.next.next = new Node(4002);
        System.out.println("#################################");
        Node n2 = new Node(1001);
        n2.next = new Node(1003);
        n2.next.next = new Node(1008);
        n2.next.next.next = new Node(2004);
        n2.next.next.next.next = new Node(2005);
        n2.next.next.next.next.next = new Node(2008);
        n2.next.next.next.next.next.next = new Node(2008);
        n2.next.next.next.next.next.next.next = new Node(2009);
        n2.next.next.next.next.next.next.next.next = new Node(3006);
        n2.next.next.next.next.next.next.next.next.next = new Node(4001);
        n2.next.next.next.next.next.next.next.next.next.next = new Node(4008);

        printLinkedList(n1);
        printLinkedList(n2);
        printCommonPart(n1,n2);
    }
}
