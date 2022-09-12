import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-09-08  20:11
 * @description: TODO
 */
public class Test259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> list = new ArrayList<>();
        while(sc.hasNext()){
            String[] line = sc.nextLine().split(",");
            int[] num = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
            Integer[] integers = Arrays.stream(num).boxed().toArray(Integer[]::new);
            List<Integer> temp = new ArrayList<>(num.length);
            Collections.addAll(temp, integers);
            list.add(temp);
        }


        // 二维集合怎么转成二维数组
        int len1 = list.size();
        int len2 = list.get(0).size();
        int[][] arr = new int[len1][len2];
        for(int i = 0; i < len1; i++){
            Integer[] array = (Integer[]) list.get(i).toArray();
            int[] ints = Arrays.stream(array).mapToInt(Integer::intValue).toArray();
            arr[i] = ints;
        }
    }
}
