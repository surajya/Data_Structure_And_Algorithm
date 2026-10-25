package com.pepao.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateGraph {
    private CreateGraph(){}

    public static HashMap<String, List<Edgee>> createGraphFromListOfPath(List<Edgee> paths){
        HashMap<String, List<Edgee>> graph = new HashMap<>();
        paths.forEach(edge -> graph.computeIfAbsent(edge.origin, key->new ArrayList<Edgee>()).add(edge));
        return graph;
    }

    public static List<Edge>[] createGraph(List<Edge> paths, int vertices){
        List<Edge>[] graph = new ArrayList[paths.size()];
        for(int i = 0; i < vertices; i++){graph[i] = new ArrayList<>();}
        paths.stream().forEach(edge -> graph[edge.origin()].add(edge));
        return graph;
    }
}
