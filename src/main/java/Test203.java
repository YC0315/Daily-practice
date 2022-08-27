/**
 * @author: yangchao
 * @createTime: 2022-08-27  08:57
 * @description: 合并k个升序的链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class Test203 {
    // 合并链表使用归并排序
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergeKList(lists, 0, lists.length - 1);
    }

    public ListNode mergeKList(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];

        int mid = l + (r - l) / 2;
        return merge(mergeKList(lists, l, mid), mergeKList(lists, mid + 1, r));
    }

    public ListNode merge(ListNode a, ListNode b) {
        // 先判断a,b是否为空
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        // 合并两个链表
        while (a != null && b != null) {
            if (a.val < b.val) {
                p.next = a;
                a = a.next;
            } else {
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }
        p.next = (a != null ? a : b);
        return head.next;
    }

}
