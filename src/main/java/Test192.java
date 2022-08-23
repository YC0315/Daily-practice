import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-08-22  19:36
 * @description: 根据身高重建队列
 */
public class Test192 {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    // 当第一列元素不相等时，按第一列降序排列
                    return o2[0] - o1[0];
                } else {
                    // 当第一列元素相等时，按第二列升序排序
                    return o1[1] - o2[1];
                }
            }
        });
        // 新建一个List用于保存结果集
        List<int[]> list = new ArrayList<>();
        /*for (int i = 0; i < people.length; i++) {
            if(list.size() > people[i][1]){
                // 如果结果集中的元素数量大于排在i人的前面的人数时，将第i个人插入到people[i][1]索引位置
                list.add(people[i][1] ,people[i]);
            }else{
                // 如果结果集中的元素数量小于排在i人的前面的人数时，将第i个人追加到结果集的后面
                list.add(people[i]);
            }
        }*/
        // 也可以直接按索引插入即可，不用区分元素的数量是否大于列表数量
        for (int i = 0; i < people.length; i++) {
            // 将第i个人插入到people[i][1]索引位置
            list.add(people[i][1] ,people[i]);
        }
        // 返回结果，将list转换为int[]
        return list.toArray(new int[list.size()][]);
    }
}
