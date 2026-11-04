package com.pepao.graph;

import java.util.*;

class PEP0536_DiskstraAlgorithm {
    public static void main(String[] args) {
        List<Edge> paths = new ArrayList<>();
        int vertices = 7;
        paths.add(new Edge(0, 1, 10));
        paths.add(new Edge(0, 3, 40));
        paths.add(new Edge(1, 0, 10));
        paths.add(new Edge(3, 0, 40));

        paths.add(new Edge(2, 3, 15));
        paths.add(new Edge(1, 2, 10));
        paths.add(new Edge(3, 2, 15));
        paths.add(new Edge(2, 1, 10));

        paths.add(new Edge(3, 4, 20));
        paths.add(new Edge(4, 3, 20));
        paths.add(new Edge(4, 5, 30));
        paths.add(new Edge(5, 4, 30));

        paths.add(new Edge(6, 5, 30));
        paths.add(new Edge(5, 6, 30));
        paths.add(new Edge(4, 6, 40));
        paths.add(new Edge(6, 4, 40));

        List<Edge>[] graph = CreateGraph.createGraph(paths, vertices);

        boolean[] visited = new boolean[vertices];
        printdiskstraAlgo(graph, 0, visited);
    }

    private static void printdiskstraAlgo(List<Edge>[] graph, int i, boolean[] visited) {
        Queue<Path> q = new PriorityQueue<>(Comparator.comparingInt(Path::weight));
        q.add(new Path(i, "0", 0));

        while(!q.isEmpty()){
            Path path = q.poll();
            if(visited[path.dest()]) continue;
            visited[path.dest()] = true;
            System.out.println("lowest weight path from: "+i+" to: "+path.dest() + " is -> "+ path.path()+" with weight: "+path.weight());
            for(Edge edge : graph[path.dest()]){
                int to = edge.destination();
                if(visited[to]) continue;
                q.add(new Path(to, path.path()+"-"+to, path.weight()+edge.weight()));
            }
        }
    }
}
