/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 */
public class Test20 {
    public static int divide(int dividend, int divisor) {
        int res = 0;
        int temp = 1;
        if(dividend == 0){
            return 0;
        }
        if((dividend >0 && divisor <0) || (dividend <0 && divisor >0)){
            temp = -1;
        }
        dividend = (int)Math.abs(dividend== -2147483648?-2147483648L:dividend);
        divisor = Math.abs(divisor);
        while(dividend >= divisor){
            res++;
            dividend = dividend - divisor;
        }
        return (((int)res * temp)>=-Math.pow(2,31) && ((int)res * temp)<=Math.pow(2,31)-1)? ((int)res * temp): (int)Math.pow(2,31)-1;
    }

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = -1;
        int divide = divide(dividend, divisor);
        System.out.println(divide);


    }
}
