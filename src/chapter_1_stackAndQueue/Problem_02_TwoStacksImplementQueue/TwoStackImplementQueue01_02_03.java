package chapter_1_stackAndQueue.Problem_02_TwoStacksImplementQueue;

import java.util.Stack;

/**
 * @Author: 于新泽
 * @Date: Created in 10:58 2018/1/22.
 * @site :
 * 由两个栈组成的队列（尉★★☆☆）5
 */

public class TwoStackImplementQueue01_02_03 {

    public static class TwoStacksQueue{
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue(){
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        public void add(int pushInt){
            stackPush.push(pushInt);
        }

        public int poll(){
            if(stackPop.empty() && stackPush.empty()){
                throw new RuntimeException("Queue is empty!");
            }else if(stackPop.empty()){
                while(!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek(){
            if(stackPop.empty() && stackPush.empty()){
                throw new RuntimeException("Queue is empty!");
            }else if(stackPop.empty()){
                while (!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }

    public static void main(String[] args) {
        TwoStacksQueue t1 = new TwoStacksQueue();
        t1.add(1);
        t1.add(8);
        t1.add(8);
        t1.add(4);
        t1.add(5);
        t1.add(7);
        t1.add(9);
        t1.add(2);
        t1.add(2);
        t1.add(1);
        t1.add(2);
        System.out.print(" 压入： " + t1.peek());
        System.out.println(" 弹出： " + t1.poll());
        System.out.print(" 压入： " + t1.peek());
        System.out.println(" 弹出： " + t1.poll());
        System.out.print(" 压入： " + t1.peek());
        System.out.println(" 弹出： " + t1.poll());
        System.out.print(" 压入： " + t1.peek());
        System.out.println(" 弹出： " + t1.poll());
        System.out.print(" 压入： " + t1.peek());
        System.out.println(" 弹出： " + t1.poll());
        System.out.print(" 压入： " + t1.peek());
        System.out.println(" 弹出： " + t1.poll());
        System.out.print(" 压入： " + t1.peek());
        System.out.println(" 弹出： " + t1.poll());
        System.out.print(" 压入： " + t1.peek());
        System.out.println(" 弹出： " + t1.poll());
        System.out.print(" 压入： " + t1.peek());
        System.out.println(" 弹出： " + t1.poll());
        System.out.print(" 压入： " + t1.peek());
        System.out.println(" 弹出： " + t1.poll());
        System.out.print(" 压入： " + t1.peek());
        System.out.println(" 弹出： " + t1.poll());



    }
}
