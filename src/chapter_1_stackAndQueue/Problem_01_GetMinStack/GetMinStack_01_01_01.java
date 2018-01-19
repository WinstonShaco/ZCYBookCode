package chapter_1_stackAndQueue.Problem_01_GetMinStack;

import java.util.Stack;

/**
 * @Author: 于新泽
 * @Date: Created in 12:06 2018/1/19.
 * @site :
 * 设计一个有getMin 功能的栈（士★☆☆☆）31
 * 栈和队列题目共10道题，此为第一题（1/10），练习第一次（1/10)
 */

public class GetMinStack_01_01_01 {

    public static class MyStack1{//方案一
        private Stack<Integer> stackData;//正常功能的栈
        private Stack<Integer> stackMin;//用于保存每一步的最小值的栈

        public MyStack1(){
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        /**方法一
         * 是把栈中的push方法进行了一次改装
         * 每次向StackData中压入数时，都会与stackMin的顶部（peek）进行比较
         * 刚开始stackMin是空的。第一次压入stackData中的数直接压入stavkMin中
         * 之后每次压入的数比stackMin的peek小或者相等的话 同时压入stackMin中
         * 其他情况不压入
         * @param newNum 压入栈的数
         */
        public void push(int newNum){
            if(this.stackMin.isEmpty()){
                this.stackMin.push(newNum);
            }else if(newNum <= this.getMin()){
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public int getMin(){
            if(this.stackMin.isEmpty()){
                throw new RuntimeException("Your Stack is Empty.");
            }
            return this.stackMin.peek();
        }

        public int pop(){
            if(this.stackData.isEmpty()){
                throw new RuntimeException("Your Stack is Empty.");
            }
            int value = this.stackData.pop();
            if(value == this.getMin()){
                this.stackMin.pop();
            }
            return value;
        }
    }

    public static class MyStack2{

        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2(){
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        /**方法二
         * 是把栈中的push方法进行了一次改装
         * 每次向StackData中压入数时，都会与stackMin的顶部（peek）进行比较
         * 刚开始stackMin是空的。第一次压入stackData中的数直接压入stavkMin中
         * 之后每次压入的数比stackMin的peek小的话 同时压入stackMin中
         * 如果大于等于，就把stackMin中的peek复制一份压入stackMin
         * @param newNum 压入栈的数
         */
        public void push(int newNum){
            if(this.stackMin.isEmpty()){
                this.stackMin.push(newNum);
            }else if(newNum < this.getMin()){
                this.stackMin.push(newNum);
            }else{
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
            this.stackData.push(newNum);
        }

        public int getMin(){
            if(this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }

        public int pop(){
            if(this.stackData.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }
    }

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(5);
        System.out.println(stack1.getMin());
        stack1.push(7);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());

        System.out.println("=============");

        MyStack1 stack2 = new MyStack1();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }
}
