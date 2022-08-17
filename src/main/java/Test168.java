import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-08-16  16:01
 * @description: 出现频率最高的K个数字
 * 给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。
 */
public class Test168 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 读取一行，然后按空格分割得到字符串数组再转换成整形数组
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = sc.nextInt();
        int[] ints = topKFrequent(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    /* 使用堆排序
        借助 哈希表 来建立数字和其出现次数的映射，遍历一遍数组统计元素的频率
        维护一个元素数目为 k 的最小堆
        每次都将新的元素与堆顶元素（堆中频率最小的元素）进行比较
        如果新的元素的频率比堆顶端的元素大，则弹出堆顶端的元素，将新的元素添加进堆中
        最终，堆中的 k 个元素即为前 k 个高频元素
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // 存放元素和出现的次数
        for (int num : nums) {
            // 当Map中有这个key时，就使用这个key对应的value值，如果没有就使用默认值defaultValue
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 构建一个小顶堆,PriorityQueue优先队列传入比较器默认是实现小顶堆！！！
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        // 下面也可以使用lambda表达式代替匿名内部类
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1]; //按元素的频率进行排序   n[1]-m[1]是实现大顶堆
            }
        });
        // 将map中的元素放入小顶堆中，堆顶会自动维护成最小元素
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            // 判断队列中是否已经有了k个[num, count]元素
            if (queue.size() == k) {
                // 将待插入元素的频率和堆顶最小频率进行比较，比堆顶频率大，插入
                if (count > queue.peek()[1]) {
                    queue.poll(); // 移除堆顶元素
                    queue.add(new int[]{num, count});// 插入新的频率更高的元素
                }
            } else {
                // 队列中的元素不足k，则直接插入，
                queue.add(new int[]{num, count});
            }
        }
        // 遍历结束后，队列里就是频率最大的k个元素了
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.poll()[0];  // 我们要弹出的是元素值，不是元素的次数
        }
        return res;
    }
}