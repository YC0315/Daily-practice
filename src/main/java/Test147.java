/**
 * @author: yangchao
 * @createTime: 2022-08-11  21:10
 * @description: 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 */
public class Test147 {
    public boolean canJump(int[] nums) {
        int position = nums.length - 1;
        while (position > 0) {
            for (int i = 0; i <= position; i++) {
                if (i + nums[i] == position){
                    position = i;
                    break;
                }
            }
        }
        return position == 0;
    }
}
