import java.util.Arrays;

class Bellman{

    int isNegetiveWtCycle(int n,int[][]edges){
        int dist[]= new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        for(int i=0; i<n;i++){
            for (int j=0;j<edges.length;j++){
                int src=edges[j][0];
                int dest=edges[j][1];
                int wt= edges[j][2];
                if(dist[src]!=Integer.MAX_VALUE && dist[dest]>dist[src]+wt){
                    dist[dest]=dist[src]+wt;
                }
            }
        }
        for (int j=0;j<edges.length;j++){
            int src=edges[j][0];
            int dest=edges[j][1];
            int wt= edges[j][2];
            if(dist[src]!=Integer.MAX_VALUE && dist[dest]>dist[src]+wt){
                return 1;
            }
        }
        return 0;
        
    }
}

public class Bellmanford {
    
}
