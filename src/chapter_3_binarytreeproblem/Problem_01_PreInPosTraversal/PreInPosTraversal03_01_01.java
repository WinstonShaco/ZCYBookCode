package chapter_3_binarytreeproblem.Problem_01_PreInPosTraversal;

import java.util.Stack;

/**
 * @Author: 于新泽
 * @Date: Created in 23:43 2018/3/23.
 * @site :
 * 分别用递归和非递归方法实现二叉树先序、中序和后序遍历 校（★★★☆）
 */

public class PreInPosTraversal03_01_01 {

    public static class Node{
        int value;
        Node left;
        Node right;
        Node(int data){
            this.value = data;
        }
    }

    /**
     * 下面是递归方法实现，比较简单。
     * @param head
     */
    //前序  递归方法
    public static void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //中序 递归方法
    public static void inOrderRecur(Node head){
        if(head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value + " ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(Node head){
        if(head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value + " ");
    }

    /**
     * 以下是非递归方法实现
     */
    /**
     * 先序遍历：
     * 1.先申请一个新的栈，记为stack,然后将头结点压入stack中
     * 2.从stack中弹出栈顶结点，记为cur,然后打印cur节点的值，在压入右孩子，最后将左孩子压入stack中
     * 3.不断重复2步骤，直到全部。
     * @param head
     */
    public static void preOrderUnRecur(Node head){
        System.out.print("pre-order: ");
        if(head != null){
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value);
                if(head.right != null)
                    stack.push(head.right);
                if(head.left != null)
                    stack.push(head.left);
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历：
     * 1.先申请一个新的栈，记为stack,初始时cur = head
     * 2.先把cur结点压入栈中，对以cur结点为头的整棵子树来说，依次把左边界压入栈中，即不停地令cur = cur.left 然后重复步骤2
     * 3.不断重复2步骤，直到发现cur为空（没有左节点了），此时从stack中弹出一个结点，记为Node，打印Node的值，并且让cur = node。right，然后重复步骤2.
     * 4.当stack为空且cur为空的时候，停止整个过程
     * @param head
     */
    public static void inOrderUnRecur(Node head){
        System.out.print("in-order: ");
        if(head != null){
            Stack<Node> stack = new Stack<Node>();
            while(!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }


}
