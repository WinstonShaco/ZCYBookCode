package chapter_1_stackAndQueue.Problem_02_TwoStacksImplementQueue;

import java.util.Stack;

/**
 * @Author: 于新泽
 * @Date: Created in 19:13 2018/1/19.
 * @site :
 *  * 由两个栈组成的队列（尉★★☆☆）5
 * 栈和队列题目共10道题，此为第二题（2/10），练习第一次（2/10)
 */

public class TwoStackImplementQueue01_02_02 {

    public static class TwoStacksQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue(){
            stackPop = new Stack<Integer>();
            stackPush = new Stack<Integer>();
        }

        public void add(int pushInt){
            stackPush.push(pushInt);
        }

        public int poll(){
            if(stackPop.empty() && stackPush.empty()){
                throw new RuntimeException("Queue is empty.");
            }else if(stackPop.empty()){
                while (!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek(){
            if(stackPop.empty() && stackPush.empty()){
                throw new RuntimeException("Queue ie empty.");
            }else if(stackPop.empty()){
                while(!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }

    public static void main(String[] args) {
        TwoStacksQueue test = new TwoStacksQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);
        test.add(8);

        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());




    }
}
