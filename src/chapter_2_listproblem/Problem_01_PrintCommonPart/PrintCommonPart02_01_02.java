package chapter_2_listproblem.Problem_01_PrintCommonPart;

import chapter_2_listproblem.Problem_03_RemoveNodeByRatio.RemoveNodeByRatio02_03_01;

/**
 * @Author: 于新泽
 * @Date: Created in 16:29 2018/1/22.
 * @site :
 * 打印两个有序链表的公共部分（士★☆☆☆）34
 */

public class PrintCommonPart02_01_02 {

    public static class Node{
        int value;
        Node next;
        Node(int data){
            this.value = data;
        }
    }

    public static void printCommonPart(Node head1,Node head2){
        System.out.print("Common Part: ");
        while(head1 != null && head2 != null){
            if(head1.value < head2.value){
                head1 = head1.next;
            }else if(head1.value > head2.value){
                head2 = head2.next;
            }else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

    public static void printLinkedList(Node node){
        System.out.println("Lisked list: ");
        while(node != null){
            System.out.println(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        printCommonPart(node1, node2);

    }
}
