
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangchao
 * @createTime: 2022-07-17  19:03
 * @description:  LRU缓存
 */
public class LRU_cache {
    private int capcity;
    private Entry head;
    private Entry tail;
    private Map<Integer, Entry> map = new HashMap<>();

    public LRU_cache(int capcity) {
        this.capcity = capcity;
        head = new Entry(0, 0);
        tail = new Entry(0, 0);
        // 将首和尾连接起来！！
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int val){
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            entry.val = val;
            moveToTail(entry);
        }else{
            Entry newEntry = new Entry(key, val);
            if(map.size() >= capcity){
                Entry entry = removeHead();
                map.remove(entry.key);
            }
            addToTail(newEntry);
            map.put(key, newEntry);
        }
    }
    public int get(int key){
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            moveToTail(entry);
            return entry.val;
        }
        return -1;
    }

    // 新增元素到链表末尾
    private void addToTail(Entry entry){
        Entry last = tail.prev;
        last.next = entry;
        entry.prev = last;
        tail.prev = entry;
        entry.next = tail;
    }
    // 移动节点到末尾
    private void moveToTail(Entry entry){
        Entry before = entry.prev;
        Entry after = entry.next;
        before.next = after;
        after.prev = before;
        addToTail(entry);
    }

    // 移除首端元素
    private Entry removeHead(){
        Entry first = head.next;
        Entry second = first.next;
        head.next = second;
        second.prev = head;
        return first;
    }

    // 双向链表节点
    class Entry{
        int key;
        int val;
        Entry prev;
        Entry next;
        private Entry(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}
