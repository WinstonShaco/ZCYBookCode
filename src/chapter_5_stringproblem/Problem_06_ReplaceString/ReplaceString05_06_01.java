package chapter_5_stringproblem.Problem_06_ReplaceString;

/**
 * @Author: 于新泽
 * @Date: Created in 2019/8/7 14:08
 * @site : 替换字符串中连续出现的指定字符串 士（★☆☆☆）
 * @Description :
 */
public class ReplaceString05_06_01 {

    /**
     * 1.先将字符串转化成数组存储
     * 2.变量 match 表示目前匹配到 from 字符串的位置。
     * 3.如果 str[i]==from[match]。如果match是from最后一个位置，说明str中发现了
     *   from字符串，则从i位置向左的from字符串长度位都设置为0，设置完后将match改
     *   为0，如果match不是from最后一个字符位置，让match++，继续遍历。
     * 4.如果str[i]!=from[match]，将match=0,遍历str的下一个字符
     * 5.接下来就是将所有为0的位置替换成to，并拼接起来。
     * @param str : 目标字符串
     * @param from : 被替换字符串
     * @param to : 替换字符串
     * @return
     */
    public static String replace(String str,String from ,String to){
        if(str == null || from == null || str.equals("") || str.equals("")){
            return str;
        }
        char[] chastr = str.toCharArray();
        char[] chafrom = from.toCharArray();
        int match = 0;
        for ( int i = 1 ; i < chastr.length ; i++ ) {
            if(chastr[i] == chafrom[match++]){
                if(match == chafrom.length) {
                    clear(chastr,i,chafrom.length);
                    match = 0;
                }
            } else {
                if(chastr[i] == chafrom[0]){
                    i--;
                }
                match = 0;
            }
        }

        String res = "";
        String cur = "";
        for(int i = 0;i < chastr.length;i++){
            if(chastr[i] != 0){
                cur = cur + String.valueOf(chastr[i]);
            }
            if(chastr[i] == 0 && ( i == 0 || chastr[i - 1] != 0)){
                res = res + cur + to;
                cur = "";
            }
        }
        if(!cur.equals("")){
            res = res + cur;
        }
        return res;
    }

    /**
     * 从位置 end 开始向前 len 位都设置为0
     * @param chastr : 选取的字符串
     * @param end : 尾部标记位
     * @param len : 长度
     */
    public static void clear (char[] chastr,int end,int len){
        while (len -- != 0){
            chastr[end--] = 0;
        }
    }

    public static void main(String[] args) {
        String str = "abc1abcabc1234abcabcabc5678";
        String from = "abc";
        String to = "XXXXX";
        System.out.println(replace(str, from, to));

        str = "abc";
        from = "123";
        to = "X";
        System.out.println(replace(str, from, to));

    }
}
