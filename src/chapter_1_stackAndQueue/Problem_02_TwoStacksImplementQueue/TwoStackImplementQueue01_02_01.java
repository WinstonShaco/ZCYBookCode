package chapter_1_stackAndQueue.Problem_02_TwoStacksImplementQueue;

import java.util.Stack;

/**
 * @Author: 于新泽
 * @Date: Created in 18:04 2018/1/19.
 * @site :
 * 由两个栈组成的队列（尉★★☆☆）5
 * 栈和队列题目共10道题，此为第二题（2/10），练习第一次（1/10)
 */

public class TwoStackImplementQueue01_02_01 {

    public static class TwoStackQueue{
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStackQueue(){
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void add (int pushInt){
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
                throw new RuntimeException("Queue is empty");
            }else if(stackPop.empty()){
                while(!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }

    public static void main(String[] args) {
        TwoStackQueue test = new TwoStackQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
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
