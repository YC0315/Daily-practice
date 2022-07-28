import java.util.*;

/**
 * 树的先序遍历，中序遍历，后序遍历
 * 可以使用递归方式也可以使用迭代方式
 */
public class TraverseTrees {
    // 树的先序遍历
    public static void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }


    // 树的中序遍历
    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);  // 将值添加到列表中
        inorder(root.right, list);
    }

    // 树的后序遍历
    public static void afterorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        afterorder(root.left, list);
        afterorder(root.right, list);
        list.add(root.val);
    }

    // 以上为递归方式，下面使用迭代方式
    // 递归函数我们也可以用迭代的方式实现，两种方式是等价的，
    // 区别在于递归的时候隐式地维护了一个栈，而我们在迭代的时候需要显式地将这个栈模拟出来
    //以树的中序遍历举例
    public static List<Integer> midorder01(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 显式的维护一个栈用于存放节点,而在栈的使用场景下，无疑具有尾结点，不需判空的LinkedList更为高效。
        // 栈可以保存一组元素，但是存取元素必须遵循先进后出原则。通常使用栈结构完成"后退"这样的功能使用。
        // Deque双端队列如果从同一侧做出入队操作就实现了栈结构，因此Deque也为栈提供它出入栈的经典方法:push,pop
        // Deque双端队列，Queue单端队列，Deque是Queue的子接口
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            // 一直先把最左边元素加进去
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            // 最后加入右边元素，每次弹出左边元素时检查其右边子元素的是否为空
            root = root.right;
        }
        return res;
    }

    // 递归方法效率低，迭代方法效率高但是难记，提供一种优化方法，称为颜色标记法

    /**
     * 使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
     * 如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。
     * 如果遇到的节点为灰色，则将节点的值输出。
     */
    // 内部类必须为静态内部类，因为没有外部类的实例
    static class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node, String color) {
            this.node = node;
            this.color = color;
        }
    }

    // 用颜色标记法实现中序遍历
    public static List<Integer> colorInorder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 存放最终结果
        List<Integer> list = new ArrayList<>();
        // 维护一个栈实现中序遍历,里面存放的是[(node, color)],
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "white"));
        while (!stack.empty()) {
            ColorNode node = stack.pop();
            // 假如是新节点，也就是其子节点没有访问过，没有入栈
            // 比较两个对象的内容是否相等使用equals()
            if ("white".equals(node.color)) {
                // 因为中序遍历结果是左中右，因此入栈顺序为右中左
                if (node.node.right != null) {
                    stack.push(new ColorNode(node.node.right, "white"));
                }
                // 再将中间节点标记为已访问后压入栈
                stack.push(new ColorNode(node.node, "gray"));
                if (node.node.left != null) {
                    stack.push(new ColorNode(node.node.left, "white"));
                }
            } else {
                list.add(node.node.val);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        // 创建一棵树
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        // 指定树上节点间的关系
        root.left = node1;
        root.right = node2;
        root.left.left = node3;


        // 先序遍历
        List<Integer> prelist = new ArrayList<>();
        preorder(root, prelist);
        System.out.println("先序遍历：" + prelist);

        // 递归中序遍历
        List<Integer> midlist = new ArrayList<>();
        inorder(root, midlist);
        System.out.println("递归中序遍历：" + midlist);

        // 迭代中序遍历：显式的维护一个栈，java怎么构造一个栈？？？？？
        List<Integer> list = midorder01(root);
        System.out.println("迭代中序遍历：" + list);

        // 后序遍历
        List<Integer> afterlist = new ArrayList<>();
        afterorder(root, afterlist);
        System.out.println("后序遍历：" + afterlist);

        // 颜色标记的中序遍历
        List<Integer> colorinorder = colorInorder(root);
        System.out.println("颜色标记的中序遍历：" + colorinorder);
    }
}
