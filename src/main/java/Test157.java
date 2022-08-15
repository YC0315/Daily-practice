import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-08-13  21:23
 * @description: 链表翻转ACM模式
 */
public class Test157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();  // next()读取到空格或者回车才会停止
        String[] arr = str.split(",");
        // 初始化一个整数数组，赋值
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);  // 将String类型转换成int类型
        }
        // 初始化链表
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int j = 0; j < nums.length; j++) {
            ListNode node = new ListNode(nums[j]);
            p.next = node;
            p = p.next;
        }
        head = head.next;

        // 翻转链表
        ListNode dummy= null;
        while(head != null){
            ListNode curr = head.next;
            head.next = dummy;
            dummy = head;
            head = curr;
        }
        //return dummy;
        while(dummy != null){
            System.out.print(dummy.val+",");
            dummy = dummy.next;
            if(dummy == null){
                break;
            }
        }
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
