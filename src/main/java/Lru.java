import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangchao
 * @createTime: 2022-07-07  08:44
 * @description: LRU缓存
 */
public class Lru {
    class Entry{
        int key;
        int value;
        Entry prve;
        Entry next;

        // 不要忘记提供类构造器
        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
        private int capatity;
        private Map<Integer, Entry> map = new HashMap<>();
        private Entry head;// 头
        private Entry tail; // 尾

        public Entry(int capatity) {
            // 初始化
            this.capatity = capatity;
            head = new Entry(0,0);
            tail = new Entry(0,0);
            head.next = tail;
            tail.prve = head;
        }

        public int get(int key){
            if(map.containsKey(key)){
                Entry entry = map.get(key);
                moveToTail(entry);
                return entry.value;
            }
            return -1;
        }

        public void put(int key, int value){
            if(map.containsKey(key)){
                Entry entry = map.get(key);
                entry.value = value;
                moveToTail(entry);
            }else{
                Entry newEntry = new Entry(key, value);
                if(map.size() >= capatity){
                    Entry entry = removeFirst();
                    map.remove(entry.key);
                }
                addTail(newEntry);
                map.put(key, newEntry);
            }
        }
        // 新增
        private void addTail(Entry entry){
            Entry node = tail.prve;
            node.next = entry;
            entry.prve = node;
            tail.prve = entry;
            entry.next = tail;
        }
        // 删除
        private Entry removeFirst(){
            Entry first = head.next;
            Entry second = first.next;
            head.next = second;
            second.prve = head;
            return first;
        }
        // 移动
        private void moveToTail(Entry entry){
            Entry front = entry.prve;
            Entry back = entry.next;
            front.next = back;
            back.prve = front;
            addTail(entry);
        }

    }
}
