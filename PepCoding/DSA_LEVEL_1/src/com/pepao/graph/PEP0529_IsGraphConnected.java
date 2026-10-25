package com.pepao.graph;

import java.util.ArrayList;
import java.util.List;

public class PEP0529_IsGraphConnected {
    public static void main(String[] args) {
        List<Edge> paths = new ArrayList<>();
        int vertices = 7;
        paths.add(new Edge(0, 1, 5));
        paths.add(new Edge(0, 2, 16));
        paths.add(new Edge(2, 3, 7));
        paths.add(new Edge(3, 1, 8));
        paths.add(new Edge(4, 5, 21));
        paths.add(new Edge(4, 6, 12));
        paths.add(new Edge(5, 6, 17));
        paths.add(new Edge(1, 0, 5));
        paths.add(new Edge(2, 0, 16));
        paths.add(new Edge(3, 2, 7));
        paths.add(new Edge(1, 3, 8));
        paths.add(new Edge(5, 4, 21));
        paths.add(new Edge(6, 4, 12));
        paths.add(new Edge(6, 5, 17));
        paths.add(new Edge(3, 5, 17));
        paths.add(new Edge(5, 3, 17));

        List<Edge>[] graph = CreateGraph.createGraph(paths, vertices);

        boolean[] visited = new boolean[vertices];

        List<String> allConnectedComponent = new ArrayList<>();
        for (int i=0; i<vertices; i++) {
            if (visited[i]) continue;
            String allComponent = findAllConnectedSubgraph(graph, i, visited, "");
            allConnectedComponent.add(allComponent);
        }

        if(allConnectedComponent.size() > 1){System.out.println("graph is not connected");}
        else {System.out.println("graph is connected");}
    }

    private static String findAllConnectedSubgraph(List<Edge>[] graph, int i, boolean[] visited, String s) {
        if(visited[i]) return s;

        visited[i] = true;
        s= s.concat(""+i);
        for (Edge edge : graph[i]) {
           s= findAllConnectedSubgraph(graph,edge.destination(),visited,s);
        }

        return s;
    }
}
