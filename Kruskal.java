import java.util.ArrayList;
import java.util.Collections;

class Edge implements Comparable<Edge>{
   int src, dest, wt;
   
   Edge(int src, int dest, int wt){
    this.src=src;
    this.dest=dest;
    this.wt=wt;
   }

   int CompareTo(Edge that){
    return this.wt-that.wt;
   }

@Override
public int compareTo(Edge o) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
}
}

class Solution{
    int parent[];

    void union(int a, int b){
        int pA=find(a);
        int pB= find(b);
        if(pA==pB){
            return;
        }
        parent[pB]=pA;
    }

    int find(int a){
        if(parent[a]==a) return a;
        return find(parent[a]);
    }

    ArrayList<Edge> spanningTree(int V, ArrayList<Edge> edges){
        Collections.sort(edges);
        int minCost=0;
        ArrayList<Edge> mst=new ArrayList<>();
        for(int i=0; i<edges.size();i++){
            Edge edge= edges.get(i);
            int srcParent=find(edge.src);
            int destParent=find(edge.dest);
            if(srcParent!=destParent){
                minCost+=edge.wt;
                mst.add(edge);
                union(srcParent, destParent);
            }
        }
        return mst;

    }
}
public class Kruskal{
    public static void main(String[] args) {
        ArrayList<Edge> graph = new ArrayList<>();
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 6));
        graph.add(new Edge(0, 3, 5));
        graph.add(new Edge(1, 3, 15));
        graph.add(new Edge(2, 3, 4));

        Solution sol=new Solution();
        ArrayList<Edge> mstAnser=sol.spanningTree(4, graph);
        int minCost = 0;
        for (Edge edge : mstAnser) {
            minCost += edge.wt;
            System.out.println("Edge: " + edge.src + " - " + edge.dest + " Weight: " + edge.wt);
        }
        System.out.println("Minimum cost of spanning tree: " + minCost);
    }
    
    }