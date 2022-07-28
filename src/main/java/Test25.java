/**
 * @author: yangchao
 * @createTime: 2022-06-26  19:40
 * @description: 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 */
public class Test25 {
    public static void main(String[] args) {
    }
    /**
     * @description: 首先连成循环链表，然后移动尾节点找到新的尾节点
     * @author: yangchao
     * @date: 2022/6/26 20:44
     * @param: [head, k]
     * @return: ListNode
     **/
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        int count = 1;
        int temp = 0;
        ListNode node = head;
        while(node.next != null){
            node = node.next;
            count++;
        }
        node.next =head;
        for(int i = 0; i < count-(k % count); i++){
            node = node.next;
        }
        ListNode node1 = node.next;
        node.next = null;
        return node1;
    }

}
