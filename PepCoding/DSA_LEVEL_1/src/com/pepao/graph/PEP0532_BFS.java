package com.pepao.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class PEP0532_BFS {
    public static void main(String[] args) {
        List<Edge> paths = new ArrayList<>();
        int vertices = 7;
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

        paths.add(new Edge(4, 6, 7));
        paths.add(new Edge(6, 4, 8));
        paths.add(new Edge(5, 6, 7));
        paths.add(new Edge(6, 5, 8));

        List<Edge>[] graph = CreateGraph.createGraph(paths, vertices);

        boolean[] visited = new boolean[vertices];

        Queue<String> q = new LinkedList<>();
        q.add("0-0");

        while(!q.isEmpty()){
            String[] path = q.poll().split("-");
            int from = Integer.parseInt(path[0]);
            visited[from] = true;
            System.out.println("Path from 0 to "+from+" is: "+path[1]);
            for(Edge edge : graph[from]){
                int to = edge.destination();
                if(!visited[to]) continue;
                q.add(to+"-"+path[1]+to);
            }
        }

    }

}
