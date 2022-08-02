/**
 * @author: yangchao
 * @createTime: 2022-08-01  19:05
 * @description: 数组实现队列
 */
public class Test113 {
    /*
    队列尾进头出，因此我们需要定义两个变量，相当于指针，分别指向队列的头部和尾部。
    定义一个数组，用来储存元素。我用front来表示头指针，但是指向的是队列头元素的前一个位置；
    用rear来表示尾指针，指向的是队列的尾元素,最后一个元素。
    并且将front和rear都赋值为-1。当头尾指针相等，指向同一块空间，即当rear == front时，队列为空。
    **/
    private int[] arr;
    private int head;  // 头指针
    private int tail;  // 尾指针

    public Test113(int capacity) {
        // 构造方法，传入数组容量，初始化头节点和尾节点在同一个位置
        arr = new int[capacity];
        head = -1;
        tail = -1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return head == tail;
    }

    // 判断队列是否已满
    public boolean isFull() {
        // 当尾指针指向数组的最后一个元素时，数组已满
        return tail == arr.length - 1;
    }

    public void add(int x) {
        // 插入元素时先判断队列是否已满
        if (isFull()) {
            // 队列满了，每次扩容两倍
            int[] brr = new int[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                brr[i] = arr[i];
            }
            arr = brr;
        }
        // 尾指针加一，将元素放入尾指针的位置
        tail++;
        arr[tail] = x;
    }

    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        head++;
        return arr[head];
    }

    public int getFrond() {
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

    // 打印队列元素
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        // 打印队列元素值
        for (int i = head + 1; i <= tail; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public static void main(String[] args) {
        // 检验队列是否是先进先出
        Test113 t = new Test113(5);
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);
        t.add(6);
        System.out.println("出队元素为:" + t.poll());
        System.out.println("出队元素为:" + t.poll());
        System.out.println("出队元素为:" + t.poll());
        System.out.println("出队元素为:" + t.poll());
        System.out.println("出队元素为:" + t.poll());
        System.out.println("出队元素为:" + t.poll());
    }
}
