package chapter_2_listproblem.Problem_06_JosephusProblem;

/**
 * @Author: 于新泽
 * @Date: Created in 16:38 2018/1/26.
 * @site :
 * 环形单项链表的约瑟夫环问题（士★☆☆☆，校★★★☆）43
 */

public class JosephusProblem02_06_02 {

    public static class Node{
        int value;
        Node next;
        Node(int data){
            this.value = data;
        }
    }

    public static Node josephusKill1(Node head , int m){
        if(head == null || head.next == null || m < 1){
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

    public static Node josephusKill2(Node head, int m){
        if(head == null || head.next == null || m < 1){
            return head;
        }
        Node cur = head.next;
        int tmp = 1;
        while(cur != head){
            tmp++;
            cur = cur.next;
        }
        tmp = getLive(tmp ,m);
        while (--tmp != 0){
            head = head.next;
        }
        head.next = head;
        return head;
    }

    public static int getLive(int i ,int  m){
        if(i == 1){
            return 1;
        }
        return (getLive(i - 1,m) + m - 1) % i + 1;
    }

    public static void printCricularList(Node head){
        if(head == null){
            return;
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
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);
        n1.next.next.next.next = new Node(5);
        n1.next.next.next.next.next = new Node(6);
        n1.next.next.next.next.next.next = new Node(7);
        n1.next.next.next.next.next.next.next = new Node(8);
        n1.next.next.next.next.next.next.next.next = new Node(9);
        n1.next.next.next.next.next.next.next.next.next = new Node(10);
        n1.next.next.next.next.next.next.next.next.next.next = new Node(11);
        n1.next.next.next.next.next.next.next.next.next.next.next = new Node(12);
        n1.next.next.next.next.next.next.next.next.next.next.next.next = new Node(13);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(14);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(15);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(16);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(17);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(18);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(19);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(20);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(21);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(22);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(23);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(24);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(25);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(26);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(27);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(28);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(29);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(30);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(31);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(32);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(33);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next  = new Node(34);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next  = new Node(35);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next  = new Node(36);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next   = new Node(37);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next  = new Node(38);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next  = new Node(39);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(40);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(41);
        n1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = n1;





        printCricularList(n1);
        n1 = josephusKill1(n1,3);
        printCricularList(n1);

//        printCricularList(n1);
//        n1 = josephuskill2(n1,3);
//        printCricularList(n1);
    }
}
