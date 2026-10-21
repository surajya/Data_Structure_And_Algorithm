package com.pepao.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PEP0525_PrintAllPathBetweenTwoNode {
    public static void main(String[] args) {
        List<Path> paths = new ArrayList<>();
        paths.add(new Path("A", "B", 5));
        paths.add(new Path("A", "C", 6));
        paths.add(new Path("C", "D", 7));
        paths.add(new Path("D", "B", 8));
        paths.add(new Path("D", "E", 9));
        paths.add(new Path("B", "F", 10));
        paths.add(new Path("E", "F", 11));
        paths.add(new Path("E", "G", 12));
        paths.add(new Path("F", "G", 13));
        paths.add(new Path("B", "A", 5));
        paths.add(new Path("C", "A", 6));
        paths.add(new Path("D", "C", 7));
        paths.add(new Path("B", "D", 8));
        paths.add(new Path("E", "D", 9));
        paths.add(new Path("F", "B", 10));
        paths.add(new Path("F", "E", 11));
        paths.add(new Path("G", "E", 12));
        paths.add(new Path("G", "F", 13));

        HashMap<String, List<Path>> graph = CreateGraph.createGraphFromListOfPath(paths);

        HashMap<String, Boolean> visited = new HashMap<>();
        for(String key : graph.keySet()){
            visited.computeIfAbsent(key, k->false);
        }
        List<String> allPath = findAllPath(graph, "A", "F", visited);
        allPath.forEach(System.out::println);
    }

    private static List<String> findAllPath(HashMap<String, List<Path>> graph, String origin, String dest, HashMap<String, Boolean> visited) {
        List<String> result  = new ArrayList<>();
        List<Path> paths = graph.get(origin);
        if(paths==null || paths.isEmpty() || visited.get(origin)){ return   result;}
        if(origin.equals(dest)){
            result.add(origin);
            return result;
        }
        visited.put(origin, true);
        for(Path path : paths) {
            List<String> pathTest = findAllPath(graph, path.destination, dest, visited);
            if (pathTest != null && !pathTest.isEmpty()) {
                result.addAll(pathTest);
            }
        }
        visited.put(origin, false);
        for(int i = 0; i < result.size(); i++) {
            result.set(i, origin.concat("->").concat(result.get(i)));
        }
        return result;
    }
}
