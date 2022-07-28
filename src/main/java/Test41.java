/**
 * @author: yangchao
 * @createTime: 2022-07-09  11:12
 * @description: 对链表进行插入排序,做链表的题，大多数都需要三个指针！！！
 */
public class Test41 {

    // 对于单向链表而言，只有指向后一个节点的指针，因此需要从链表的头节点开始往后遍历链表中的节点，寻找插入位置
    // 需要有两个指针一个指向当前位置，一个指向起始位置用于排序
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head; // 前向指针
        while(head != null && head.next != null){
            if(head.next.val >= head.val){
                head = head.next;
                continue;
            }

            // 每一次都依次与起始节点相比较
            ListNode temp = dummy;  // 需要另外一个指针每次从表头循环，这里用的是temp表头指针
            while(temp.next.val < head.next.val){
                temp = temp.next;
            }
            ListNode curr = head.next;
            head.next = curr.next;
            curr.next = temp.next;
            temp.next = curr;
        }
        return dummy.next;
    }


    // 插入排序方法

    // 节点类
    class ListNode{
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
