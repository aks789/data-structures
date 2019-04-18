package graphs;

import java.util.*;

/**
 *
 * Implement using Priority Queue
 * Complexity O(V + E ) logV
 * Created by AKRITI on 3/3/2019.
 */
public class DijkstrasAlgoUsingPq {

    List<List<Node>> adjList;
    Set<Integer> settled = new HashSet<>();
    PriorityQueue<Node> pq = new PriorityQueue<>();
    int[] distance;

    public DijkstrasAlgoUsingPq(List adjList, int v){
        this.adjList=adjList;
        distance = new int[v];
    }

    public void djiktrasAlgoRun(int source){
        for(int i=0;i<distance.length;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        distance[source]=0;

        pq.add(new Node(source,0));


        while(settled.size()!=distance.length){// O(V)
            int u = pq.remove().node; // log(V)
            settled.add(u);

            findNeighbours(u);
        }

        for(int i=0;i<distance.length;i++)
            System.out.println("Distance from " + source + " of node " + i + " is " + distance[i]);

    }

    public void findNeighbours(int u){  // O(E)
        List<Node> neighbours = adjList.get(u);
        for(int i=0;i< neighbours.size();i++){
            if(!settled.contains(neighbours.get(i).node)){
                int newDist = distance[u]+ neighbours.get(i).cost;
                if (newDist < distance[neighbours.get(i).node]) {
                    distance[neighbours.get(i).node] = newDist;
                }
                pq.add(new Node(neighbours.get(i).node, distance[neighbours.get(i).node]));
            }
        }

    }
    public static void main(String[] args){

        int V = 5;

        List<List<Node>> adjList = new ArrayList();
        for(int i=0;i<V;i++){
            List<Node> vertexNeighbours = new ArrayList();
            adjList.add(vertexNeighbours);
        }
        adjList.get(0).add(new Node(1,9));
        adjList.get(0).add(new Node(2,6));
        adjList.get(0).add(new Node(3,5));
        adjList.get(0).add(new Node(4,3));
        adjList.get(2).add(new Node(1,2));
        adjList.get(2).add(new Node(3,4));

        DijkstrasAlgoUsingPq dijkstrasAlgoUsingPq = new DijkstrasAlgoUsingPq(adjList,V);
        dijkstrasAlgoUsingPq.djiktrasAlgoRun(0);

    }

}

class Node implements Comparable<Node>{
    int node;
    int cost;

    public Node()
    {
    }


    public Node(int node, int cost){
        this.node=node;
        this.cost=cost;
    }

    @Override
    public int compareTo(Node o) {
        if(this.cost<o.cost)
            return -1;
        if(this.cost>o.cost)
            return 1;
        return 0;
    }
}
