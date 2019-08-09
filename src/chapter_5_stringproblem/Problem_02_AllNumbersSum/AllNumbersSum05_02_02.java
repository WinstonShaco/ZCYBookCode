package chapter_5_stringproblem.Problem_02_AllNumbersSum;

/**
 * @Author: 于新泽
 * @Date: Created in 2019/8/9 10:08
 * @site :
 * @Description :
 */
public class AllNumbersSum05_02_02 {

    public static int number(String str){
        if(str == null){
            return 0;
        }
        char[] charArr = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean posi = true;
        int cur = 0;
        for(int i = 0 ; i < charArr.length; i++){
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
        System.out.println(number(test));
    }
}
