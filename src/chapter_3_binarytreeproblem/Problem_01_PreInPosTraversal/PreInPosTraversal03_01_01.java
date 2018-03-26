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
                System.out.print(head.value + " ");
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

    /**
     * 后序遍历（用两个栈）
     * 1.先申请一个栈，记为s1，然后将头结点head压入s1中。
     * 2.从s1中弹出的结点记为cur，然后依次将cur的左孩子和右孩子压入s1中
     * 3.在整个过程中，每个从s1中弹出的结点都放进s2中。
     * 4.不断重复步骤2和步骤3，直到s1为空，过程停止。
     * 从s2中依次弹出结点并打印，打印的顺序就是后序遍历的顺序。
     * @param head
     */
    public static void posOrderUnRecur1(Node head){
        System.out.print("pos-order: ");
        if(head != null){
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while(!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if(head.left != null){
                    s1.push(head.left);
                }
                if(head.right != null){
                    s1.push(head.right);
                }
            }
            while(!s2.isEmpty()){
                System.out.print(s2.pop().value + " ");
            }
        }
        System.out.println();
    }


    /**
     * 后序遍历（用一个栈）
     * 1.申请一个栈，记为一个stack，将头节点压入stack，同时设置两个变量h和c。在整个流程中，h代表最近一次弹出并打印的结点，
     * c代表stack的栈顶结点，初始值h为头结点，c为null。
     * 2.每次令c等于当前stack的栈顶结点，但是不从stack中弹出，此时分为以下三种情况
     * ①如果c的左孩子不为null，并且h不等于c的左孩子，也不等于c的右孩子，则把c的左孩子压入stack中。具体解释一下这么做的原
     * 因，首先h的意义是最近一次弹出并打印的结点，所以如果h等于c等于左孩子或者右孩子，说明c的左子树与右子树已经打印完毕，
     * 此时不应该再将c的左孩子放入stack中。否则，说明左子树还没有处理过，那么此时c的左孩子压入stack中。
     * ②如果条件①不成立，并且c的右孩子不为null，h不等于c的右孩子，则把c的右孩子压入stack中。含义是如果h等于c的右孩子
     * 说明c的右子树已经打印完毕，此时不应该再将c的右孩子放入stack中，否则，说明右子树还没有处理过，此时将c的右孩子压入
     * stack中。
     * ③如果条件①和条件②都不成立，说明c的左子树和右子树都已经打印完毕，那么从stack中弹出c并打印，然后令h=c
     * 3.一直重复步骤2，直到stack为空，过程停止。
     * @param h
     */
    public static void posOrderUnRecur2(Node h){
        System.out.print("pos-order: ");
        if(h != null){
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node c = null;
            while(!stack.isEmpty()){
                c = stack.peek();
                if(c.left != null && h != c.left && h != c.right){
                    stack.push(c.left);
                } else if (c.right != null && h != c.right){
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();
        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
        posOrderUnRecur2(head);
    }
}
