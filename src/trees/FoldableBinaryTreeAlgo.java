package trees;

import java.util.*;

import static trees.Foldable_Tree.insert;
import trees.common.*;

class Foldable_Tree {
    public static void insert(trees.common.Node root, int a, int a1, char lr) {
        if (root == null) {
            return;
        }
        if (root.data == a) {
            switch (lr) {
                case 'L':
                    root.left = new trees.common.Node(a1);
                    break;
                case 'R':
                    root.right = new trees.common.Node(a1);
                    break;
            }
            return;
        }
        insert(root.left, a, a1, lr);
        insert(root.right, a, a1, lr);
    }
}

    /**
 * Created by AKRITI on 4/3/2019.
 */
public class FoldableBinaryTreeAlgo {

            public static void main (String[] args)
            {
                Scanner sc=new Scanner(System.in);
                int t=sc.nextInt();

                while(t-->0){
                    int n=sc.nextInt();
                    if(n==0)
                    {
                        System.out.println(0);
                        continue;
                    }
                    trees.common.Node root = null;
                    for(int i=0;i<n;i++)
                    {
                        int a=sc.nextInt();
                        int a1=sc.nextInt();
                        char lr=sc.next().charAt(0);
                        if(i==0)
                        {
                            root=new trees.common.Node(a);
                            switch(lr)
                            {
                                case 'L':root.left=new trees.common.Node(a1);
                                    break;
                                case 'R':root.right=new trees.common.Node(a1);
                                    break;
                            }
                        }
                        else
                        {
                            insert(root,a,a1,lr);
                        }
                    }

                    GFG gfg = new GFG();
                    boolean val = gfg.isFoldable(root);
                    if(val == true)
                        System.out.println("Yes");
                    else
                        System.out.println("No");
                }
            }

            public static void mirror(trees.common.Node node)
            {
                if(node == null)
                    return;
                else
                {
                    trees.common.Node temp;

                    mirror(node.left);
                    mirror(node.right);

                    temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                }

            }
        }

 class GFG
    {
        static Foldable_Tree obj = new Foldable_Tree();

        public static boolean isFoldableUtil(trees.common.Node left , trees.common.Node right){
            if(left==null && right==null ){
                return true;
            }

            if(left==null || right==null){
                return false;
            }

            return isFoldableUtil(left.right,right.left) &&
                    isFoldableUtil(left.left,right.right);


        }

        public static boolean isFoldable(trees.common.Node root)
        {
            if(root==null){
                return true;
            }

            trees.common.Node leftNode = root.left;
            trees.common.Node rightNode = root.right;

            return isFoldableUtil(leftNode,rightNode);
            // add your code here
        }


    }

