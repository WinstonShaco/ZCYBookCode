package chapter_5_stringproblem.Problem_02_AllNumbersSum;

/**
 * @Author: 于新泽
 * @Date: Created in 2019/8/8 14:03
 * @site : 字符串中数字子串的求和 士（★☆☆☆） 243
 * @Description :
 */
public class AllNumbersSum05_02_01 {

    /**
     * 1.整型变量 res 当前累加和、
     *   整型变量 num 收集当前得到的数字、
     *   布尔变量 posi 如果把 num 累加到 res 中，num 是正还是负
     *   默认 res = 0 num = 0  posi = true
     * 2.从左向右遍历 str
     * 3.如果遍历到不在 '0'--'9' 之间 ，判断是不是'-'，如果是进行符号运算
     * @param str : 输入的字符串
     * @return : 和
     */
    public static int numSum(String str){
        if(str == null){
            return 0;
        }
        char[] charArr = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean posi = true;
        int cur = 0;
        for (int i = 0 ; i < charArr.length ; i++ ){
            cur = charArr[i] - '0';
            if(cur < 0 || cur > 9){
                res += num;
                num = 0;
                if(charArr[i] == '-'){
                    if(i - 1 > -1 && charArr[i - 1] == '-'){
                        posi = !posi;
                    } else {
                        posi = false;
                    }
                } else {
                    posi = true;
                }
            } else {
                num = num * 10 + (posi ? cur : -cur);
            }
        }
        res += num;
        return res;
    }

    public static void main(String[] args) {
        String test = "1K-100ABC500D-T--100F200G!!100H---300";
        System.out.println(numSum(test));
    }
}
