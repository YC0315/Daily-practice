/**
 * @author: yangchao
 * @createTime: 2022-08-05  21:16
 * @description: 判断链表是否有环,分奇数偶数个节点，画画图，找到循环结束条件！！
 */
public class Test123 {
    // 使用快慢指针
    public boolean hasCycle(ListNode head) {
        // 都从头节点开始走
        ListNode slow = head;
        ListNode fast = head;
        // 假设链表无环，如果链表共奇数个节点，则不满足fast->next != NULL而结束循环
        //              如果链表共偶数个节点，则不满足fast != NULL而结束循环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}

/*class ListNode {
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
}*/
