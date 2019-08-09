package chapter_5_stringproblem.Problem_03_RemoveKZeros;

/**
 * @Author: 于新泽
 * @Date: Created in 2019/8/9 14:06
 * @site : 去掉字符串中连续出现K个0的子串 士（★☆☆☆） 245
 * @Description :
 */
public class RemoveKZeros05_03_01 {

    /**
     * 1.生成两个变量，整型变量 count ，表示目前连续个‘0’的数量；
     *   整型变量 start 表示出现连续 k个‘0’的起始位置，初始时，
     *   count=0，start = -1
     * 2.从左向右遍历 str
     * 3.去掉‘0’的时刻
     * @param str ：给定字符串
     * @param k ： k
     * @return
     */
    public static String removeKZeros(String str ,int k){
        if(str == null || k < 1){
            return str;
        }
        char[] charStr = str.toCharArray();
        int count = 0;
        int start = -1;
        for(int i = 0 ; i != charStr.length ; i++) {
            if(charStr[i] == '0'){
                count++;
                start = start == -1 ? i : start;
            } else {
                if(count == k){
                    while (count-- != 0){
                        charStr[start++] = 0;
                    }
                    count = 0;
                    start = -1;
                }
            }
        }
        if (count == k) {
            while (count-- != 0)
                charStr[start++] = 0;
        }
        return String.valueOf(charStr);
    }

    public static void main(String[] args) {

        String test10 = "A00B";
        System.out.println(removeKZeros(test10, 2));

        String test1 = "0A0B0C00D0";
        System.out.println(removeKZeros(test1, 1));

        String test2 = "00A00B0C00D0";
        System.out.println(removeKZeros(test2, 2));

        String test3 = "000A00B000C0D00";
        System.out.println(removeKZeros(test3, 3));

        String test4 = "0000A0000B00C000D0000";
        System.out.println(removeKZeros(test4, 4));

        String test5 = "00000000";
        System.out.println(removeKZeros(test5, 5));

    }
}
