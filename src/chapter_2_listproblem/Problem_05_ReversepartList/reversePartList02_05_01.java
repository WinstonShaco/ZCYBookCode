package chapter_2_listproblem.Problem_05_ReversepartList;

/**
 * @Author: 于新泽
 * @Date: Created in 10:04 2018/1/26.
 * @site :
 * 反转部分单项链表（士★☆☆☆）42
 */

public class reversePartList02_05_01 {

    public static class Node{
        int value;
        Node next;
        Node(int data){
            this.value = data;
        }
    }

    public static Node reversePart(Node head,int from,int to){
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        //首先找到反转部分的始末结点
        while(node1 != null){
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }

        if(from > to || from < 1 || to > len){
            return head;
        }

        //node1 直接赋值成要反转的开始结点
        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;
        //需要翻转的部分
        while(node2 != tPos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        /**下面的if 和 return 返回头结点
         * 如果fPro 为 null 说明翻转部分包含头结点 返回新的头结点
         * 如果fPro 不为 null 说明翻转部分不包含头结点 返回旧的头结点
         */

        if(fPre != null){
            fPre.next = node1;
            return head;
        }
        return node1;
    }

    public static void printList(Node head){
        System.out.println("Lisked List: ");
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node n1 = null;
        printList(n1);
        n1 = reversePart(n1,1,1);
        printList(n1);
        System.out.println("%%%%%%%%%%%%%");

        n1 = new Node(1);
        printList(n1);
        n1 = reversePart(n1,1,1);
        printList(n1);
        System.out.println("*************");

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
        printList(n1);
        n1 = reversePart(n1,3,9);
        printList(n1);
    }
}
