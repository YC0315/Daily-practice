import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangchao
 * @createTime: 2022-08-10  08:24
 * @description: LRU缓存，基于哈希表和双向链表实现
 */
public class lCache {
    private int capatity;
    private Entrys head;
    private Entrys tail;
    private Map<Integer, Entrys> map;

    public lCache(int capatity) {
        this.capatity = capatity;
        head = new Entrys(0, 0);
        tail = new Entrys(0, 0);
        map = new HashMap<>();
        head.next = tail;   // 初始化时不要忘记将首尾节点连接起来
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Entrys entrys = map.get(key);
            moveToTail(entrys);
            return entrys.val;
        }
        return -1;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            Entrys entrys = map.get(key);
            entrys.val = val;
            moveToTail(entrys);
        } else {
            // 容量校验
            if (map.size() >= capatity) {
                Entrys entrys = removeHead();
                map.remove(entrys.key);
            }
            Entrys entrys = new Entrys(key, val);
            insertToTail(entrys);
            map.put(key, entrys);

        }
    }

    // 插入节点到尾端
    public void insertToTail(Entrys entrys) {
        Entrys last = tail.prev;
        last.next = entrys;
        entrys.prev = last;
        last.next = tail;
        tail.prev = entrys;
    }

    // 移动节点到尾端
    public void moveToTail(Entrys entrys) {
        Entrys before = entrys.prev;
        Entrys after = entrys.next;
        before.next = after;
        after.prev = before;
        insertToTail(entrys);
    }

    // 移除首端元素
    public Entrys removeHead() {
        Entrys first = head.next;
        Entrys second = first.next;
        head.next = second;
        second.prev = head;
        return first;
    }

}

class Entrys {
    int key;
    int val;
    Entrys prev;
    Entrys next;

    public Entrys(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
