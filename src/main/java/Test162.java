import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-08-15  08:14
 * @description: ACM模式每k个一组翻转链表
 */
public class Test162 {
    // 自己处理输入输出
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.next().split(",");
        int k = sc.nextInt();
        int[] nums = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        // 初始化链表
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        head = head.next;
        ListNode node = reversekGroup(head, k);
        // 输出链表
        while(node != null){
            if(node.next != null){
                System.out.print(node.val + ",");
            }else{
                System.out.print(node.val);
            }
            node = node.next;
        }
    }

    public static ListNode reversekGroup(ListNode head, int k) {
        // k个一组反转链表
        ListNode post = head;
        for (int j = 0; j < k; j++) {
            if(post == null) return head; // 假如链表长度小于k则不翻转，返回首节点
            post = post.next;  // 找到下一个链表的首节点
        }
        // 翻转链表
        ListNode pre= null;
        ListNode curr = head;
        while(curr != post){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        head.next = reversekGroup(curr, k);
        return pre;
    }
}
