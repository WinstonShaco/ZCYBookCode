package chapter_2_listproblem.Problem_07_IsPalindromeList;

import java.util.Stack;

/**
 * @Author: 于新泽
 * @Date: Created in 17:25 2018/1/26.
 * @site :
 * 判断一个链表是否为回文结构 48
 * 普通解法（士★☆☆☆）
 * 进阶解法（尉★★☆☆）
 */

public class IsPalindromeList02_07_01 {
    public static class Node{
        int value;
        Node next;
        Node(int data){
            this.value = data;
        }
    }

    public static boolean isPalindrome1(Node head){
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(head != null){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while(cur.next != null && cur.next.next != null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while(right != null){
            stack.push(right);
            right = right.next;
        }
        while(!stack.isEmpty()){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome3(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while(n2.next != null && n2.next.next == null){
            n1 = n1.next;//-> 中部
            n2 = n2.next.next;// -> 结尾
        }
        n2 = n1.next;// n2 -> 右部分第一个节点
        n1.next = null;
        Node n3 = null;
        while(n2 != null){
            n3 = n2.next;//n3 -> 保存下一个节点
            n2.next = n1;//下一个反转节点
            n1 = n2;//n1 移动
            n2 = n3;//n2 移动
        }
        n3 = n1;
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null){
            if(n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3 = n1.next;
        while (n1 != null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static void printLinkedList(Node head){
        System.out.println("Linked List; ");
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node n1 = null;
        printLinkedList(n1);
        System.out.print("方式一： " + isPalindrome1(n1) + "|");
        System.out.println("方式二： " + isPalindrome2(n1) + "|");
        System.out.println("=======================");
        n1 = new Node(1);
        printLinkedList(n1);
        System.out.print("方式一： " + isPalindrome1(n1) + "|");
        System.out.println("方式二： " + isPalindrome2(n1) + "|");
        System.out.println("=======================");
        n1 = new Node(1);
        n1.next = new Node(2);
        printLinkedList(n1);
        System.out.print("方式一： " + isPalindrome1(n1) + "|");
        System.out.println("方式二： " + isPalindrome2(n1) + "|");
        System.out.println("=======================");
        n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(2);
        printLinkedList(n1);
        System.out.print("方式一： " + isPalindrome1(n1) + "|");
        System.out.println("方式二： " + isPalindrome2(n1) + "|");
        System.out.println("=======================");
        n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(2);
        n1.next.next.next.next = new Node(1);
        printLinkedList(n1);
        System.out.print("方式一： " + isPalindrome1(n1) + "|");
        System.out.println("方式二： " + isPalindrome2(n1) + "|");
        System.out.println("=======================");
    }
}
