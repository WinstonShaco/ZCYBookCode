package chapter_2_listproblem.Problem_03_RemoveNodeByRatio;

/**
 * @Author: 于新泽
 * @Date: Created in 16:28 2018/1/25.
 * @site :
 * 删除链表的中间节点和a/b处的节点（士★☆☆☆）38
 */

public class RemoveNodeByRatio02_03_02 {

    public static class Node{
        int value;
        Node next;
        Node(int data){
            this.value = data;
        }
    }

    /**
     * 移除中间节点
     * @param head
     * @return
     */
    public static Node removeMidNode(Node head){
        if(head == null || head.next == null){
            return head;
        }
        if(head.next.next == null){
            return head.next;
        }
        Node cur = head;
        Node qui = head.next.next;
        while(cur.next != null && qui.next.next != null){
            cur = cur.next;
            qui = qui.next.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    /**
     * 移除a/b处节点
     * @param head
     * @return
     */
    public static Node removeByRatio(Node head,int a,int b){
        if(a < 1 || a > b){
            return head;
        }
        int n = 0;
        Node cur = head;
        while(cur != null){
            n++;
            cur = cur.next;
        }
        n = (int)Math.ceil(((double)(a * n)) / (double) b);
        if(n == 1){
            head = head.next;
        }
        if( n > 1){
            cur = head;
            while (--n != 1){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void printList(Node head){
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        printList(head);
        head = removeMidNode(head);
        printList(head);
        head = removeByRatio(head, 2, 5);
        printList(head);
        head = removeByRatio(head, 1, 3);
        printList(head);
    }
}
