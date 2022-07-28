import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 8、删除排序数组中的重复项
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 备注：1、不能使用set；2、不能使用splice
 */
public class Test18 {
    public static void main(String[] args) {
        Integer[] arr = {-1, 0, 2, 2, 4, 6, 6, 6, 9};   // 数组定义成Integer类型，方便和列表进行转换
        Integer[] res = deleteDup(arr);
        System.out.println(Arrays.toString(res));

        int[] c = {1,2,3};
        // int[] 转成 Integer[]
        Integer[] integers = Arrays.stream(c).boxed().toArray(Integer[]::new);
        // Integer[] 转成int[]
        int[] ints = Arrays.stream(integers).mapToInt(Integer::intValue).toArray();

    }
    private static Integer[] deleteDup(Integer[] arr) {

        // 对于一个非基本类型的数组转换为列表有两种方法！基本数据类型不可以转换成列表

        // 方法1： Arrays.asList()，但是这种方法数组转成的list,，不能对List增删，只能查改，否则抛异常！
        //List<Integer> list = Arrays.asList(arr);

        // 方法2： Collections.addAll(列表,数组)，将数组转换为List后，可以对List进行增删改查操作，速度快
        List<Integer> arrayList = new ArrayList<>();  // 先创建一个列表，用于存放数组值
        Collections.addAll(arrayList, arr);   // 使用Collections.addAll(列表， 数组)的方式进行转换


        int a = 0;
        int b = a + 1;
        while (b < arrayList.size() - 1) {
            // 包装类型比较值是否相等使用equals
            while (arrayList.get(a).equals(arrayList.get(b))) {
                arrayList.remove(b);
            }
            a++;
            b++;
        }
        return arrayList.toArray(new Integer[arrayList.size()]);

    }
}
