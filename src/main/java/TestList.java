import java.util.LinkedList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-18  15:21
 * @description: TODO
 */
public class TestList {
    public static void main(String[] args) {
        Integer[] iarray = new Integer[20];
        for(int i = 0; i < iarray.length; i++)
            iarray[i] = i;
        List<Integer> list = new LinkedList<>();
        // 测试add方法
        for(Integer i : iarray)
            list.add(i);
        System.out.println(list);
        list.add(2, 10);
        System.out.println(list);
        // 测试remove方法
        list.remove(2);
        System.out.println(list);
        list.remove(new Integer(10));
        System.out.println(list);
        // 测试set方法
        list.set(2, 11);
        System.out.println(list);
        // 测试subList
        System.out.println(list.subList(2, 10));
        // 测试get
        System.out.println(list.get(18));
        // 测试indexOf, lastIndexOf
        System.out.println("indexOf(): " + list.indexOf(11) +
                " lastIndexOf(): " + list.lastIndexOf(11));
        System.out.println("indexOf(): " + list.indexOf(111) +
                " lastIndexOf(): " + list.lastIndexOf(111));
        // 测试contains
        System.out.println("contains(4): " + list.contains(4) +
                " contains(100): " + list.contains(100));
        // 测试迭代器
        for(Integer i : list) {
            System.out.print(i + " ");
//			list.add(2 * i);      // 去掉注释会抛出异常，在迭代器调用时，不允许修改list
        }
        System.out.println();
        // 测试size，clear，isEmpty
        System.out.println("size(): " + list.size());
        list.clear();
        System.out.println("调用clear()后\nsize(): " + list.size());
    }
}
