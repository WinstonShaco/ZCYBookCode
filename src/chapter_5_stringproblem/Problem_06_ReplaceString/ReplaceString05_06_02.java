package chapter_5_stringproblem.Problem_06_ReplaceString;

/**
 * @Author: 于新泽
 * @Date: Created in 2019/8/8 10:56
 * @site :
 * @Description :
 */
public class ReplaceString05_06_02 {

    public static String replace(String str, String from ,String to){
        if(str == null || from == null || str.equals("") || from.equals("") ){
            return str;
        }
        char[] chaStr = str.toCharArray();
        char[] chaFrom = from.toCharArray();
        int match = 0;
        for(int i = 0 ; i < chaStr.length ; i++ ){
            if (chaStr[i] == chaFrom[match++]) {
                if(match == chaFrom.length){
                    clear(chaStr,i,chaFrom.length);
                    match = 0;
                }
            } else {
                match = 0;
            }
        }

        String res = "";
        String cur = "";
        for(int i = 0;i < chaStr.length;i++){
            if(chaStr[i] != 0){
                cur = cur + String.valueOf(chaStr[i]);
            }
            if(chaStr[i] == 0 && (i == 0 || chaStr[i - 1] != 0)){
                res = res + cur + to;
                cur = "";
            }
        }

        if (!cur.equals("")) {
            res = res + cur;
        }

        return res;
    }

    public static void clear (char[] chas,int end ,int len){
        while (len-- != 0){
            chas[end--] = 0;
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
