import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangchao
 * @createTime: 2022-07-13  08:24
 * @description: LRU
 */
public class Test53 {
    private int capabity;
    Map<Integer, Entry> map = new HashMap<>();
    private Entry head;  // 头节点，存放最老的数据
    private Entry tail;  // 尾节点，存放最新的数据

    // 构造方法,缓存初始化
    public Test53(int capabity) {
        this.capabity = capabity;
        head = new Entry(0, 0);
        tail = new Entry(0, 0);
        head.next = tail;
        tail.prve = head;
    }

    // put
    public void put(int key, int val){
        if(map.get(key) != null){
            Entry entry = map.get(key);
            entry.val = val;
            moveToTail(entry);
        }else{
            if(map.size() >= capabity){
                Entry entry = moveFirst();
                map.remove(entry.key);
            }
            Entry newEntry = new Entry(key, val);
            addToTail(newEntry);
            map.put(key, newEntry);
        }
    }

    // get
    public int get(int key){
        if(map.get(key) != null){
            Entry entry = map.get(key);
            moveToTail(entry);
            return entry.val;
        }
        return -1;
    }

    // 新增节点到尾部
    public void addToTail(Entry entry){
        Entry last = tail.prve;
        last.next = entry;
        entry.next = tail;
        entry.prve = last;
        tail.prve = entry;

    }
    // 移动节点到尾部
    public void moveToTail(Entry entry){
        Entry before = entry.prve;
        Entry after = entry.next;
        before.next = after;
        after.prve = before;
        addToTail(entry);
    }

    // 移除首节点
    public Entry moveFirst(){
        Entry first = head.next;
        Entry second = first.next;
        head.next = second;
        second.prve = head;
        return first;
    }


    class Entry{
        int key;
        int val;
        Entry prve; // 前驱节点
        Entry next; // 后继节点

        public Entry(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
