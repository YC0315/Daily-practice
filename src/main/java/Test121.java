import java.util.HashSet;
import java.util.Set;
/**
 * @author: yangchao
 * @createTime: 2022-08-05  19:27
 * @description: 链表中环的入口节点
 */
public class Test121 {
    // 使用哈希表，时间和空间复杂度都是O(n)
    private ListNode detectCycle(ListNode head) {
        // 使用Set集合记录当前节点有没有遍历过，如果遍历过则为循环链表头节点！！！
        ListNode temp = head;
        ListNode res = null;
        Set<ListNode> map = new HashSet<>();
        while(temp != null){
            if(map.contains(temp)){
                res = temp;
                break;
            }
            map.add(temp);
            temp = temp.next;
        }
        return res;
    }
}



