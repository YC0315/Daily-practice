/**
 * @author: yangchao
 * @createTime: 2022-08-10  19:28
 * @description: 跳跃游戏||
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class Test137 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int jump = jump(nums);
        System.out.println(jump);
    }

    public static int jump(int[] nums) {
        // 贪心算法，从后往前寻找每次跳的最远的元素
        // 每次找到最远元素后，移动右边界，重新寻找上上次离边界最远的元素位置
        int position = nums.length - 1;
        int step = 0;
        while (position > 0) {
            // 每次for循环只找上一次最远的位置
            for (int n = 0; n < position; n++) {
                if(n + nums[n] >= position){ // 当前元素的索引加上可以跳的最远距离是否大于等于右边界,始终找第一个这样的值
                    position = n;
                    step++;
                    break;  // 找到后退出
                }
            }
        }
        return step;
    }
}
