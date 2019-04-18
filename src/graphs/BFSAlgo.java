package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by AKRITI on 2/25/2019.
 */

class Vertex{
    char lab;
    Boolean wasVisited=false;

    public Vertex(char lab){
        this.lab=lab;
    }
}

class Graph{
    private Vertex vertexList[];
    private final int MAX_VERTS=20;
    private int adjMat[][];
    private int nVerts;
    private Queue<Integer> q;

    public Graph(){
        vertexList = new Vertex[MAX_VERTS];
        nVerts=0;
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        q = new LinkedList<Integer>();
    }

    public void addVertex(char lab){
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdges(int a , int b){
        adjMat[a][b]=1;
        adjMat[b][a]=1;
    }

    public int getAdjUnvisistedVertex ( int v ) {
        for(int j=0;j< nVerts; j++){
            if(adjMat[v][j]==1 && vertexList[j].wasVisited==false){
                return j;
            }
        }
        return  -1;
    }

    public void bfs(){
        vertexList[0].wasVisited=true;
        displayVertex(0);
        q.add(0);
        int v2;

        while(!q.isEmpty()){
            int v1  = q.remove();
            while((v2 = getAdjUnvisistedVertex(v1)) !=-1){
                vertexList[v2].wasVisited=true;
                displayVertex(v2);
                q.add(v2);
            }
        }
    }

    public void displayVertex(int v){
        System.out.println(vertexList[v].lab);
    }

}


public class BFSAlgo {

    public static void main(String[] args){

        Graph graph =  new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');

        graph.addEdges(0,1);
        graph.addEdges(1,2);
        graph.addEdges(0,3);
        graph.addEdges(3,4);
        graph.addEdges(4,5);
        graph.addEdges(1,3);

        graph.bfs();
    }


}
