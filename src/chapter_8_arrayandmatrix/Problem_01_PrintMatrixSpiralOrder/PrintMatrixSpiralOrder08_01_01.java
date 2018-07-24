package chapter_8_arrayandmatrix.Problem_01_PrintMatrixSpiralOrder;

/**
 * @Author: 于新泽
 * @Date: Created in 14:42 2018/4/12.
 * @site :
 * 转圈打印矩阵（★☆☆☆）士 331
 */

public class PrintMatrixSpiralOrder08_01_01 {

    //数组中左上角的坐标标记为（x,y）;右下角坐标为（xx,yy）
    public static void spiralOrderPrint(int[][] matrix){
        int x = 0;//tr
        int y = 0;//tc
        int xx = matrix.length - 1;//dr
        int yy = matrix[0].length - 1;//dc
        while(x <= xx && y <= yy ){
            printEdge(matrix,x++,y++,xx--,yy--);
        }
    }

    //第一个外层
    public static void printEdge(int[][] m, int x, int y, int xx, int yy) {
        if(x == xx)//当子矩阵只有一行的时候
            for(int i = y;i <= yy;i++)
                System.out.print(m[x][i] + "　");
        else if(y == yy)//当子矩阵只有一列的时候
            for(int i = x;i <= xx;i++)
                System.out.print(m[i][y] + " ");
        else{//一般情况，首先定义一个二维坐标点（curx,cury）
            int cury = y;
            int curx = x;
            while(cury != yy){
                System.out.print(m[x][cury] + " ");
                cury++;
            }
            while(curx != xx){
                System.out.print(m[curx][yy] + " ");
                curx++;
            }
            while(cury != y){
                System.out.print(m[xx][cury] + " ");
                cury--;
            }
            while(curx != x){
                System.out.print(m[curx][y] + " ");
                curx--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);
    }
}
