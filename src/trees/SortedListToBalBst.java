package trees;

public class SortedListToBalBst {



    public static void main(String[] args){
        int[] inputArr  = new int[] {1,2,3,4,5,6,7};
        SortedListToBalBst sortedListToBalBst = new SortedListToBalBst();
        trees.common.Node balancedBst = sortedListToBalBst.convertToTree(inputArr,0,6);
        sortedListToBalBst.inorderTrav(balancedBst);
        System.out.println();
        sortedListToBalBst.postorderTrav(balancedBst);
    }

    public trees.common.Node convertToTree(int[] sortedInput, int start, int end){
        if(end<0){
            return null;
        }
        if(start==end){
            return new trees.common.Node(sortedInput[start]);
        }
        int middle = ((end-start)/2) + start;

        trees.common.Node root = new trees.common.Node(sortedInput[middle]);
        root.left=convertToTree(sortedInput,start,middle-1);
        root.right=convertToTree(sortedInput,middle+1,end);
        return root;
    }
    public void inorderTrav(trees.common.Node tree){
        if(tree==null){
            return;
        }
        inorderTrav(tree.left);
        System.out.print(tree.data + " ");
        inorderTrav(tree.right);
    }
    public void postorderTrav(trees.common.Node tree){

        if(tree==null){
            return;
        }
        postorderTrav(tree.left);
        postorderTrav(tree.right);
        System.out.print(tree.data + " ");
    }
}
