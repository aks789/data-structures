package LRUCache;

/**
 * LRU (Least Recently Used ) Cache Eviction Algorithm using HashMap and Double Linked List
 * Space complexity O(n)
 * Retrieval Complexity O(1)
 * Adding complexity O(1)
 * Created by AKRITI on 4/3/2019.
 */

import java.util.Scanner;
import java.util.*;


public class LRUCacheImpl {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            Set<Integer> s = new HashSet<Integer>();
            int n = sc.nextInt();
            LRUCache g = new LRUCache(n);
            int q = sc.nextInt();

            while (q > 0) {

                String c = sc.next();
                //	System.out.println(c);
                if (c.equals("GET")) {
                    int x = sc.nextInt();
                    System.out.print(g.get(x) + " ");
                }
                if (c.equals("SET")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    g.set(x, y);
                }

                q--;
                //System.out.println();
            }
            t--;
            System.out.println();
        }
    }
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*You are required to complete below class */
class LRUCache {

    private class DNode {
        Integer key;
        Integer value;
        DNode prev = null;
        DNode next = null;

        DNode(Integer key, Integer value) {
            this.value = value;
            this.key = key;
        }

    }

    private DNode head, tail;
    private Map<Integer, DNode> hashTable = new HashMap<Integer, DNode>();
    private int maxCacheSize;
    private int cacheSize = 0;

    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
        head = new DNode(null, null);
        tail = new DNode(null, null);

        head.next = tail;
        tail.prev = head;

        maxCacheSize = N;

        //Your code here
    }

    /*Returns the value of the key x if
     present else returns -1 */
    public int get(int x) {
        DNode node = hashTable.get(x);
        if (node == null) {
            return -1;
        } else {
            moveNodeToHead(node);
            return node.value;
        }
        //Your code here
    }

    private void moveNodeToHead(DNode node) {
        removeNode(node);
        addNode(node);
    }

    private void removeNode(DNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNode(DNode node) {
        DNode oldNext = head.next;
        node.next = oldNext;
        head.next = node;
        node.prev = oldNext.prev;
        oldNext.prev = node;

    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
        //Your code here
        DNode node = hashTable.get(x);
        if (node == null) {
            DNode newNode = new DNode(x, y);
            hashTable.put(x, newNode);
            addNode(newNode);
            ++cacheSize;
            if (cacheSize > maxCacheSize) {
                evictLRUCacheData();
                cacheSize = maxCacheSize;
            }
        } else {
            node.value = y;
            moveNodeToHead(node);
        }
    }

    private void evictLRUCacheData() {
        DNode removeNode = tail.prev;

        removeNode.prev.next = tail;
        tail.prev = removeNode.prev;

        hashTable.remove(removeNode.key);
    }
}

