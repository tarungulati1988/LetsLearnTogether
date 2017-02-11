/**
 * Created by tgulati on 2/6/17.
 */
public class BuildTreeFromInorderPostOrder {

    public static void main(String[] args) {

        int[] inorder = new int[]{4, 2, 5, 1, 6, 7, 3, 8};
        int[] postorder = new int[]{4, 5, 2, 6, 7, 8, 3, 1};

        Node root = buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
    }

    private static Node buildTree(int[] inorder, int[] postorder, int si, int ei, int sp, int ep) {
        if (si >= ei || sp >= ep) {
            return null;
        }

        Node root = new Node(postorder[ep]);
        int k = 0;

        for(int i = 0; i < ei; i++) {
            if(postorder[ep] == inorder[i]) {
                k = i;
                break;
            }
        }

        root.left = buildTree(inorder, postorder, si, k-1, sp, sp + k - si - 1);
        root.right = buildTree(inorder, postorder, k + 1, ei, sp + k -si, ep-1);

        return root;

    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
