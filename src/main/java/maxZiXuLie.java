import java.util.LinkedList;

/**
 * 最长子序列：
 *      给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *      输入: s = "abcabcbb"
 *      输出: 3
 *      解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */

/*public class maxZiXuLie {
    public int lengthOfLongestSubstring(String s) {
        int temp_num = 0;
        int left = 0;
        int right = 0;
        if("".equals(s)) return 0;


        while(left < s.length()){
            // 创建一个list，检查字母是否在集合中
            List<Character> list = new LinkedList<Character>();
            while(right < s.length()){
                if(!list.contains(s.charAt(right))){
                    list.add(s.charAt(right));
                    right++;
                    temp_num = Math.max(temp_num, right-left);
                }else{
                    break;
                }
            }
            left++;
            right = left;
        }
        return temp_num;
    }*/


/*public class maxZiXuLie {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;//最长子串长度
        int left = 0;//滑动窗口左下标，i相当于滑动窗口右下标
        for(int i=0; i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);  // 将和键和索引值存入map集合中
            max = Math.max(max, i-left+1);
        }
        return max;
    }*/
public class maxZiXuLie {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        LinkedList<Character> list = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            // 如果队列里有重复的元素出现，则队列删除头，一直删除到那个重复的元素为止 队列里剩下的就是有效的无重复字符的子串了
            // 举例：abcbd 一开始a b c三个元素都加到队列里，当再加第二个b的时候，发现队列里已经存在b了 那么就从
            // 队列的头开始删除队列里的元素 一直到把第一个b删除为止 剩下的元素就是c了 然后再把第二个b加到队列里
            if (list.contains(s.charAt(i))) {
                while (list.removeFirst() != s.charAt(i)) {
                }
                list.add(s.charAt(i));
                max = Math.max(max, list.size());
            }
            return max;
        }
        return 0;
    }
}
//    @Test
//    public void test() {
//        String s = " s ";
//        System.out.println(s.length());
//        int result = lengthOfLongestSubstring(s);
//        System.out.println(result);
//    }
//



