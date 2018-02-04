package chapter_2_listproblem.Problem_09_CopyListWithRandom;

import java.util.HashMap;

/**
 * @Author: 于新泽
 * @Date: Created in 0:48 2018/2/5.
 * @site :
 * 复制含有随机指针节点的链表（尉★★☆☆）56
 */

public class CopyListWithRandom02_09_01 {

    public static class Node{
        int value;
        Node next;
        Node rand;
        Node(int data){
            this.value = data;
        }
    }

    public static Node copyListWithRand1(Node head){
        HashMap<Node,Node> map = new HashMap<Node,Node>();
        Node cur = head;
        //把链表复制一遍
        while(cur != null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        cur = head;
        return map.get(head);
    }

    public static void printRandLinkList(Node head){
        Node cur = head;
        System.out.print("order: ");
        while(cur != null){
            System.out.print(cur.value+ " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand : ");
        while (cur != null){
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node h = null;
        Node r1 = null;


        h = new Node(1);
        h.next = new Node(2);
        h.next.next = new Node(3);
        h.next.next.next = new Node(4);
        h.next.next.next.next = new Node(5);
        h.next.next.next.next.next = new Node(6);

        h.rand = h.next.next.next.next.next; // 1 -> 6
        h.next.rand = h.next.next.next.next.next; // 2 -> 6
        h.next.next.rand = h.next.next.next.next; // 3 -> 5
        h.next.next.next.rand = h.next.next; // 4 -> 3
        h.next.next.next.next.rand = null; // 5 -> null
        h.next.next.next.next.next.rand = h.next.next.next; // 6 -> 4

        printRandLinkList(h);
        r1 = copyListWithRand1(h);
        printRandLinkList(r1);
        System.out.println("+++++++++++++");
    }
}
