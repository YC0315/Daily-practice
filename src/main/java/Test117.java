
/**
 * @author: yangchao
 * @createTime: 2022-08-02  20:36
 * @description: 以h为根的二叉树的结点间最大距离的可能情况：
 * 1：为左子树的结点间最大距离；
 * 2：为右子树的结点间最大距离；
 * 3：为经过h的左子树最深叶结点到右子树最深叶结点的路径长，亦即：h的左子树最大深度+h的右子树最大深度+1。
 * 采用后序遍历的方式：对当前结点h，先获取左子树结点间最大距离以及左子树最大深度，
 * 再获取右子树结点间最大距离以及右子树深度，最后统计出h的结点间最大距离以及h的最大深度并返回上层。
 * 递归获取两个值：一个是子树的最大深度，一个是子树的结点间最大距离。其中，子树最大深度通过一个数组传引用的方
 * 式获取结果；子树的最大结点间距离则由递归函数的返回值返回.
 */
public class Test117 {
    // 二叉树上最远节点的距离
    // 左子树上的最远距离，右子树上的最远距离，左子树最远距离加右子树最远距离+1的距离，从这三者里选
    public int maxDistance(Node head) {
        int[] record = new int[1];
        return posOrder(head, record);
    }
    private int posOrder(Node head, int[] record) {
        if (head == null) {
            record[0] = 0;
            return 0;
        }
        //递归左子树获取左子树最大结点距离
        int lMax = posOrder(head.left, record);
        int maxFromLeft = record[0]; // 获取左子树递归过程中统计出的子树深度
        int rMax = posOrder(head.right, record); // 递归右子树获取右子树最大结点距离
        int maxFromRight = record[0]; // 获右子树递归过程中统计出的子树深度
        int curNodeMax = maxFromLeft + maxFromRight + 1;  // 记录跨越头节点的最大深度
        record[0] = Math.max(maxFromLeft, maxFromRight) + 1;  // 记录当前最深结点的高度
        return Math.max(Math.max(lMax, rMax), curNodeMax);  // 返回左子树右子树或者左右子树和的最大深度
    }

    public static void main(String[] args) {
        Test117 maxDistanceOfBinaryTreeNodes = new Test117();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node7;
        node4.left = node5;
        node5.left = node6;
        System.out.printf("The max distance is: %d", maxDistanceOfBinaryTreeNodes.maxDistance(node1));
    }

}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int data) {
        this.value = data;
    }
}
