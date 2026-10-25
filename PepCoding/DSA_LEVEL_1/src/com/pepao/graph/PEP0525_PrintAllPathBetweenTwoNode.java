package com.pepao.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PEP0525_PrintAllPathBetweenTwoNode {
    public static void main(String[] args) {
        List<Edgee> paths = new ArrayList<>();
        paths.add(new Edgee("A", "B", 5));
        paths.add(new Edgee("A", "C", 6));
        paths.add(new Edgee("C", "D", 7));
        paths.add(new Edgee("D", "B", 8));
        paths.add(new Edgee("D", "E", 9));
        paths.add(new Edgee("B", "F", 10));
        paths.add(new Edgee("E", "F", 11));
        paths.add(new Edgee("E", "G", 12));
        paths.add(new Edgee("F", "G", 13));
        paths.add(new Edgee("B", "A", 5));
        paths.add(new Edgee("C", "A", 6));
        paths.add(new Edgee("D", "C", 7));
        paths.add(new Edgee("B", "D", 8));
        paths.add(new Edgee("E", "D", 9));
        paths.add(new Edgee("F", "B", 10));
        paths.add(new Edgee("F", "E", 11));
        paths.add(new Edgee("G", "E", 12));
        paths.add(new Edgee("G", "F", 13));

        HashMap<String, List<Edgee>> graph = CreateGraph.createGraphFromListOfPath(paths);

        HashMap<String, Boolean> visited = new HashMap<>();
        for(String key : graph.keySet()){
            visited.computeIfAbsent(key, k->false);
        }
        List<String> allPath = findAllPath(graph, "A", "F", visited);
        allPath.forEach(System.out::println);
    }

    private static List<String> findAllPath(HashMap<String, List<Edgee>> graph, String origin, String dest, HashMap<String, Boolean> visited) {
        List<String> result  = new ArrayList<>();
        List<Edgee> paths = graph.get(origin);
        if(paths==null || paths.isEmpty() || visited.get(origin)){ return   result;}
        if(origin.equals(dest)){
            result.add(origin);
            return result;
        }
        visited.put(origin, true);
        for(Edgee edge : paths) {
            List<String> pathTest = findAllPath(graph, edge.destination, dest, visited);
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
