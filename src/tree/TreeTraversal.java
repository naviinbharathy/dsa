package tree;

public class TreeTraversal {

    // left, root, right
    public void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    // root, left, right
    public void preOrder(TreeNode root) {
        if(root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // left, right, root
    public void postOrder(TreeNode root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {

        TreeTraversal tree = new TreeTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("IN ORDER");
        tree.inOrder(root);

        System.out.println();
        System.out.println("PRE ORDER");
        tree.preOrder(root);

        System.out.println();
        System.out.println("POST ORDER");
        tree.postOrder(root);
    }
}
