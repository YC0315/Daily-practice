import java.util.Arrays;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-14  21:20
 * @description: 两数相加
 */
public class Test161 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode pre = res;
        int temp = 0;
        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
        while (l1 != null || l2 != null || temp != 0) { // 最后一次进位不要忘记
            // 对齐两个链表，多余部分补0
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int value = val1 + val2 + temp; // temp为上一次的进位值
            temp = value / 10;  // 记录上一次相加，进位的值
            ListNode curr = new ListNode(value % 10); // 取个位
            pre.next = curr;
            pre = curr;

            if(l1 != null) l1 = l1.next;  // 先判空，影响while循环条件
            if(l2 != null) l2 = l2.next;
        }
        return res.next;
    }
}
