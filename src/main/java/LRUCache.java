import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author: yangchao
 * @createTime: 2022-07-06  19:34
 * @description: LRU缓存: 最近最少使用缓存
 */
/*
    请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
    实现 LRUCache 类：
        LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
        int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
        void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
        函数 get 和 put 必须以 O(1) 的平均时间复杂度运行

   使用HashMap+双向链表，使get和put的时间复杂度达到O(1)。
   读缓存时从HashMap中查找key，更新缓存时同时更新HashMap和双向链表，双向链表始终按照访问顺序排列。
   具体存放结构：HashMap<key, entry(key, value)>
 **/
public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
    // 缓存容量
    private int capacity;
    // 用于加速随机访问性能的HashMap
    private Map<Integer, Entry> map = new HashMap<>();;
    // 双向链表的头节点，存放访问时间最旧的数据
    private Entry head;
    // 双向链表的尾节点，存放访问时间最新的数据
    private Entry tail;

    public LRUCache(int capacity) {
        // 缓存初始化
        this.capacity = capacity;
        head = new Entry(0, 0);
        tail = new Entry(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * @description: 从缓存中获取key对应的值，未命中返回-1
     * @author: yangchao
     * @date: 2022/7/6 21:08
     **/
    public int get(int key) {
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            // 将该访问的节点放在尾端，标识最新访问元素
            toTail(entry);
            return entry.value;
        }
        return -1;
    }
    /**
     * @description: 向缓存中插入或者更新值
     * @author: yangchao
     * @date: 2022/7/6 21:26
     **/
    public void put(int key, int value) {

        if(map.containsKey(key)){
            Entry entry = map.get(key);
            entry.value = value;
            toTail(entry);
        }else{
            Entry newEntry = new Entry(key, value);
            // 当缓存已满，不仅要删除最后一个Entry，还要把map中映射到该节点的key同时删除，而这个key只能通过Entry得到
            if(map.size() >= capacity){
                Entry first = removeHead();
                map.remove(first.key);
            }
            // 将新节点放在双向链表的尾端，并且map中添加这个key
            addTail(newEntry);
            map.put(key, newEntry);
        }
    }

    // 外部类除了构造方法以及put和get方法外主要有三个方法：添加元素到末端、移动元素到末端、删除首段元素
    // 将新节点放在末端
    private void addTail(Entry entry){
        Entry last = tail.prev;
        last.next = entry;
        entry.prev = last;
        tail.prev = entry;
        entry.next = tail;
    }

    // 当缓存满了，移除首端元素
    private Entry removeHead(){
        Entry first = head.next;
        Entry second = first.next;
        head.next = second;
        second.prev = head;
        return first;
    }

    // 将链表节点移动到末端,末端是最新的访问元素
    private void toTail(Entry entry){
        // 先将待移动的节点拿出来当作一个待插入新节点
        Entry prev = entry.prev;
        Entry next = entry.next;
        prev.next = next;
        next.prev = prev;
        // 调用添加方法，插入到尾端
        addTail(entry);
    }

    // 缓存项的包装类，包含键、值、前驱结点、后继结点
    class Entry{
        int key;
        int value;
        Entry prev; // 前驱节点
        Entry next; // 后继节点

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    // 节点类
    class DoubleNode {
        int val;    // 具体存储的数据
        DoubleNode prev;    // 指向前驱节点的指针
        DoubleNode next;    // 指向后继节点的指针

        public DoubleNode(int val) {
            this.val = val;
        }
    }
    // 双向链表类
    public class DoubleLinkedList {
        // 实际存储元素个数
        int size;
        // 双向链表的头节点
        private DoubleNode firs = new DoubleNode(0);
        // 双向链表的尾节点
        private DoubleNode last;

        // 初始化上面两个节点

        // 新增节点
        public void addFirst(int val) {}
        // 删除节点
        private void deleteNode(DoubleNode node) {}
    }


}
