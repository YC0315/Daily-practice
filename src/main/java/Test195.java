import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-08-24  08:24
 * @description: ACM模式 K个一组翻转链表
 */
public class Test195 {
    public static void main(String[] args) {
        // 自己处理输入输出
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();  // k个一组翻转链表
        sc.nextLine(); // 去除回车符
        // 输入为一个逗号隔开的字符串
        String[] strings = sc.nextLine().split(",");
        int[] ints = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        // 构建一个链表
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int value : ints) {
            p.next = new ListNode(value);  // 这里要构建每一个节点，new并不是直接赋值
            p = p.next;
        }
        head = head.next;
        // 翻转链表
        ListNode node = reverseListNode(head, k);
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

    public static ListNode reverseListNode(ListNode head, int k) {
        // 寻找到下一段待翻转的链表的起点
        ListNode post = head;
        for (int i = 0; i < k; i++) {
            if(post == null) return head; // 如果链表长度小于k，则返回链表的首节点
            post = post.next;   // post指向下一段列表的起始节点
        }
        // 翻转上一组链表,和原地翻转链表的做法是一样的
        ListNode pre = null;
        ListNode curr = head;
        while(curr != post){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        head.next = reverseListNode(curr, k);  // 上一段的尾结点指向下一段的首节点
        return pre;   // 返回第一段的首节点
    }


}
