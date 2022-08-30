import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: yangchao
 * @createTime: 2022-08-29  14:15
 * @description: 滑动窗口的最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
public class Test212 {
    // 可以使用朴素的双指针，但是超时
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length <= k) {
            return new int[]{Arrays.stream(nums).max().getAsInt()};
        } else if (k == 1) {
            return nums;
        }
        int left = 0, right = k - 1;
        int[] res = new int[nums.length - k + 1];
        // 找到第一个最大值
        res[0] = nums[0];
        for (int i = left; i <= right; i++) {
            res[0] = Math.max(res[0], nums[i]);
        }
        int j = 1;
        left++;
        right++;
        while (right < nums.length) {
            if (nums[right] > res[j - 1]) {
                res[j] = nums[right];
            } else {
                // 重新遍历当前数组
                // 下面有错误
                res[j] = Integer.MIN_VALUE;
                if (res[j - 1] == nums[left - 1]) {
                    for (int i = left; i <= right; i++) {
                        res[j] = Math.max(res[j], nums[i]);
                    }
                } else {
                    res[j] = res[j - 1];
                }

            }
            j++;
            left++;
            right++;
        }
        return res;
    }

    // 使用优先队列，使用大顶堆来获取最大值
    // 在优先队列中存储二元组 (num,index)，表示元素num 在数组中的下标为index
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair2[0] - pair1[0];
            }
        });
        // 将前k个元素加入大顶堆
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        // 返回结果
        int[] res = new int[n - k + 1];
        res[0] = pq.peek()[0];
        for (int j = k; j < n; j++) {
            pq.offer(new int[]{nums[j], j});
            // 判断最大值是否在滑动窗口区间内，不在则删除堆内该最大值对应的[nums[i], i]
            // 就是说只要不会影响我，我就先不删(你不是最大值，或者你是最大值但是暂时还在滑动窗口范围内)。
            // 假如你影响我了，即你是最大值而且你已经不在当前滑动窗口范围内了，就干掉你，更新最大值
            while (pq.peek()[1] <= j - k) {
                pq.poll();
            }
            // 此时堆顶元素就是滑动窗口的最大值
            res[j - k + 1] = pq.peek()[0];
        }
        return res;
    }

    // 使用单调递减栈，栈中的元素始终是单调递减的，不是则一直删成递减的，然后先判断队首元素是否在窗口的范围内，在则添加到res,不在则先删再将队首元素添加到res
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        // 使用双向队列模拟一个单调递减栈，保存窗口最大值的数组位置
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 始终维护列队是单调递减的，否则就从后往前删
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 如果比队列中最小的值要小，则将当前元素对应的索引假如队列
            queue.addLast(i);
            // 判断队首元素是否还在滑动窗口内
            if (queue.peekFirst() <= i - k) {
                // 不在窗口内就删掉当前队列元素索引
                queue.pollFirst();
            }
            // 窗口形成之后，保存当前窗口的最大值
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

}























