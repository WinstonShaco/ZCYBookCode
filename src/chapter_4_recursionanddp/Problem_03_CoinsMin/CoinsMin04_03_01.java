package chapter_4_recursionanddp.Problem_03_CoinsMin;

/**
 * @Author: 于新泽
 * @Date: Created in 23:29 2018/1/21.
 * @site :
 * 还钱的最少货币数（尉★★☆☆）191
 */

public class CoinsMin04_03_01 {

    public static int minCoins1(int[] arr,int aim){
        if(arr == null || arr.length == 0 || aim < 0){
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for(int j = 1;j <= aim;j++){
            dp[0][j] = max;
            if(j - arr[0] >= 0 && dp[0][j - arr[0]] != max){
                dp[0][j] = dp[0][j - arr[0]] + 1;
            }
        }
        int left = 0;
        for(int i = 1;i < n;i++){
            for(int j = 1;j <= aim;j++){
                left = max;
                if(j - arr[i] >= 0 && dp[i][j - arr[i]] != max){
                    left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left,dp[i - 1][j]);
            }
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }
    public static void main(String[] args) {
        int[] arr1 = { 6, 10 };
        int aim1 = 36;
        System.out.println(minCoins1(arr1, aim1));


    }
}
