/**
 * Created by tgulati on 2/6/17.
 */
public class BuildTreeFromInorderPreorder {



    public static void main(String[] args) {

        int[] inorder = new int[]{4, 2, 5, 1, 6, 7, 3, 8};
        int[] preorder = new int[]{1, 2, 4, 5, 3, 7, 6, 8};

        Node root = buildTree(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
    }

    private static Node buildTree(int[] inorder, int[] preorder, int si, int ei, int sp, int ep) {
        if (si >= ei || sp >= ep) {
            return null;
        }

        Node root = new Node(preorder[sp]);
        int k = 0;

        for(int i = 0; i < ei; i++) {
            if(preorder[sp] == inorder[i]) {
                k = i;
                break;
            }
        }

        root.left = buildTree(inorder, preorder, si, k-1, sp+1, sp + k - si);
        root.right = buildTree(inorder, preorder, k + 1, ei, sp + k - si + 1, ep);

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
