import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-09-19  18:56
 * @description: TODO
 */
public class Test266 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> startEnd = new ArrayList<>();
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            startEnd.add(new int[]{a, b});
        }
        Collections.sort(startEnd, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        if(startEnd.size() == 1) System.out.println(startEnd.get(0)[1]-startEnd.get(0)[0]);
        int aa = startEnd.get(0)[0];
        int bb = startEnd.get(startEnd.size()-1)[1];
        int len = bb - aa;
        for(int i = 0; i <= startEnd.size()-1; i++){
            int[] bef = startEnd.get(i);
            int d = bef[1];
            int[] aft = startEnd.get(i+1);
            int e = aft[0];
            if(e >= d){
                len = len - (e - d);
            }
        }
        System.out.println(len);
    }
}
