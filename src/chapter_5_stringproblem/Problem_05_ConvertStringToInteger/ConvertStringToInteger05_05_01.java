package chapter_5_stringproblem.Problem_05_ConvertStringToInteger;

/**
 * @Author: 于新泽
 * @Date: Created in 2019/8/12 14:09
 * @site : 将整数字符串转换成整数值 尉（★★☆☆） 248
 * @Description :
 */
public class ConvertStringToInteger05_05_01 {

    /**
     * 1.查看是不是空字符串
     * 2.检查是否符合数字规则
     * 3.验证看是否超出 int 类型的范围（bigint 同样）
     *
     * int 范围 -2147483648 ~ 2147483647
     * minq : int 类型最小值十位以上的数字，即 214748364
     * minr : int 类型最小值的个位数，即 8
     * res  : 当前遍历到的数字
     * cur  : 当前位数字
     *
     * @param str ： 目标字符串
     * @return : 返回数字
     */
    public static int convert(String str){
        if(str == null || str.equals("")){
            return 0;
        }
        char[] chas = str.toCharArray();
        if(!isValid(chas)){
            return 0;
        }
        boolean posi = chas[0] == '-' ? false : true;
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        for(int i = 1 ; i < chas.length ; i++){
            cur = '0' - chas[i];
            if((res < minq) || (res == minq && cur < minr)){
                return 0;
            }
            res = res * 10 + cur;
        }
        if(posi && res == Integer.MIN_VALUE){
            return 0;
        }
        return posi ? -res : res;
    }

    /**
     * 数字规则：
     * 1.如果第一个字符不是数字，也不是减号，则不是数字
     * 2.如果第一位是减号，没有第二位或第二位是0，则不符合数字规则
     * 3.如果第一位是0，则不符合数据规则
     * 4.从第二位开始中间出现不是数字，则不是数字
     * 5.都不是以上4条就是数字
     * @param chas ：目标字符串
     * @return : true:是一个数字 false：不是数字
     */
    public static boolean isValid(char[] chas){
        if(chas[0] != '-' && (chas[0] < '0' || chas[0] > '9')){
            return false;
        }
        if(chas[0] == '-' && (chas.length == 1 || chas[1] == '0')){
            return false;
        }
        if(chas[0] == '0' && chas.length > 1){
            return false;
        }
        for(int i = 1 ; i < chas.length ; i++){
            if(chas[i] < '0' || chas[i] > '9'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String test1 = "2147483647"; // max in java
        System.out.println(convert(test1));

        String test2 = "-2147483648"; // min in java
        System.out.println(convert(test2));

        String test3 = "2147483648"; // overflow
        System.out.println(convert(test3));

        String test4 = "-2147483649"; // overflow
        System.out.println(convert(test4));

        String test5 = "-123";
        System.out.println(convert(test5));

    }

}
