import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: yangchao
 * @createTime: 2022-08-30  08:14
 * @description: 滑动窗口的最大值
 */
public class Test215 {
    public int[] maxSlidingWindow1(int[] nums, int k) {
        // 使用优先队列，用堆，不用着急出堆，满足条件再出堆
        int n = nums.length;
        // 创建一个堆
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        // 将前k个元素加入堆中
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        // 创建返回数组
        int[] res = new int[n - k + 1];
        res[0] = pq.peek()[0];
        // 将剩余元素加入大顶堆中
        for (int j = k; j < nums.length; j++) {
            pq.offer(new int[]{nums[j], j});
            // 不比大小，只检查最大值元素的索引是否还在滑动窗口范围内，不在就弹出！！！！
            while (pq.peek()[1] <= j - k) {
                pq.poll();
            }
            // res数组中的位置和j不同步，因此要找到j在res中为位置
            res[j - k + 1] = pq.peek()[0];
        }
        return res;
    }

    // 使用单调栈也可以
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        // 使用一个双端队列模拟一个栈
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 这块要存索引，因为方便判断当前元素是否在滑动窗口内,索引不要存储元素值！
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                stack.pollLast();
            }
            // 将当前元素的索引加入到末端
            stack.addLast(i);
            // 在添加res元素之前，判断首元素代表的最大值是否在滑动窗口内
            while (stack.peekFirst() <= i - k) {
                stack.pollFirst();
            }
            // 窗口形成之后
            if (i >= k - 1) {
                res[i - k + 1] = nums[stack.peekFirst()];
            }
        }
        return res;
    }
}
