import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-08-16  19:15
 * @description: 前k个高频单词
 * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词‘出现频率’由高到低排序。如果不同的单词有相同出现频率，按字典顺序排序。
 * <p>
 * 输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 */
public class Test169 {
    // 频率问题首先想到小顶堆/大顶堆
    List<String> res = new ArrayList<>();
    public List<String> topKFrequent(String[] words, int k) {
        // 创建一个map用来存放<元素，出现频率>
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // 使用优先队列生成一个k个元素的小顶堆,只存放元素值，根据元素在map中对应的频率存放
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2)->{
            if(map.get(o1).equals(map.get(o2))){
                return o2.compareTo(o1); // 如果有相同的频率则按字典顺序排序
            }
            // 是使用单词的频率相减
            return map.get(o1)-map.get(o2); // 小顶堆:return 前减后(o1-o2)， 大顶堆:return 后减前(o2-o1)
        });
        // 插入小顶堆
        for (String s : map.keySet()) {
            queue.offer(s);
            if(queue.size()>k){
                queue.poll();
            }
        }
        // 从小顶堆的堆顶开始输出，元素为从小到大
        for (int i = 0; i < k; i++) {
            res.add(queue.poll());
        }
        // 因为要求按单词‘出现频率’由高到低排序，因此要翻转列表
        Collections.reverse(res);
        return res;
    }
}
