package chapter_2_listproblem.Problem_13_RemoveRepetition;

import java.util.HashSet;

/**
 * @Author: 于新泽
 * @Date: Created in 2018/9/20 11:36
 * @site :
 * @Description :
 * 删除无序单链表中值重复出现的节点（士★☆☆☆）71
 */
public class RemoveRepetition02_13_01 {

    public static class Node{
        int value;
        Node next;

        Node(int data){
            this.value = data;
        }
    }

    /**
     * 利用哈希表。时间复杂度O（N）,额外空间复杂度O（N）
     * @param head ：节点
     */
    public static void removeRep1(Node head){
        if(head == null){
            return;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        Node pre = head;
        Node cur = head.next;
        set.add(head.value);
        while (cur != null) {
            if(set.contains(cur.value)){
                pre.next = cur.next;
            } else {
                set.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
    }

    /**
     * 类似于排序过程，时间复杂度O（n²），空间复杂度O（1）
     * @param head ： 节点
     */
    public static void removeRep2(Node head) {
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null ){
            pre = cur;
            next = cur.next;
            while(next != null){
                if(cur.value == next.value){
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }

    /**
     *
     * @param head
     */
    public static void printLinkedList(Node head){
        System.out.println("Linked List: ");
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println("######## The end ########");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next = new Node(1);
        removeRep1(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next = new Node(1);
        removeRep2(head);
        printLinkedList(head);
    }
}
