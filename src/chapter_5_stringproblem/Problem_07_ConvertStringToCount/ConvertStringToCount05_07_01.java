package chapter_5_stringproblem.Problem_07_ConvertStringToCount;

import com.sun.tracing.dtrace.StabilityLevel;

import javax.lang.model.element.NestingKind;

/**
 * @Author: 于新泽
 * @Date: Created in 2019/8/13 17:34
 * @site :  字符串的统计字符串 士（★☆☆☆） 253
 * @Description :
 */
public class ConvertStringToCount05_07_01 {

    /**
     *
     * @param str ： 目标字符串
     * @return ：目的字符串
     */
    public static String getCountString(String str){
        if(str == null && str.equals("")){
            return "";
        }
        char[] chs = str.toCharArray();
        String res = String.valueOf(chs[0]);
        int num = 1;
        for(int i = 1 ;i< chs.length;i++){
            if(chs[i] != chs[ i - 1 ]){
                res = concat(res,String.valueOf(num), String.valueOf(chs[i]));
                num = 1;
            } else {
                num++;
            }
        }
        return concat(res,String.valueOf(num),"");
    }


    /**
     * 拼接字符串
     * 例如：s1_s2_s3 ……
     * @param s1 : 当前字符串
     * @param s2 : 当前字节个数
     * @param s3 : 结上下一个字符
     * @return : 返回已拼接的字符串
     */
    public static String concat(String s1,String s2,String s3){
        return s1 + "_" + s2 + (s3.equals("") ? s3 : "_" + s3);
    }


    /**
     *
     * @param str : 目标字符串
     * @param index : 第几位
     * @return ： 返回选中字节
     */
    public static char getCharAt(String str,int index){
        if(str == null || str.equals("")){
            return 0;
        }
        char[] chs = str.toCharArray();
        boolean stag = true;
        char cur = 0;
        int sum = 0;
        int num = 0;
        for(int i = 0 ; i != chs.length ; i++){
            if(chs[i] == '_'){
                stag = !stag;
            } else if (stag){
                sum += sum;
                if(sum >  index){
                    return cur;
                }
                num = 0;
                cur = chs[i];
            } else {
                num = num * 10 + chs[i] - '0';
            }

        }
        return sum + num > index ? cur : 0;
    }

    public static void main(String[] args) {
        String str = "aaabbadddffc";
        String res = getCountString(str);
        System.out.println(str);
        System.out.println(res);
        System.out.print(getCharAt(res, 9));

    }


}
