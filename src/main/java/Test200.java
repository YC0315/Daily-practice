import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: yangchao
 * @createTime: 2022-08-25  20:31
 * @description: 合并K个升序的链表
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
public class Test200 {
    // 两个两个的合并链表这样时间复杂度比较高
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        // 两个两个的合并链表
        int right = 1;
        ListNode head = new ListNode(0);
        ListNode p = head;
        ListNode l1 = lists[0];
        ListNode l2;
        while (right <= lists.length - 1) {
            l2 = lists[right];
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = l1;
                    p = p.next;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    p = p.next;
                    l2 = l2.next;
                }
            }
            while (l1 != null) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            }
            while (l2 != null) {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
            right++;
            p = head;
            l1 = p.next;
        }
        return head.next;
    }

    // 采用分治的思想，使用归并排序合并链表
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergeTwoList(lists, 0, lists.length - 1);
    }

    public ListNode mergeTwoList(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        int mid = l + (r - l) / 2;
        // 这块先到mid再从mid+1开始
        return merge(mergeTwoList(lists, l, mid), mergeTwoList(lists, mid + 1, r));
    }

    public ListNode merge(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        // 创建链表
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (a != null && b != null) {
            if (a.val < b.val) {
                p.next = a;
                a = a.next;
            } else {
                p.next = b;
                b = b.next;
            }
            p = p.next; // 这句不必写在if  else里面
        }
        p.next = (a != null ? a : b);  // a和b都是链表，因此我们只要连接到他们的头节点即可
        return head.next;
    }

}
