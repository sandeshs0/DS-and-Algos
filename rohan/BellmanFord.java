import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class BellmanFord {
    int V;
    List<Edge> edges;

    public BellmanFord(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }

    public void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    public void bellmanFord(int source) {
        int distance[] = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        for (int i = 0; i < V-1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.source] != Integer.MAX_VALUE
                        && distance[edge.source] + edge.weight < distance[edge.destination]) {
                    distance[edge.destination] = distance[edge.source] + edge.weight;
                }

            }
            for (Edge edge : edges) {
                if (distance[edge.source] != Integer.MAX_VALUE
                        && distance[edge.source] + edge.weight < distance[edge.destination]) {
                    System.out.println("Negative cycle detected");
                    return;
                }

            }

        }
        for (int j = 0; j < V; j++) {
            System.out.println("Vertex: " + j + " : " + distance[j]);
        }
    }
    public static void main(String[] args) {
        int V = 5;
        BellmanFord graph = new BellmanFord(V);

        graph.addEdge(0, 1, 9);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 4, 3);
        graph.addEdge(2, 1, -2);
        graph.addEdge(2, 3, 4);

        graph.bellmanFord(0);
    }
}