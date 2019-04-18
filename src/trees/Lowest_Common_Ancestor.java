package trees;
// INITIAL CODE

import java.util.*;
        import java.lang.*;

// A Binary Tree node
public class Lowest_Common_Ancestor
{
    // driver function to test the above functions
    public static void main(String args[])
    {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            HashMap<Integer, trees.common.Node> m = new HashMap<Integer, trees.common.Node> ();
            int n = sc.nextInt();
            trees.common.Node root = null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                trees.common.Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new trees.common.Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                trees.common.Node child = new trees.common.Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }

            int a = sc.nextInt();
            int b = sc.nextInt();

            GfG g = new GfG();
            trees.common.Node k = g.LCA(root,a,b);
            System.out.println(k.data);
            //System.out.println();
            t--;

        }
    }
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class GfG
{
    trees.common.Node LCA(trees.common.Node root, int n1, int n2)
    {
        if(root==null){
            return null;
        }
        if(root.data==n1 || root.data==n2) {
            return root;
        }
        trees.common.Node left = LCA(root.left,n1,n2);
        trees.common.Node right = LCA(root.right,n1,n2);

        if(left==null && right==null){
            return null;
        }
        if(left!=null && right !=null){
            return root;
        }
        return left!=null? left:right;
        // Your code here
    }

}