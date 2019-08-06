package chapter_3_binarytreeproblem.Problem_02_PrintEdgeNodes;

import sun.net.www.protocol.http.HttpURLConnection;
import sun.plugin2.message.GetAppletMessage;

/**
 * @Author: 于新泽
 * @Date: Created in 2019/8/6 14:43
 * @site : 打印二叉树的边界节点 尉（★★☆☆）
 * @Description :
 */
public class PrintEdgeNodes03_02_01 {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static void printEdge1(Node head){
        if(head == null){
            return;
        }
        int height = getHeight(head,0);
        Node[][] edgeMap = new Node[height][2];
        setEdgeMap(head,0,edgeMap);
        for (int i = 0 ; i != edgeMap.length ; i++){
            System.out.print(edgeMap[i][0].value + " ");
        }
        printLeafNotInMap(head,0,edgeMap);
        for (int i = edgeMap.length - 1; i != -1 ; i--){
            if(edgeMap[i][0] != edgeMap[i][1]){
                System.out.print(edgeMap[i][1].value + " ");
            }
        }
        System.out.println();
    }

    /**
     * 获取整棵树的高度，利用递归，遍历出本树的高度
     * @param h : 节点
     * @param l : 高度
     * @return : 返回树的高度
     */
    public static int getHeight(Node h ,int l){
        if(h == null){
            return l;
        }
        return Math.max(getHeight(h.left, l + 1) ,getHeight(h.right, l + 1));
    }

    /**
     * 往一个二维数组中写入节点内记录的数据，二维数组中的第一列记录本行
     * 中最左边的数据，第二列记录该行中最右侧数据。
     * 由于本方法是递归的方式先左后右遍历整棵树
     * edgeMap[l][0] = edgeMap[l][0] == null ? h : edgeMap[l][0];
     * 保证每次记录的都是最开始记录的数据，即本行中的最左边的数据，
     * edgeMap[l][1] = h;
     * 保证每次记录的都是最后一次遍历到的数据，即本行中的最右边的数据
     * @param h : 当前遍历到树的节点
     * @param l : 当前所在树的高度
     * @param edgeMap : 二维数组
     */
    public static void setEdgeMap (Node h,int l,Node[][] edgeMap){
        if(h == null){
            return;
        }
        edgeMap[l][0] = edgeMap[l][0] == null ? h : edgeMap[l][0];
        edgeMap[l][1] = h;
        setEdgeMap(h.left,l + 1,edgeMap);
        setEdgeMap(h.right,l + 1,edgeMap);
    }

    /**
     * 找到既不是左边界又不是右边界的叶子节点，并输出该节点的值
     * @param h : 当前遍历到树的节点
     * @param l : 当前所在树的高度
     * @param m : 二维数组
     */
    public static void printLeafNotInMap(Node h ,int l,Node[][] m){
        if (h == null) {
            return;
        }
        if(h.left == null && h.right == null && h != m[l][0] && h != m[l][1]){
            System.out.print(h.value + " ");
        }
        printLeafNotInMap(h.left, l + 1,m);
        printLeafNotInMap(h.right, l + 1,m);
    }

    /**
     * 延伸路径为棒状结构，如下所示
     *         1
     *      /   \
     *     2    null
     *   /  \
     * null  3
     * 或
     *         1
     *       /  \
     *     null  2
     *          /  \
     *         3   null
     * @param head
     */
    public static void printEdge2(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.value + " ");
        if(head.left != null && head.right != null){
            printLeftEdge(head.left,true);
            printRightEdge(head.right,true);
        } else {
            printEdge2(head.left != null ? head.left : head.right);
        }
        System.out.println();
    }

    /**
     * 左子树
     * 先输出本节点的值，如果没有左子节点下次 print 赋值 false
     * @param h : 节点
     * @param print : 标记符号。
     */
    public static void printLeftEdge(Node h, boolean print){
        if(h == null){
            return;
        }
        if(print || (h.left == null  && h.right == null)){
            System.out.print(h.value + " ");
        }
        printLeftEdge(h.left, print);
        printLeftEdge(h.right, print && h.left == null ? true : false);
    }

    /**
     * 右子树
     * 如果没有右子节点下次 print 赋值 false
     * @param h : 节点
     * @param print : 标记符号。
     */
    public static void printRightEdge(Node h, boolean print){
        if(h == null){
            return;
        }
        printRightEdge(h.left, print && h.right == null ? true : false);
        printRightEdge(h.right, print );
        if(print || (h.left == null  && h.right == null)){
            System.out.print(h.value + " ");
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.right = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.right.left = new Node(7);
        head.left.right.right = new Node(8);
        head.right.left.left = new Node(9);
        head.right.left.right = new Node(10);
        head.left.right.right.right = new Node(11);
        head.right.left.left.left = new Node(12);
        head.left.right.right.right.left = new Node(13);
        head.left.right.right.right.right = new Node(14);
        head.right.left.left.left.left = new Node(15);
        head.right.left.left.left.right = new Node(16);

        printEdge1(head);
        printEdge2(head);
    }
}
