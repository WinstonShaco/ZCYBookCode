package chapter_2_listproblem.Problem_02_RemoveLastKthNode;

/**
 * @Author: 于新泽
 * @Date: Created in 18:10 2018/3/8.
 * @site :
 * 给出两个相同长度的由字符 a 和 b 构成的字符串，定义它们的距离为对应位置不同的字符的数量。如串”aab”与串”aba”的距离为 2；串”ba”与串”aa”的距离为 1；串”baa”和串”baa”的距离为 0。下面给出两个字符串 S 与 T，其中 S 的长度不小于 T 的长度。我们用|S|代表 S 的长度，|T|代表 T 的长度，那么在 S 中一共有|S|-|T|+1 个与 T 长度相同的子串，现在你需要计算 T 串与这些|S|-|T|+1 个子串的距离的和。
 *
 */

public class RemoveLastKthNode02_02_03 {
    public static class Node {
        int value;
        Node next;
        Node (int data){
            this.value = data;
        }
    }

    public static Node removeLastKthNode(Node head,int k){
        if(head == null || k < 1){
            return head;
        }
        Node cur = head;
        while(cur != null){
            k--;
            cur = cur.next;
        }
        if(k == 0){
            head = head.next;
        }
        if(k < 0){
            cur = head;
            while(++k != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static class DoubleNode {
        int value ;
        DoubleNode last;
        DoubleNode next;
        DoubleNode(int data){
            this.value = data;
        }
    }

    public static DoubleNode removeLastKthNode(DoubleNode head,int k){
        if(head == null || k < 1){
            return head;
        }
        DoubleNode cur = head;
        while(cur != null){
            k--;
            cur = cur.next;
        }
        if(k == 0){
            head = head.next;
            head.last = null;
        }
        if(k < 0){
            cur = head;
            while(++k != 0){
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if(newNext != null){
                newNext.last = cur;
            }
        }
        return head;
    }

    public static void printLinkedList(Node head){
        System.out.print("Linked List: ");
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleLinkedList(DoubleNode head){
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while(head != null){
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("|");
        while(end != null){
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        printLinkedList(head1);
        head1 = removeLastKthNode(head1, 3);
        // head1 = removeLastKthNode(head1, 6);
        // head1 = removeLastKthNode(head1, 7);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        head2.next.next.next.next = new DoubleNode(5);
        head2.next.next.next.next.last = head2.next.next.next;
        head2.next.next.next.next.next = new DoubleNode(6);
        head2.next.next.next.next.next.last = head2.next.next.next.next;
        printDoubleLinkedList(head2);
        head2 = removeLastKthNode(head2, 3);
        // head2 = removeLastKthNode(head2, 6);
        // head2 = removeLastKthNode(head2, 7);
        printDoubleLinkedList(head2);

    }
}
