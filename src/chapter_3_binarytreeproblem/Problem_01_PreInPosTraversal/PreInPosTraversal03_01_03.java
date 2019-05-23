package chapter_3_binarytreeproblem.Problem_01_PreInPosTraversal;

/**
 * @Author: 于新泽
 * @Date: Created in 2019/4/11 09:49
 * @site :分别用递归和非递归方法实现二叉树先序、中序和后序遍历 校（★★★☆）
 * @Description :
 */
public class PreInPosTraversal03_01_03 {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node (int data){
            this.value = data;
        }
    }

    /**
     * 递归方法实现前序遍历
     * @param head ：节点
     */
    public static void preOrderRecur(Node head){

        if (head == null){
            return;
        }
        System.out.println( head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 递归方法实现中序遍历
     * @param head ：节点
     */
    public static void inOrderRecur(Node head){

        if (head == null){
            return;
        }
        inOrderRecur(head.left);
        inOrderRecur(head.right);
        System.out.println( head.value + " ");
    }

    /**
     * 递归方法实现后序遍历
     * @param head ：节点
     */
    public static void posOrderRecur(Node head){

        if (head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println( head.value + " ");
    }

    
}
