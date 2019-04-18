package trees;

import java.util.Arrays;

/**
 * Input is pre order traversal
 * Output should be post order traversal of the binary search tree
 * Created by AKRITI on 2/2/2019.
 */
public class BstPreTrav {


    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static void main(String[] args){
        //pre order traversal
        int[] arr = new int[]{10,5,1,7,40,50};
        Node tree = new BstPreTrav().bst(arr,0,5,6);
        new BstPreTrav().postorder(tree);

    }
    public Node bst(int[] preorder,int start,int end, int size ){
        if(start>end || start>=size){
            return null;
        }
        Node root = new Node(preorder[start]);

        if(start==end){
            return root;
        }
        int i;
        for(i=start;i<=end;++i){
            if(preorder[i]>root.data){
                break;
            }
        }
        root.left=bst(preorder,start+1,i-1,size);
        root.right=bst(preorder,i,end,size);
        return root;
    }
    public void postorder(Node tree){
       if(tree==null){
           return;
       }
        postorder(tree.left);
        postorder(tree.right);
        System.out.print(tree.data + " ");
    }
}
