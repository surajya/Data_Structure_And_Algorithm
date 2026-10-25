package com.pepao.graph;

import java.util.*;

public class PEP0528_ConnectedComponentOfGraph {
    public static void main(String[] args) {
        List<Edgee> paths = new ArrayList<>();
        paths.add(new Edgee("A", "B", 5));
        paths.add(new Edgee("A", "C", 16));
        paths.add(new Edgee("C", "D", 7));
        paths.add(new Edgee("D", "B", 8));
        paths.add(new Edgee("E", "F", 21));
        paths.add(new Edgee("E", "G", 12));
        paths.add(new Edgee("F", "G", 17));
        paths.add(new Edgee("B", "A", 5));
        paths.add(new Edgee("C", "A", 16));
        paths.add(new Edgee("D", "C", 7));
        paths.add(new Edgee("B", "D", 8));
        paths.add(new Edgee("F", "E", 21));
        paths.add(new Edgee("G", "E", 12));
        paths.add(new Edgee("G", "F", 17));

        HashMap<String, List<Edgee>> graph = CreateGraph.createGraphFromListOfPath(paths);

        HashMap<String, Boolean> visited = new HashMap<>();
        for(String key : graph.keySet()){
            visited.computeIfAbsent(key, k->false);
        }

        List<List<String>> allConnectedComponent = new ArrayList<>();
        for(String key : graph.keySet()){
            if(visited.get(key)) continue;
            List<String> allComponent =  findAllConnectedComponent(graph,key, visited);
            allConnectedComponent.add(allComponent);
        }

        allConnectedComponent.stream().forEach(list->list.forEach(System.out::println));
    }

    private static List<String> findAllConnectedComponent(HashMap<String, List<Edgee>> graph, String origin, HashMap<String, Boolean> visited) {
        List<String> result = new ArrayList<>();
         visited.put(origin,true);
        List<Edgee> allEdges = graph.get(origin);
        for(Edgee edge : allEdges){
            if(visited.get(edge.destination)) continue;
           List<String> pathCompo = findAllConnectedComponent(graph, edge.destination, visited);
           if(pathCompo != null && !pathCompo.isEmpty()){
               pathCompo.forEach(pathRec -> result.add(origin.concat(pathRec)));
           }
        }
        if(result.isEmpty()) {
            result.add(origin);
        }
        return result;
    }

}
