package com.pepao.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateGraph {
    private CreateGraph(){}

    public static HashMap<String, List<Path>> createGraphFromListOfPath(List<Path> paths){
        HashMap<String, List<Path>> graph = new HashMap<>();
        paths.forEach(path -> graph.computeIfAbsent(path.origin, key->new ArrayList<Path>()).add(path));
        return graph;
    }
}
