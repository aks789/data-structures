package trees;

import trees.common.Node;
import java.util.Scanner;
import java.util.Stack;

/**
 * Traversal for binary tree spirally.
 * Two methods - Reciursive / Iterative
 * Created by AKRITI on 4/11/2019.
 */

public class SpiralTreeTrav {

    private static void insert(Node root , int a , int b , char lr){
        if(root== null){
            return;
        }
        if(root.data==a){
            switch (lr){
                case 'L' : root.left=new Node(b);
                    break;
                case 'R' : root.right=new Node(b);
                    break;
            }
            return;
        }
        insert(root.left,a,b,lr);
        insert(root.right,a,b,lr);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        Node root = null;

        for(int i=0;i< height; i++){

            int a = sc.nextInt();
            int b = sc.nextInt();

            char lr = sc.next().charAt(0);

            if(root == null) {
                root = new Node(a);

                switch (lr) {
                    case 'L':
                        root.left = new Node(b);
                        break;
                    case 'R':
                        root.right = new Node(b);
                        break;
                }
            }else{
                insert(root,a,b,lr);
            }

        }

        spiralTravRecursive(root);
        iterativeTravRecursive(root);
    }

    private static void spiralTravRecursive(Node root){
        boolean lr =false;

        if(root==null){
            return;
        }
        int h = height(root);
        for(int i=1; i <= h;i++){
            printSameLevelNodes(root,i,lr);
            lr=!lr;
        }
    }

    private static void printSameLevelNodes(Node root , int height , boolean lr){
        System.out.println("Entered level node print");
        if(root == null){
            return;
        }

        if(height==1){
            System.out.println(root.data + " ");
        }
        else if(height>1){
            if (lr) {
                printSameLevelNodes(root.left, height - 1, lr);
                printSameLevelNodes(root.right, height - 1, lr);
            } else {
                printSameLevelNodes(root.right, height - 1, lr);
                printSameLevelNodes(root.left, height - 1, lr);

            }
        }

    }

    // Height of the tree
    private static int height(Node root){
        System.out.println("Entered height");
        if(root==null){
            return 0;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);

        if(lheight>rheight){
            return (lheight + 1) ;
        }else{
            return (rheight + 1 );
        }
    }

    private static void iterativeTravRecursive(Node root){
        Stack s1 = new Stack();
        Stack s2 = new Stack();

        if(root==null){
            return;
        }

        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()){

            while (!s1.isEmpty()){
                Node data = (Node) s1.pop();
                System.out.println(data.data + " ");

                if(data.left!=null) {
                    s2.push(data.left);
                }
                if(data.right!=null) {
                    s2.push(data.right);
                }

            }

            while (!s2.isEmpty()){
                Node data = (Node) s2.pop();
                System.out.println(data.data + " ");

                if(data.right!=null) {
                    s1.push(data.right);
                }
                if(data.left!=null) {
                    s1.push(data.left);
                }

            }

        }
    }

}
