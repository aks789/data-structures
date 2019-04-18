package graphs;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * DFS Algo implementation using recursion and adjacency list
 */
class Graph1{
    int totalVert;
    LinkedList<Integer> adjList[];

    public Graph1(int v){
        totalVert=v;
        adjList = new LinkedList[v];
        for(int i=0;i<v;i++){
            adjList[i]= new LinkedList();
        }
    }

    public void addEdge(int v , int e){
        adjList[v].add(e);
    }

    public void DFS(int v){

        boolean[] visited = new boolean[totalVert];

        DFSUtil(v,visited);

    }

    public void DFSUtil(int v , boolean[] visited){
        visited[v]=true;
        if(visited[v]==true){
            System.out.println(v + " ");
        }
        Iterator<Integer> neighbours =  adjList[v].iterator();

        while(neighbours.hasNext()){
            int n = neighbours.next();
            if(!visited[n])
                DFSUtil(n,visited);
        }
    }
}

public class DFSAlgo{




    public static void main(String[] args){

        Graph1 g = new Graph1(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);

    }

}