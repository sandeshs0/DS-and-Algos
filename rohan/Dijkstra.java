import java.util.*;

class Dijkstra {
    public static void main(String[] args) {
        int V = 3, S = 2;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        // Constructing the adjacency list
        adj.add(new ArrayList<>() {{
            add(new int[]{1, 1});
            add(new int[]{2, 6});
        }});
        adj.add(new ArrayList<>() {{
            add(new int[]{2, 3});
            add(new int[]{0, 1});
        }});
        adj.add(new ArrayList<>() {{
            add(new int[]{1, 3});
            add(new int[]{0, 6});
        }});

        Solution obj = new Solution();
        int[] res = obj.dijkstra(V, adj, S);

        for (int i = 0; i < V; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}

class Solution {
     int[] dijkstra(int V, ArrayList<ArrayList<int[]>> adj, int S) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[S] = 0;
        pq.offer(new int[]{S, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dis = current[1];

            if (dis > dist[node]) continue;

            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int edgeWeight = neighbor[1];

                if (dist[node] + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dist[node] + edgeWeight;
                    pq.offer(new int[]{adjNode, dist[adjNode]});
                }
            }
        }
        return dist;
    }
}
