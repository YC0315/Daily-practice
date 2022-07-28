/**
 * @author: yangchao
 * @createTime: 2022-07-06  19:36
 * @description: 反转链表
 */
public class Test39 {
    public ListNode reverseList(ListNode head) {
        // 要借助一个中间节点实现指针后移
        ListNode curr = head; // 当前节点
        ListNode dummy = null;  // 头节点
        while (curr != null) {
            // 中间节点记住要后移到的节点
            ListNode temp = curr.next;
            curr.next = dummy;
            dummy = curr;
            curr = temp;
        }
        return dummy;
    }

    public class ListNode {
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
}
