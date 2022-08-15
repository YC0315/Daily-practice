/**
 * @author: yangchao
 * @createTime: 2022-08-15  19:17
 * @description: 二叉树任意两节点之间的最大长度/距离,可能过根节点也可能不过根节点
 *
 * 求二叉树中两个节点之间的最大距离（节点之间的距离：这两个节点之间边的个数）；
 *   思路：
 *       对于每个节点，需要2种信息：深度和距离：
 *       过根节点：求出左子树的最大深度，右子树的最大深度；
 *       不过根节点：左子树的最大距离；右子树的最大距离；
 *       max( 左子树的最大距离， 右子树的最大距离，左最大深度+右最大深度+1）
 */
public class Test164 {
    public static Info process(Node head) {
        // 如果是根节点
        if(head == null) return new Info(0,0);
        // 计算左右子树的最大高度和最长距离
        Info left = process(head.left);
        Info right = process(head.right);

        // 计算当前节点的最大高度和最长距离
        // 过根节点求最大高度
        int height = Math.max(left.height, right.height) + 1; // 当前节点的高度
        // 不过根节点求左右子树的最大距离
        int length = Math.max(left.height + right.height + 1, Math.max(left.length, right.length));
        return new Info(height, length);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        head.left = n2;
        head.right = n3;
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n2.left = n4;
        n2.right = n5;
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n5.right = n6;
        n6.right = n7;
        Node n8 = new Node(8);
        n4.left = n8;
        Node n9 = new Node(9);
        n8.left = n9;
        Node n10 = new Node(10);
        n7.right = n10;
        System.out.println(process(head).length);
    }
}
class Info{
    // 左右子树分别最大的高度，用于过根节点计算
    int height;
    // 左右子树上的最长距离，用于不过根节点计算
    int length;
    public Info(int height,int length){
        this.height=height;
        this.length=length;
    }
}




