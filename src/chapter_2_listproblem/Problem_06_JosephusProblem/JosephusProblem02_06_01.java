package chapter_2_listproblem.Problem_06_JosephusProblem;

import chapter_2_listproblem.Problem_05_ReversepartList.reversePartList02_05_01;

/**
 * @Author: 于新泽
 * @Date: Created in 11:42 2018/1/26.
 * @site :
 * 环形单项链表的约瑟夫环问题（士★☆☆☆，校★★★☆）43
 */

public class JosephusProblem02_06_01 {

    public static class Node{
        int value;
        Node next;
        Node(int data){
            this.value = data;
        }
    }

    /**
     * 原问题
     * @param head ：环形单项链表
     * @param m ：第m个数出链
     * @return
     */
    public static Node josephusKill1(Node head,int m){
        if(head == null || head.next == head || m < 1){
            return head;
        }
        Node last = head;
        while(last.next != head){
            last = last.next;
        }
        int count = 0;
        while(head != last){
            if(++count == m){
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }

    public static void printCircularList(Node head){
        if(head == null){
            return ;
        }
        System.out.print("Circular List: " + head.value + " ");
        Node cur = head.next;
        while(cur != head){
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("-> " + head.value);
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
        n1.next.next.next.next.next.next.next.next.next.next.next = n1;
        printCircularList(n1);
        n1 = josephusKill1(n1,3);
        printCircularList(n1);
    }
}
