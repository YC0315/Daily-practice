/**
 * 删除排序链表中的重复元素 II：
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 */


public class Test05 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head.next == null) return head;

        // 插入一个指针指向头节点，该指针的值为0
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 当前指针指向dummy节点
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
