package trees;

import trees.common.Node;

/**
 * Created by AKRITI on 4/17/2019.
 */
public class MaxPathTreeTrav {

    class Maximum{
        int max_sum=0;
    }

    Node root = null;
    Node maxLeafNode;
    Maximum maximum = new Maximum();


    /**
     * Print the path from the root till the max leaf node recursively
     * Complexity would be O(n)
     */
    public boolean printPath(Node root, Node maxLeafNode){
        if(root==null){
            return false;
        }

        if(root.data==maxLeafNode.data || printPath(root.left,maxLeafNode) || printPath(root.right,maxLeafNode)){
            System.out.println(root.data + " ");
            return true;
        }

        return false;

    }

    /**
     * Find the leaf node in the max sum path and populate in maxLeafNode variable
     * @param root
     */
    public void findLeafNodeInMaxPath(Node root,Maximum maxSum , int currSum){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            currSum = currSum+ root.data;
            if(maxSum.max_sum<currSum){
                maxSum.max_sum=currSum;
                maxLeafNode=root;
            }
        }else {
            currSum = currSum + root.data;
        }

        findLeafNodeInMaxPath(root.left,maximum,currSum);
        findLeafNodeInMaxPath(root.right,maximum,currSum);

    }

    public int findMaxSumPathFromRoot(Node root){

        if(root==null){
            return maximum.max_sum;
        }

        findLeafNodeInMaxPath(root,maximum,0);
        printPath(root,maxLeafNode);

        return maximum.max_sum;
    }

    public static void main(String[] args){
        MaxPathTreeTrav maxPathTreeTrav = new MaxPathTreeTrav();

        maxPathTreeTrav.root = new Node(10);
        maxPathTreeTrav.root.left = new Node(-2);
        maxPathTreeTrav.root.right= new Node(7);
        maxPathTreeTrav.root.left.left= new Node(8);
        maxPathTreeTrav.root.left.right= new Node(-4);

        System.out.println("Sum of node weight for maximum path from root till leaf node : "
                + maxPathTreeTrav.findMaxSumPathFromRoot(maxPathTreeTrav.root));

    }

}
