import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-08-17  22:20
 * @description: TODO
 */
public class Test178 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.next());
        String[] strings = sc.nextLine().split(" ");
        // 将字符串转化成时间 秒为单位
        int k = 0;
        int[] nums = new int[n];
        for(String s : strings){
            String[] string = s.split(":");
            int[] arr = Arrays.stream(string).mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if(i == 0){
                    sum += arr[i]*60*60;
                } else if(i == 1){
                    sum += arr[i]*60;
                }else{
                    sum += arr[i];
                }
            }
            nums[k++] = sum;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(strings[i], nums[i]);
        }
        // 按照map的value进行排序
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2)->{
            return o2.getValue().compareTo(o1.getValue());
        });
        String s = list.get(0).getKey();
        int t = -1;
        for (int l = 0; l < list.size() - 1; l++) {
            int t1 = list.get(l).getValue()-list.get(l+1).getValue();
            if(t1 >= t){
                s = list.get(l+1).getKey();
                t = t1;
            }
        }
        System.out.println(s);
    }
}
