package chapter_2_listproblem.Problem_08_SmallerEqualBigger;

/**
 * @Author: 于新泽
 * @Date: Created in 15:21 2018/1/31.
 * @site :
 */

public class SmallerEqualBigger02_08_02 {

    public static class Node{
        int value;
        Node next;
        Node(int data){
            this.value = data;
        }
    }

    public static void swap(Node[] nodeArr,int a ,int b){
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    public static void arrPartition(Node [] nodeArr,int pivot){
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while(index != big){
            if(nodeArr[index].value < pivot){
                swap(nodeArr,++small ,index++);
            }else if(nodeArr[index].value > pivot){
                swap(nodeArr,--big,index);
            }else{
                index++;
            }
        }
    }

    public static Node listPartition1(Node head,int pivot){
        if(head == null){
            return head;
        }
        Node cur = head;
        int i = 0;
        while(cur != null){
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for(i = 0 ;i != nodeArr.length;i++){
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr,pivot);
        for(i = 1;i != nodeArr.length;i++){
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public static Node listPartition2(Node head,int pivot){
        Node sH = null;//small head
        Node sT = null;//small tail
        Node eH = null;//equal head
        Node eT = null;//equal tail
        Node bH = null;//big head
        Node bT = null;//big tail
        Node next = null; //save next node
        while(head != null){
            next = head.next;
            head.next = null;
            if(head.value < pivot){
                if(sH == null){
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
                    eT = next;
                }
            }else{
                if(bH == null){
                    bH = head;
                    bT = head;
                }else{
                    bH.next = null;
                    bH = null;
                }
            }
            head = next;
        }
        if(sT != null){
            sT.next = eH;
            sT = eT == null ? sT : eT;
        }
        if(eT != null){
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }

    public static void printLinkedList(Node node){
        System.out.println("Linked List: ");
        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node n1 = new Node(7);
        n1.next = new Node(9);
        n1.next.next = new Node(1);
        n1.next.next.next = new Node(8);
        n1.next.next.next.next = new Node(5);
        n1.next.next.next.next.next = new Node(2);
        n1.next.next.next.next.next.next = new Node(5);
        printLinkedList(n1);
        n1 = listPartition1(n1,4);
        printLinkedList(n1);
    }
}
