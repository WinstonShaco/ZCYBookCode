package chapter_4_recursionanddp.Problem_02_MinPathSum;

/**
 * @Author: 于新泽
 * @Date: Created in 0:27 2018/1/21.
 * @site :
 * 矩阵的最小路径和（尉★★☆☆）187
 * 递归和动态规划共17道题，此题为第2题，练习第一次
 */

public class MinPathSum04_02_01 {

    /**
     * 经典的解法 动态规划
     * 时间复杂度O(m*n),空间复杂度O(m*n)
     */
    public static int minPathSum1(int[][] m){
        if(m == null || m.length == 0 || m[0].length == 0){
            return 0;
        }
        int row = m.length;//每排的长度
        int col = m[0].length;//每列的长度
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    /**
     * 空间压缩方法 如果本题要路径  此方法就不能用了
     *时间复杂度O(m*n),空间复杂度O(min{m,n})
     */
    public static int minPathSum2(int[][] m){
        if(m == null || m.length == 0 || m[0].length == 0){
            return 0;
        }
        int more = Math.max(m.length,m[0].length);//行数与列数较大的那个为more
        int less = Math.min(m.length,m[0].length);//行数与列数较小的那个为less
        boolean rowmore = more == m.length;//行数是不是大于等于列数
        int[] arr = new int[less]; //辅助数组的长度仅为行数与列数中的最小值
        arr[0] = m[0][0];
        for(int i = 1 ;i < less;i++){
            arr[i] = arr[i - 1] + (rowmore ? m[0][i] : m[i][0]);
        }
        for(int i = 1;i < more;i++){
            arr[0] = arr[0] + (rowmore ? m[i][0] : m[0][i]);
            for(int j = 1;j < less;j++){
                arr[j] = Math.min(arr[j - 1],arr[j]) + (rowmore ? m[i][j] : m[j][i]);
            }
        }
        return arr[less - 1];
    }

    public static void printMatrix(int[][] matrix){
        for(int i = 0;i != matrix.length;i++){
            for(int j = 0 ;j != matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] m = {
                {1,3,5,9},
                {8,1,3,4},
                {5,0,6,1},
                {8,8,4,0}
        };
        printMatrix(m);
        System.out.println(minPathSum1(m));
        System.out.println(minPathSum2(m));
    }
}
