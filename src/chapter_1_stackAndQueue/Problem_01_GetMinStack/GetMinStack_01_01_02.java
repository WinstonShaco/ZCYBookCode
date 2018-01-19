package chapter_1_stackAndQueue.Problem_01_GetMinStack;

import java.util.Stack;

/**
 * @Author: 于新泽
 * @Date: Created in 12:07 2018/1/19.
 * @site :
 * 设计一个有getMin 功能的栈（士★☆☆☆）31
 * 栈和队列题目共10道题，此为第一题（1/10），练习第一次（2/10)
 */

public class GetMinStack_01_01_02 {
    public static class MyStack1{

        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1(){
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

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
                throw new RuntimeException("Your Stack is empty.");
            }
            return this.stackMin.peek();
        }

        public int pop(){
            if(this.stackData.isEmpty()){
                throw new RuntimeException("Your Stack is empty.");
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

        public void push(int newNum){
            if(this.stackMin.isEmpty()){
                this.stackMin.push(newNum);
            }else if(newNum <= this.getMin()){
                this.stackMin.push(newNum);
            }else{
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
            this.stackData.push(newNum);
        }

        public int pop(){
            if(this.stackData.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        public int getMin(){
            if(this.stackMin.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(3);
        System.out.println(stack1.getMin());
        stack1.push(4);
        System.out.println(stack1.getMin());
        stack1.push(5);
        System.out.println(stack1.getMin());
        stack1.push(2);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());

        System.out.println("############################");

        MyStack2 stack2 = new MyStack2();
        stack2.push(9);
        System.out.println(stack2.getMin());
        stack2.push(5);
        System.out.println(stack2.getMin());
        stack2.push(6);
        System.out.println(stack2.getMin());
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(2);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }
}
