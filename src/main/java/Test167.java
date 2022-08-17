import javax.sound.midi.MidiChannel;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-08-16  14:53
 * @description: 数组中前K个最大的数
 */
public class Test167 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        // 读取一行，然后按空格分割得到字符串数组再转换成整形数组
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = sc.nextInt();
        int[] res = findThk(nums, k);
        System.out.println(Arrays.toString(res));
    }

    public static int[] findThk(int[] nums, int k) {
        // 不要忘了判断是否为0
        if(nums.length == 0 || k == 0) {
            return new int[0];  // 这是空数组的定义
        }
        // 使用快排，逆序排，记录索引，到第k-1个索引处返回数组
        int index = quickSort(nums, 0, nums.length - 1, k);
        return Arrays.copyOfRange(nums, 0, index+1); // 直接拷贝一份部分原数组返回即可，包含from不包含to
    }
    public static int quickSort(int[] nums, int left, int right, int k){

        int start = left;
        int end = right;
        // 随机初始化基准
        Random random = new Random();
        int index = random.nextInt(right - left + 1) + left;//在0~right-left+1的范围内生成随机数，因此要加上left
        int prior = nums[index];
        nums[index] = nums[left]; // 不要忘了将最左边的值替换掉，否则nums[left]会丢失

        while(left < right){
            // 逆序排，这块等号不要忘记！！
            while(left <right && prior >= nums[right]){
                right--;
            }
            nums[left] = nums[right];
            while(left < right && prior <= nums[left]){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = prior;
        // 判断当前索引和K的关系，然后只递归一边
        if(left < k-1){
            return quickSort(nums, left+ 1, end, k);
        }else if(left > k-1){
            return quickSort(nums, start, left-1, k);
        }else{
            return left;
        }
    }
}
