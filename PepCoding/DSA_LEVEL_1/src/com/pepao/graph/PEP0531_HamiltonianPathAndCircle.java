package com.pepao.graph;

import java.util.ArrayList;
import java.util.List;

public class PEP0531_HamiltonianPathAndCircle {
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

        List<String> allHalmiltonianPath = new ArrayList<>();

        findAllConnectedSubgraph(graph, 0, visited, "", allHalmiltonianPath, 0);

        allHalmiltonianPath.forEach(str -> {
           String[] vertexArr = str.split("->");
           String firstVertex = vertexArr[0];
           String lastVertex = vertexArr[vertexArr.length - 1];
           boolean circleFind = false;
           for(List<Edge> edges : graph){
               if(edges == null) continue;
               for(Edge edge : edges){
                   if(!firstVertex.isEmpty() && !lastVertex.isEmpty() &&  edge.origin() == Integer.parseInt(firstVertex) && edge.destination() == Integer.parseInt(lastVertex)){
                       System.out.println("Hamiltonian Circle :"+str);
                       circleFind = true;
                       break;
                   }
               }
               if(circleFind) break;
           }
           if(!circleFind) System.out.println("Hamiltonian path : "+str);
        });

    }

    private static void findAllConnectedSubgraph(List<Edge>[] graph, int vertics, boolean[] visited, String path, List<String> allHalmiltonianPath, int visitVertics) {
        if(visited[vertics]) return ;

        visited[vertics] = true;
        path= path.concat("->"+vertics);
        visitVertics = visitVertics + 1;
        for (Edge edge : graph[vertics]) {
           findAllConnectedSubgraph(graph,edge.destination(),visited,path, allHalmiltonianPath, visitVertics);
        }
        visited[vertics] = false;

        if(visitVertics == visited.length) allHalmiltonianPath.add(path.substring(2));
    }
}
