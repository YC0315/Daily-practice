/**
 * @author: yangchao
 * @createTime: 2022-08-02  08:28
 * @description: 数组实现队列
 */
public class myDueue {
    private int[] arr;
    private int head;  // 一开始头指针和尾指针指向相同位置，head始终指向队首的前一个元素
    private int tail;  // 添加元素后，尾指针指向最后一个元素

    // 初始化
    public myDueue(int capacity) {
        arr = new int[capacity];
        head = -1;
        tail = -1;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return tail == arr.length - 1;
    }

    public void insert(int x) {
        if (isFull()) {
            int[] brr = new int[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                brr[i] = arr[i];
            }
            arr = brr;
        }
        tail++;
        arr[tail] = x;
    }

    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        head++;
        return arr[head];  // 并没有真实删掉
    }

    public int getFront() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        head++;
        return arr[head];
    }

    public int getTail() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[tail];
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = head + 1; i <= tail; i++) {
            sb.append(arr[i]);
            if (i != tail) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public static void main(String[] args) {
        myDueue deque = new myDueue(5);
        deque.insert(1);
        deque.insert(2);
        deque.insert(3);
        deque.insert(4);
        deque.insert(5);
        System.out.println("出队元素：" + deque.poll());
        System.out.println("出队元素：" + deque.poll());
        System.out.println("出队元素：" + deque.poll());
        System.out.println(deque.print());
    }
}
