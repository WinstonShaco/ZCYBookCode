package chapter_2_listproblem.Problem_03_RemoveNodeByRatio;

/**
 * @Author: 于新泽
 * @Date: Created in 15:53 2018/1/22.
 * @site :
 * 删除链表的中间节点和a/b处的节点（士★☆☆☆）38
 */

public class RemoveNodeByRatio02_03_01 {

    public static class Node{
        int value;
        Node next;
        Node(int data){
            this.value = data;
        }
    }

    public static Node removeMidNode(Node head){
        if(head == null || head.next == null){
            return head;
        }
        if(head.next.next == null){
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while(cur.next != null && cur.next.next != null){
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static Node removeByratio(Node head,int a,int b){
        if(a < 1 || a > b){
            return head;
        }
        int n = 0;
        Node cur = head;
        while(cur != null){
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil(((double) (a * n)) / (double) b);
        if (n == 1){
            head = head.next;
        }
        if (n > 1){
           cur = head;
            while (--n != 1){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void printLinkedList(Node head){
        System.out.println("List list: ");
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
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

        printLinkedList(n1);
        n1 = removeMidNode(n1);
        printLinkedList(n1);
        n1 = removeByratio(n1,2,5);
        printLinkedList(n1);
        n1 = removeByratio(n1,1,3);
        printLinkedList(n1);
    }
}
