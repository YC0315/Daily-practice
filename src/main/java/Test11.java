import java.util.Arrays;

/**
 * 桶排序：首先设定桶的数量，然后按最大最小值求得每个桶的容量 （max - min）/ 桶个数 + 1 ，遍历数组，将
 * 每个值按区间放入桶中，对每个桶进行排序（插入排序或者快排），合并桶，即完成排序
 */
public class Test11 {
    // 进行桶排序
    public static void bucketSort(int[] arr) {
        // 空数组和数组长度为0不一样，空数组没有引用指针，因此要先判断是否为空，否则可能会出现空指针异常！！！
        if (arr == null || arr.length == 0) {
            return;
        }
        // 首先指定桶的个数
        int bucketCount = 5;
        // 遍历原始数组，找到最大值和最小值
        int max = 0;
        int min = 0;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        // 求得每个桶存放值得范围,存放多少值
        int range = (max - min) / bucketCount + 1;
        // [[], [], []...], 设置桶(数组)，不可以用列表，因为需要提前设置内部数组的个数
        int[][] buckets = new int[bucketCount][];

        // 遍历原始序列
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            // 计算当前值应当放在哪个桶中，也就是当前值等于多少个单位桶
            // Math.floor是取一个数的整数部分，int类型转换是向下取整！！！！
            int bucketIndex = (int) Math.floor((value - min) / range);
            // 向该桶中添加元素
            buckets[bucketIndex] = appendValue(buckets[bucketIndex], value);
        }
        // 将所有元素都装入各自的桶后，合并桶装回arr即可,遍历每个桶，替换掉arr原序列
        int k = 0;
        for (int[] bucket : buckets) {
            if (bucket.length > 0) {
                for (int num : bucket) {
                    arr[k++] = num;
                }
            }
        }
    }

    // 对每个桶进行排序
    private static int[] appendValue(int[] bucket, int value) {
        if (bucket == null || bucket.length == 0) {
            return new int[]{value};
        }

        // 对原数组进行一个拷贝扩容，增加一位置，因为数组无法直接使用add插入，必须先扩容才能赋值，数组长度在创建时就已经确定
        bucket = Arrays.copyOf(bucket, bucket.length + 1); // 创建新数组
        bucket[bucket.length - 1] = value;// 插入新值

        // 对数组进行排序，这里使用插入排序
        for (int j = 1; j < bucket.length; j++) {
            if (bucket[j] < bucket[j - 1]) {
                int k = j;      // 记录当前元素值的索引
                int temp = bucket[j];  // 记录当前元素值
                while (k > 0 && bucket[k - 1] > temp) {
                    bucket[k] = bucket[k - 1];
                    k--;
                }
                bucket[k] = temp;
            }
        }
        return bucket;
    }

    public static void main(String[] args) {
        int[] arr = {-7, 51, 3, 121, -3, 32, 21, 43, 4, 25, 56, 77, 16, 22, 87};
        bucketSort(arr);
        // Arrays.toString()方便地输出各种类型的数组
        // 用来将数组转换成String类型输出的，
        System.out.println(Arrays.toString(arr));
        // 这样输出地址
        System.out.println(arr.toString());

        // 使用反射查看一个对象的类型
        Integer m = 0;
        System.out.println(m.getClass().toString());

        // 整型转字符串
        Integer a = 1000;
        System.out.println(a.getClass());
        String s = String.valueOf(a);
        System.out.println(s.getClass());

        // 获取某个索引处的元素
        char c = s.charAt(0);
        System.out.println(c);

        System.out.println("------------------------------------");
        // 字符串转字符数组
        char[] chars = s.toCharArray();
        int[] b = {1,2,3};
        // char类型数组是以数组的类型直接传入println，而int型数组以object的类型传入println的
        // char类型数组可以直接打印出数据，而int型数组则调用String.valueOf(Object)方法,
        // 最终调用toString()，所以打印的是toString()的返回值（对象地址）
        // char类型相当于字符串，从而不需要调用toString()方法，可以直接打印
        System.out.println(b);
        System.out.println(chars);  // 直接输出数组名：将字符数组以字符串形式打印
        System.out.println("a" + chars); // 数组名前面有字符：输出字符数组首元素的地址
        System.out.println(Arrays.toString(chars));  // 以数组的形式输出[1,0,0,0]

        String n = new String("123");

    }
}
