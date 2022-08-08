/**
 * @author: yangchao
 * @createTime: 2022-08-06  08:18
 * @description: 判断链表是否有环,分奇数个节点和偶数个节点，确定while循环的结束条件
 */
public class Test124 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
