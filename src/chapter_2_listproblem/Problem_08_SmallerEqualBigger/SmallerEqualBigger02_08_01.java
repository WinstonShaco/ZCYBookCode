package chapter_2_listproblem.Problem_08_SmallerEqualBigger;

/**
 * @Author: 于新泽
 * @Date: Created in 14:57 2018/1/31.
 * @site :
 * 将单项链表按某值划分左边小，中间相等，右边大的形式（尉★★☆☆）52
 */

public class SmallerEqualBigger02_08_01 {

    public static class Node {
        int value;
        Node next;
        Node(int data){
            this.value = data;
        }
    }

    public static Node litPartition1(Node head, int pivot){
        if(head == null ){
            return head;
        }
        Node cur = head;
        int i = 0;
        //首先记录下整个链表的长度
        while(cur != null){
            i++;
            cur = cur.next;
        }
        Node [] nodeArr = new Node[i];
        i = 0;
        cur = head;
        //将整个链表依次放入数组中
        for(i = 0 ;i != nodeArr.length ; i++){
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr,pivot);
        //将整个链表连接起来
        for(i = 1;i != nodeArr.length ;i++){
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr,int pivot){
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while(index != big){
            if(nodeArr[index].value < pivot){
                swap(nodeArr,++small,index++);
            }else if (nodeArr[index].value > pivot){
                swap(nodeArr,--index,index);
            }else{
                index++;
            }
        }
    }

    public static void swap(Node[] nodeArr,int a ,int b){
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    public static Node listPartition2(Node head,int pivot){
        Node sH = null;//小的头
        Node sT = null;//小的尾
        Node eH = null;//相等的头
        Node eT = null;//相等的尾
        Node bH = null;//大的头
        Node bT = null;//大的尾
        Node next = null;//保存下一个节点
        while(head != null){
            next = head.next;
            head.next = null;
            if(head.value < pivot){
                if (sH == null){
                    sH = head;
                    sT = head;
                }else{
                    sT.next = head;
                    sT = head;
                }
            }else if(head.value == pivot){
                if(eH == null){
                    eH = head;
                    eT = head;
                }else{
                    eT.next = head;
                    eT = head;
                }
            }else {
                if(bH == null){
                    bH = head;
                    bT = head;
                }else{
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        if(sT != null){
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if(eT != null){
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }

    public static void printLinkedList(Node node){
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);
    }
}
