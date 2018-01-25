package chapter_1_stackAndQueue.Problem_01_GetMinStack;

import java.util.Stack;

/**
 * @Author: 于新泽
 * @Date: Created in 11:32 2018/1/25.
 * @site :
 * 设计一个有getMin 功能的栈（士★☆☆☆）1
 */

public class GetMinStack01_01_04 {
    public static class MyStack1 {

        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1(){
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int newNum){
            if(stackMin.empty()){
                stackMin.push(newNum);
            }else if(newNum < getMin()){
                stackMin.push(newNum);
            }
            stackData.push(newNum);
        }

        public int getMin(){
            if(stackMin.empty()){
                throw new RuntimeException("空的！！！！");
            }
            return stackMin.peek();
        }

        public int pop(){
            if(stackMin.empty()){
                throw new RuntimeException("空的！！！！");
            }
            int value = stackData.pop();
            if(value == getMin()){
                stackMin.pop();
            }
            return value;
        }
    }

    public static class MyStack2{

        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2(){
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int newNum){
            if(stackMin.empty()){
                stackMin.push(newNum);
            }else if(newNum < getMin()){
                stackMin.push(newNum);
            }else{
                int value = stackMin.peek();
                stackMin.push(value);
            }
            stackData.push(newNum);
        }

        public int pop(){
            if(stackMin.empty()){
                throw new RuntimeException("!!!!!不能为空!!!!!");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getMin(){
            if(stackMin.empty()){
                throw new RuntimeException("!!!!!不能为空!!!!!");
            }
            return stackMin.peek();
        }

    }
    public static void main(String[] args) {
        MyStack1 s1 = new MyStack1();
        //s1.push(1);
        // System.out.print(" " + s1.getMin());
        s1.push(8);
        System.out.print(" " + s1.getMin());
        s1.push(8);
        System.out.print(" " + s1.getMin());
        s1.push(4);
        System.out.print(" " + s1.getMin());
        s1.push(5);
        System.out.print(" " + s1.getMin());
        s1.push(7);
        System.out.print(" " + s1.getMin());
        s1.push(9);
        System.out.print(" " + s1.getMin());
        s1.push(2);
        System.out.print(" " + s1.getMin());
        s1.push(2);
        System.out.print(" " + s1.getMin());
        s1.push(1);
        System.out.print(" " + s1.getMin());
        s1.push(2);
        System.out.print(" " + s1.getMin());
        System.out.println(" " + s1.pop());
        System.out.println("#" + s1.getMin());

        System.out.println("-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-");

        MyStack2 s2 = new MyStack2();
        //s1.push(1);
        // System.out.print(" " + s2.getMin());
        s2.push(8);
        System.out.print(" " + s2.getMin());
        s2.push(8);
        System.out.print(" " + s2.getMin());
        s2.push(4);
        System.out.print(" " + s2.getMin());
        s2.push(5);
        System.out.print(" " + s2.getMin());
        s2.push(7);
        System.out.print(" " + s2.getMin());
        s2.push(9);
        System.out.print(" " + s2.getMin());
        s2.push(2);
        System.out.print(" " + s2.getMin());
        s2.push(2);
        System.out.print(" " + s2.getMin());
        s2.push(1);
        System.out.print(" " + s2.getMin());
        s2.push(2);
        System.out.print(" " + s2.getMin());
        System.out.println(" " + s2.pop());
        System.out.println("#" + s2.getMin());
    }
}
