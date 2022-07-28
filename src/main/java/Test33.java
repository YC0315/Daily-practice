/**
 * @author: yangchao
 * @createTime: 2022-07-02  15:37
 * @description: TODO
 */
public class Test33 {
    public static void main(String[] args) {
        String content1 = "12312313";
        System.out.println(findMin(content1));
    }
    private static String findMin(String str) {
        if(str == null || str.length() == 0){
            return "no pattern";
        }
        String temp = null;
        char[] chars = str.toCharArray();
        char ft = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (ft == chars[i]) {
                temp = str.substring(0, i);
                break;
            }
        }
        assert temp != null;
        int len = temp.length();
        int k = 0;
        for (int j = 0; j < str.length() / len; j++) {
            String substring = str.substring(len * j, len * j + len);
            if (!temp.equals(substring)){
                return "no pattern";
            }
            k++;
        }
        int i = str.length() % len;
        String substring = str.substring(len*k, str.length());
        if(str.length()-(len * k) < len && temp.substring(0, i).equals(str.substring(len*k))){
            return temp;
        }
        return "no pattern";
    }
}
