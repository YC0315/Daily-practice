import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-08-23  15:47
 * @description: 环形链表||: 返回进入环形链表的第一个节点
 */
public class Test194 {
    // 使用哈希表时间复杂度和空间复杂度都是O(n)
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while(curr != null && !set.contains(curr)){
            set.add(curr);
            curr = curr.next;
        }
        return curr;
    }

    // 使用双指针借助数学推导将时间复杂度降到O(1)
    public ListNode detectCycle1(ListNode head) {
        ListNode fast = head, slow = head;
        // 寻找第一次相遇点，找到后将fast重置成head然后每次和slow都走一步，第二次相遇时为入口节点
        while(true){
            if(fast == null || fast.next == null){
                return null; // 没有环，返回null
            }
            fast = fast.next.next;
            slow = slow.next;
            // 第一次相遇，结束循环，将fast重置成head
            if(fast == slow){
                break;
            }
        }
        fast = head;
        // 第二次相遇时就是环的入口
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
