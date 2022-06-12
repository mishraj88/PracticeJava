package algos;

//import java.time.chrono.ThaiBuddhistChronology;
import java.util.Optional;

public class BinaryTree {

    static class Node {
        int data;
        
        Node left, right;

        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }

        Node getLeftChild (){
            return this.left;
        }
        Node getRightChild(){
            return this.right;
        }
        int getData(){
            return this.data;
        }

    }

    class TreeInfo{
        int height;
        int diameter;

        TreeInfo(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right= new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        //root.right.left = new Node(null);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);

       // inorderTraversal(root);
       //postOrderTraversal(root);
       //preOrderTraversal(root);

        int sum = sumOfNodes(root);
        System.out.println("Sum of all nodes in the given tree with root : "+root.data+ " = "+sum);

        int height = heightOfTree(root);
        System.out.println("Height = "+height);

        int diameter = diameterOfTree(root);
        System.out.println("diameter : "+diameter);
        //TreeInfo info =  diamterFromTreeInfo(root);


    }

    private static TreeInfo diamterFromTreeInfo(Node root) {
        if(root == null) return null;
        
        return null;
    }

    private static int diameterOfTree(Node root) {
        //diameter = maximum nodes in any path in a tree
        //diameter could solely be in left subtree
        //or could soleley be in right subtree
        //or could pass through root from left to right including 
        //left height node or right height node
        if(root == null) return 0;
        int diaLeft = diameterOfTree(root.left);
        int diaright = diameterOfTree(root.right);
        int diaThroughRoot = 1 + heightOfTree(root.left) + heightOfTree(root.right);
        int diameterFinal = Math.max(Math.max(diaLeft, diaright), diaThroughRoot);
        return diameterFinal;
    }

    private static int heightOfTree(Node root) {
       if(root == null) return 0;
       int leftSubtreeHeight = heightOfTree(root.left);
       int rightSubTreeHeight = heightOfTree(root.right);
       return 1 + Math.max(leftSubtreeHeight, rightSubTreeHeight);
    }

    private static int sumOfNodes(Node root) {
        if(root == null) return 0;
        return root.data + sumOfNodes(root.left)+sumOfNodes(root.right);
    }

    private static void preOrderTraversal(Node root) {
        if(root == null) return;
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void postOrderTraversal(Node root) {
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }

    private static void inorderTraversal(Node root) {

        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);
    }
    
}
