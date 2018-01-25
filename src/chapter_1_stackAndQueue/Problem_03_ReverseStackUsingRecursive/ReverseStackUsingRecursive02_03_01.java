package chapter_1_stackAndQueue.Problem_03_ReverseStackUsingRecursive;

import java.util.Stack;

/**
 * @Author: 于新泽
 * @Date: Created in 17:34 2018/1/23.
 * @site :
 * 如何仅用递归函数和栈操作逆序一个栈（尉★★☆☆）8
 */

public class ReverseStackUsingRecursive02_03_01 {
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.empty()){
            return result;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while(!test.isEmpty()){
            System.out.println(test.pop());
        }
    }
}
