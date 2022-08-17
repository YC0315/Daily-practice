import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-08-17  08:24
 * @description: 出现频率最高的K个数字
 */
public class Test174 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] ints = topKFrequent(nums, k);
        System.out.println(Arrays.toString(ints));

    }
    // 使用优先队列构成的最小堆，维护堆中有k个元素
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        // 使用Map统计每个单词出现的频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 创建优先队列构成最小堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        // 将元素插入最小堆
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(queue.size() == k){
                if(entry.getValue() > queue.peek().getValue()){
                    queue.poll();
                    queue.offer(entry);
                }
            }else{
                queue.offer(entry);
            }
        }
        // 取出堆中的元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}
