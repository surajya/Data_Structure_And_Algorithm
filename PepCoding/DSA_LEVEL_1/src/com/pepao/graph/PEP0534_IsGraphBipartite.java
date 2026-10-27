package com.pepao.graph;

import java.util.*;

class PairBP{
    int origin;
    String path;
    int level;

    public  PairBP(int origin, String path, int level){
        this.origin = origin;
        this.path = path;
        this.level = level;
    }
}

public class PEP0534_IsGraphBipartite {
    public static void main(String[] args) {
        List<Edge> paths = new ArrayList<>();
        int vertices = 6;
        paths.add(new Edge(0, 1, 5));
        paths.add(new Edge(0, 2, 16));
        paths.add(new Edge(1, 0, 5));
        paths.add(new Edge(2, 0, 16));

        paths.add(new Edge(2, 3, 7));
        paths.add(new Edge(1, 3, 8));
        paths.add(new Edge(3, 2, 7));
        paths.add(new Edge(3, 1, 8));

        paths.add(new Edge(1, 4, 5));
        paths.add(new Edge(4, 1, 16));
        paths.add(new Edge(3, 5, 5));
        paths.add(new Edge(5, 3, 16));

        paths.add(new Edge(4, 5, 7));
        paths.add(new Edge(5, 4, 8));

        List<Edge>[] graph = CreateGraph.createGraph(paths, vertices);

        int[] visited = new int[vertices];
        Arrays.fill(visited, -1);

        for(int i = 0; i < vertices; i++){
            if(visited[i] != -1) continue;
            boolean isBipart = isGraphbipartite(graph, i, visited);
            if(!isBipart) {
                System.out.println("This is not Bipartite Graph");
                return;
            }
        }

        System.out.println("This is Bipartite Graph");
    }

    private static boolean isGraphbipartite(List<Edge>[] graph, int i, int[] visited) {
        Queue<PairBP> q = new LinkedList<>();
        q.add(new PairBP(i, null, 0));

        while(!q.isEmpty()){
            PairBP path = q.poll();
            if(visited[path.origin] != -1) {
                if(visited[path.origin] != path.level) return false;
            }else{
                visited[path.origin] = path.level;
            }
            for(Edge edge : graph[path.origin]){
                int to = edge.destination();
                if(visited[to] != -1) continue;
                q.add(new PairBP(to, null, path.level + 1));
            }
        }
        return true;
    }
}
