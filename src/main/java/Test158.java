import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: yangchao
 * @createTime: 2022-08-14  14:19
 * @description: 使用Stream流案例
 */
public class Test158 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,0,0};
        System.out.println(Arrays.toString(nums));
        // 过滤
        List<Integer> list1 = Stream.of(1,2,3,4,5,6)
                .filter(num -> num != 5)
                .collect(Collectors.toList());

        List<String> list = Arrays.asList("Hello","World","Java");
        list.stream().filter(str->str.length()>=5).forEach(System.out::println);

    }

    // 将小写字符串变大写然后拼接起来
    @Test
    public void Stream(){
        // 用reduce 方法处理其他类型的 stream，例如，可以操作一个 String 类型的数组，把数组的字符串进行拼接：
        List<String> list = Arrays.asList("a", "b", "c", "d");
        String result = list.stream()
                // 初始值,(每一次相加的结果， 下一个要累加的值) -> total + next;
                .reduce("", (total, next) -> total.toUpperCase() + next.toUpperCase());
        System.out.println(result);
    }

    // 将小写字符串数组变大写然后拼接起来 ABC#DEF#GHK#
    @Test
    public void Stream1(){
        String[] strings = {"abc", "def", "ghk"};
        String result = Arrays.stream(strings)
                .reduce("", (total, next) -> total.toUpperCase() + next.toUpperCase()+ "#");
        System.out.println(result);
    }

}
