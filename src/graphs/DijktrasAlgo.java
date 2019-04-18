package graphs;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * Classic Method to find shortest path from a vertex in Graph using BFS
 * Complexity O(V^2)
 * Created by AKRITI on 3/3/2019.
 */
public class DijktrasAlgo {


    private static void dijkstra(int[][] adjMatrix){
        // Num of vertices can be calculated by the length of the adj matrix
        int v = adjMatrix.length;
        // Visited array for each vertex
        boolean visited[] = new boolean[v];
        // Array to store the min distance of each vertex from initial vertex.
        int distance[] = new int[v];

        // Distance of the initial vertex to itself shall be 0
        distance[0]=0;
        // Distance of each vertex shall be Max Int initially before Algo begins from the root vertex.
        for(int i=1;i<v;i++){
            distance[i]=Integer.MAX_VALUE;
        }

        // Loop till last but one vertex as last vertex shall have no neighbours which are not visited
        for(int i=0;i<v-1;i++){
            // Find vertex with min distance from root vertex. First time it will be root vertex itself
            int minVertex = findMinVertex(distance,visited);
            visited[minVertex]=true;
            // Explore Neighbours
            for(int j=0; j<v ; j++){
                if(adjMatrix[minVertex][j]!=0 && !visited[j] ){
                    int newDist = distance[minVertex] + adjMatrix[minVertex][j];
                    if(newDist < distance[j]){
                        distance[j] = newDist;
                    }
                }
            }
        }

        // Print

        for( int i=1 ; i < v ; i++){
            System.out.println(i + " " + distance[i]);
        }
    }

    private static int findMinVertex(int[] distance , boolean[] visited){

        int minVertex = -1;
        for(int i=0;i< distance.length;i++){
            if(!visited[i] && (minVertex==-1 || distance[i] < distance[minVertex])){
                minVertex=i;
            }
        }
        return minVertex;
    }

    public static void main(String[] args){
        // Take Graph Input
        Scanner s = new Scanner(System.in);
        // Total Vertices
        int v = s.nextInt();
        // Total Edges
        int e = s.nextInt();

        // Matrix to store the weight between each edge. Row represents v1 and column represents v2 . Value is the weight
        int adjMatrix[][] = new int[v][v];

        // Loop until all edges are covered
        for ( int i=0;i< e ; i++){
            // First vertex of the edge
            int v1 = s.nextInt();
            // Second vertex of the edge
            int v2 = s.nextInt();
            // Weight of the edge
            int weight = s.nextInt();

            adjMatrix[v1][v2]=weight;
            adjMatrix[v2][v1]=weight;
        }

        dijkstra(adjMatrix);
    }

}
