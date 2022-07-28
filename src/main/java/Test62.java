/**
 * @author: yangchao
 * @createTime: 2022-07-17  20:06
 * @description: 链表排序（使用归并排序，借助归并排序的思想）
 */
public class Test62 {
    public ListNode sortList(ListNode head) {
        // 当链表为空或者链表只有一个节点时，不进行拆分，直接返回
        if(head == null || head.next == null) return head;
        // 使用快慢指针找到中间节点
        ListNode fast = head;
        ListNode low = head;
        ListNode prev = head;  // 这里要借助一个指针将做链表的末尾置成null
        while(fast != null && fast.next != null){
            prev = low;
            fast = fast.next.next;
            low = low.next;
        }
        // 将左链表的节点末尾设置为空
        prev.next  = null;
        ListNode left = sortList(head);  // 递归拆分做链表
        ListNode right = sortList(low);  // 递归拆分右链表
        return merge(left, right);

    }

    private ListNode merge(ListNode left, ListNode right) {
        // 新建一个节点用来保存新的合并后的链表
        ListNode root = new ListNode(0);
        ListNode curr = root;
        while(left != null && right != null){  // 只要有一端链表为空，则直接退出
            if(left.val <= right.val){
                curr.next = left;
                left = left.next;
            }else{
                curr.next =right;
                right = right.next;
            }
            curr = curr.next;  // 在此处移动新链表节点
        }
        if(left != null){
            curr.next = left;
        }
        if(right != null){
            curr.next = right;
        }
        return root.next;  // 返回哑节点的下一个节点

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
