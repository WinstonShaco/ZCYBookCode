package chapter_4_recursionanddp.Problem_15_JumpGame;

/**
 * @Author: 于新泽
 * @Date: Created in 9:33 2018/1/22.
 * @site :
 * 跳跃游戏（士★☆☆☆）235
 */

public class JumpGame04_15_02 {

    public static int jump(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int jump = 0;//跳跃次数
        int cur = 0;//最远到达的位置
        int next = 0;//下一次最远到达位置
        for(int i = 0; i < arr.length;i++){
            if(cur < i){
                jump++;
                cur = next;
            }
            next = Math.max(next,i + arr[i]);
        }
        return jump;
    }

    public static void main(String[] args) {
        int [] arr = {1,8,8,4,5,7,9,2,2,1,2};
        int [] arr1 = {1,3,8,4,5,8,8,9,6,1,8};
        System.out.println("第一组数： " + jump(arr));
        System.out.println("第二组数： " + jump(arr1));
    }
}
