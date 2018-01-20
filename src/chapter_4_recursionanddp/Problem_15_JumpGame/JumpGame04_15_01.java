package chapter_4_recursionanddp.Problem_15_JumpGame;

/**
 * @Author: 于新泽
 * @Date: Created in 1:14 2018/1/21.
 * @site :
 * 跳跃游戏（士★☆☆☆）235
 *
 */

public class JumpGame04_15_01 {

    public static int jump(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int jump = 0;//计数 统计一共跳了多少步
        int cur = 0;//目前达到的最远距离
        int next = 0;//如果多跳一步最远到达的位置
        for(int i = 0 ;i < arr.length;i++){
            if(cur < i){
                jump++;
                cur = next;
            }
            next = Math.max(next,i + arr[i]);
        }
        return jump;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 3, 1, 1, 4 };
        System.out.println(jump(arr));

    }
}
