import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author: yangchao
 * @createTime: 2022-08-14  14:52
 * @description: 链表每K个一组翻转
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 使用ACM模式
 */
public class Test159 {
    public static void main(String[] args) {
        // acm格式输入输出
        /*
           输入：1,2,3,4,5
                 3
         **/
        Scanner sc = new Scanner(System.in);
        String[] string = sc.next().split(",");

        /*int[] arr = new int[string.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(string[i]);
        }*/

        // Stream流将String类型的数字集合转成Integer类型数字集合,代替上述for循环
        // Integer::parseInt为方法引用，stream流中的每一个元素都会被该类中的该方法所处理
        int[] arr = Arrays.stream(string).mapToInt(Integer::parseInt).toArray();
        int k = sc.nextInt();
        // 初始化链表
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int j = 0; j < arr.length; j++) {
            p.next = new ListNode(arr[j]);
            p = p.next;
        }
        head = head.next;
        ListNode res = reversekGroup(head, k);
        // 输出链表
        while(res != null){
            if(res.next != null) {
                System.out.print(res.val + ",");
            }else{
                System.out.print(res.val);
            }
            res = res.next;
        }

    }
    // 返回的结果为头结点，这里可以使用分解-递归-合并
    public static ListNode reversekGroup(ListNode head, int k) {
        ListNode post = head;
        // 寻找下一个K组链表节点的起始位置
        for (int i = 0; i < k; i++) {
            // 假如链表长度不足K则不进行翻转
            if(post == null) return head;
            post = post.next;
        }
        // 翻转链表
        ListNode pre = null;
        ListNode cur = head;
        while(cur != post){ // 只翻转当前链表
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // 链接到下一个K组链表的头结点
        head.next = reversekGroup(cur, k);
        return pre; // pre是当前链表的头结点
    }
}
