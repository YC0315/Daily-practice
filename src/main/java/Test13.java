/**
 *  判断一个数字是否为质数：质数就是没有因数的数，也就是除了1和本身之外不再有可以整除的数
 *  对于一个数x, 在[2, x-1]范围内不再有可以被整除的数y，若x % y == 0 则x不是质数
 *  简化：可以判断在[2，根号x]范围内是否有因数，有则x不是质数
 *
 */
public class Test13 {
    public static boolean judge(int x){
        // 在[2, 根号x]的范围内判断
        for(int i = 2; i*i <= x; ++i){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int x = 100;
        boolean flag = judge(x);
        System.out.println(flag);

    }
}
