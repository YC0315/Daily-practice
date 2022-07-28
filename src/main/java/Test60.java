/**
 * @author: yangchao
 * @createTime: 2022-07-15  21:14
 * @description: 给你一个链表的头节点 head ，判断链表中是否有环。
 */
public class Test60 {
    public boolean hasCycle(ListNode head) {
        // 使用快慢指针，如果指针相遇则存在环，则两指针一定会相遇!
        if(head == null || head.next == null) return false;
        ListNode fastPtr = head;
        ListNode lowPtr = head;
        while(fastPtr != null && fastPtr.next != null){  // 只要快指针还没跑到头就一直跑
            lowPtr = lowPtr.next;
            fastPtr = fastPtr.next.next;
            if(fastPtr == lowPtr) {
                return true;
            }
        }
        return false;  // 快指针跑得快，假如快指针跑到头都还没遇到慢指针
    }
}
