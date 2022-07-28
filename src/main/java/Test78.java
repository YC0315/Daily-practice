import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangchao
 * @createTime: 2022-07-21  14:09
 * @description: Lru
 * 具体思路是：
 * hash表存储key和Listnode*，Listnode存储key，value。
 * 调用get(key)函数时，去hash表中查找是否存在key对应的Listnode，如果不存在返回-1；如果存在，则把hash表中存储的Listnode插入到链表头部，并且返回它的value。
 * 调用put(key,value)时，检查该key对应的数字是否已经存在。如果已经存在，则更新其value，然后将该节点移动到链表头部（因为该数字被访问了）。
 * 如果key对应的数字不存在，则在hash表和链表头部插入对应的项目。然后检查是否超出了界限，如果超出了界限，就删除链表尾部的节点，并根据key从hash表中删除该项目。
 */
public class Test78 {
    // 使用hashmap+双链表构建LRU
    private int capabity;
    private Entry head; // 头节点
    private Entry tail; // 尾节点
    private Map<Integer, Entry> map = new HashMap<>();

    public Test78(int capabity) {
        this.capabity = capabity;
        head = new Entry(0, 0);  // 初始化头节点
        tail = new Entry(0, 0);  // 初始化尾节点
        head.next = tail;  // 链接两节点
        tail.prev = head;
    }

    public int get(int key) {  //get方法的参数是key,根据某个key查找value
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            moveToTail(entry);
            return entry.val;
        }
        return -1;
    }

    public void put(int key, int value) {  // put的参数就是一个key, value,传进去之后再封装
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            entry.val = value;
            moveToTail(entry);
        }else{
            if(map.size()>=capabity){
                Entry entry = removeFirst();
                map.remove(entry.key);
            }
            Entry newEntry = new Entry(key, value);
            addToTail(newEntry);
            map.put(key, newEntry);
        }

    }

    // 添加元素到末尾
    public void addToTail(Entry entry) {
        Entry last = tail.prev;
        last.next = entry;
        entry.next = tail;
        entry.prev = last;
        tail.prev = entry;
    }

    // 移动元素到末尾
    public void moveToTail(Entry entry) {
        Entry before = entry.prev;
        Entry after = entry.next;
        before.next = after;
        after.prev = before;
        addToTail(entry);
    }

    // 移除首端元素
    public Entry removeFirst() {
        Entry first = head.next;
        Entry second = first.next;
        head.next = second;
        second.prev = head;
        return first;
    }
}

class Entry {
    // Entry里面存放的是键值对!!
    int key;
    int val;
    Entry prev;
    Entry next;

    public Entry(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
