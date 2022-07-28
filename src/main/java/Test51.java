/**
 * @author: yangchao
 * @createTime: 2022-07-13  08:08
 * @description: 反转链表
 */
public class Test51 {
    public ListNode revreseList(ListNode head){
        // 哑节点
        ListNode dummy = null;
        while(head != null){
            ListNode curr = head.next;
            head.next = dummy;
            dummy = head;
            head = curr;
        }
        return dummy;
    }

    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
