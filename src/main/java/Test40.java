/**
 * @author: yangchao
 * @createTime: 2022-07-08  20:32
 * @description: 链表排序
 *      主要考察3个知识点，
 *      知识点1：归并排序的整体思想
 *      知识点2：找到一个链表的中间节点的方法
 *      知识点3：合并两个已排好序的链表为一个新的有序链表
 */
public class Test40 {
    class ListNode {
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

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    // 对链表进行归并排序，其实就是找到中间节点，然后不断分成左右两部分，最后在合并左右链表
    private ListNode mergeSort(ListNode head) {
        // 当链表为空或者链表只包含1个节点时，不需要对链表进行拆分和排序，直接返回该节点
        if(head == null || head.next == null){
            return head;
        }
        // 快慢指针找到链表的中间节点
        ListNode low = head, fast = head;
        ListNode prev = null; // 记录左边链表的最后一个节点
        while(fast != null && fast.next != null){
            prev = low;
            low = low.next;
            fast = fast.next.next;
        }
        // 退出while循环后，low就是中间节点了
        // 设置左链表末尾，末尾节点的next=null，因为后面要分两个链表
        prev.next = null;

        // 对左边链表进行排序，使用递归
        ListNode left = mergeSort(head);
        //对右边链表进行排序，使用递归
        ListNode right = mergeSort(low);

        // 合并左右两个链表
        return mergeList(left, right);
    }

    // 合并左右链表
    private ListNode mergeList(ListNode left, ListNode right) {
        // 临时头节点
        ListNode temp = new ListNode(-1);
        ListNode p = temp;
        // 左链表和右链表比较的长度要一样
        while(left != null && right != null){
            if(left.val < right.val){
                p.next = left;
                left = left.next;
            }else{
                p.next = right;
                right = right.next;
            }
            // p向后移动一位
            p = p.next;
        }
        // 将左边或者右边剩余链表接到p节点的后面
        p.next = left == null ? right:left;
        return temp.next;
    }
}
