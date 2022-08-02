import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangchao
 * @createTime: 2022-07-30  08:13
 * @description: LRU缓存
 */
public class CacheLru {
    // 使用HashMap+双向链表来实现LRU缓存
    private Map<Integer, Entry> map = new HashMap<>();
    private int capatiay;
    private Entry head;
    private Entry tail;

    public CacheLru(int capatiay) {
        this.capatiay = capatiay;
        head = new Entry(0, 0);
        tail = new Entry(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // get
    public int get(int key){
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            moveToTail(entry);
            return entry.val;
        }
        return -1;
    }

    // put
    public void put(int key, int value){
        // 检查map中是否包含这个Entry，如果包含直接替换val
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            entry.val = value;
            moveToTail(entry);
        }else{
            // 如果不包含，那么先判断容量是否充足，否则删除首节点
            Entry newEntry = new Entry(key, value);
            if(map.size() >= capatiay){
                Entry entry = removeHead();
                // 别忘了map中的key
                map.remove(entry.key);
            }
            // 容量充足直接插入并且map中包含key
            insert(newEntry);
            map.put(key, newEntry);
        }
    }

    // 新增节点
    public void insert(Entry entry){
        Entry last = tail.prev;
        last.next = entry;
        entry.next = tail;
        tail.prev = entry;
        entry.prev = last;
    }

    // 移动节点到尾部
    public void moveToTail(Entry entry){
        Entry before = entry.prev;
        Entry after = entry.next;
        before.next = after;
        after.prev = before;
        insert(entry);
    }

    // 删除首节点
    public Entry removeHead(){
        Entry first = head.next;
        Entry second = first.next;
        head.next = second;
        second.prev = head;
        return first;
    }
}

/*class EntryList{
    int key;
    int val;
    Entry prev; // 前继节点
    Entry next; // 后继节点

    public EntryList(int key, int val) {
        this.key = key;
        this.val = val;
    }
}*/
