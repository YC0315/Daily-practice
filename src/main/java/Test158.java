import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: yangchao
 * @createTime: 2022-08-14  14:19
 * @description: TODO
 */
public class Test158 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,0,0};
        System.out.println(Arrays.toString(nums));
        List<Integer> list1 = Stream.of(1,2,3,4,5,6)
                .filter(num -> num != 5)
                .collect(Collectors.toList());

        List<String> list = Arrays.asList("Hello","World","Java");
        list.stream().filter(str->str.length()>=5).forEach(System.out::println);
    }
}
