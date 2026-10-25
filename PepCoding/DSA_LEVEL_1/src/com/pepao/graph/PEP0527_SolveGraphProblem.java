package com.pepao.graph;

import java.util.*;

public class PEP0527_SolveGraphProblem {
    public static void main(String[] args) {
        List<Edgee> paths = new ArrayList<>();
        paths.add(new Edgee("A", "B", 5));
        paths.add(new Edgee("A", "C", 16));
        paths.add(new Edgee("C", "D", 7));
        paths.add(new Edgee("D", "B", 8));
        paths.add(new Edgee("D", "E", 9));
        paths.add(new Edgee("B", "F", 10));
        paths.add(new Edgee("E", "F", 21));
        paths.add(new Edgee("E", "G", 12));
        paths.add(new Edgee("F", "G", 17));
        paths.add(new Edgee("B", "A", 5));
        paths.add(new Edgee("C", "A", 16));
        paths.add(new Edgee("D", "C", 7));
        paths.add(new Edgee("B", "D", 8));
        paths.add(new Edgee("E", "D", 9));
        paths.add(new Edgee("F", "B", 10));
        paths.add(new Edgee("F", "E", 21));
        paths.add(new Edgee("G", "E", 12));
        paths.add(new Edgee("G", "F", 17));

        HashMap<String, List<Edgee>> graph = CreateGraph.createGraphFromListOfPath(paths);

        HashMap<String, Boolean> visited = new HashMap<>();
        for(String key : graph.keySet()){
            visited.computeIfAbsent(key, k->false);
        }
        TreeMap<String, Integer> allPath = findAllPath(graph, "A", "F", 0, visited);
       allPath.forEach((key, value) -> System.out.println(key + " -> " + value));
        // For smallest weight edge
        findSmallestWeightPath(allPath);
        // For highest weight edge
        findHightestWeightPath(allPath);
        // For smallest turn edge
        findSmallestTrunPath(allPath);
        // For highest turn edge
        findHighestTrunPath(allPath);
        // For Ceil weight edge
        findCeilWeightPath(allPath, 40);
        // For floor weight edge
        findFloorWeightPath(allPath, 40);
    }

    private static void findFloorWeightPath(TreeMap<String, Integer> allPath, int i) {
        int floorPath = Integer.MAX_VALUE;
        String ans = null;
        for(Map.Entry<String, Integer> entry : allPath.entrySet()){
            if(entry.getValue() < floorPath && entry.getValue() > i){
                floorPath = entry.getValue();
                ans = entry.getKey();
            }
        }
        System.out.println("Floor Weight edge "+i+" : "+ans);
    }

    private static void findCeilWeightPath(TreeMap<String, Integer> allPath, int i) {
        int floorPath = Integer.MIN_VALUE;
        String ans = null;
        for(Map.Entry<String, Integer> entry : allPath.entrySet()){
            if(entry.getValue() > floorPath && entry.getValue() < i){
                floorPath = entry.getValue();
                ans = entry.getKey();
            }
        }
        System.out.println("Ceil Weight edge "+i+" : "+ans);
    }

    private static void findHightestWeightPath(TreeMap<String, Integer> allPath) {
        System.out.println( "Heighest weight edge : "+ allPath.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null)
        );
    }

    private static void findHighestTrunPath(TreeMap<String, Integer> allPath) {
        System.out.println( "Highest Turn edge : "+ allPath.entrySet()
                .stream()
                .max(Map.Entry.comparingByKey(Comparator.comparingInt(String::length)))
                .map(Map.Entry::getKey)
                .orElse(null)
        );
    }

    private static void findSmallestTrunPath(TreeMap<String, Integer> allPath) {
                System.out.println( "Smallest Turn edge : "+ allPath
                        .entrySet()
                        .stream()
                        .min(Map.Entry.comparingByKey(Comparator.comparingInt(String::length)))
                        .map(Map.Entry::getKey)
                        .orElse(null)
                );
    }

    private static void findSmallestWeightPath(TreeMap<String, Integer> allPath) {
        System.out.println( "Smallest weight edge : "+ allPath
                .entrySet()
                .stream().
                min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null)
        );
    }

    private static TreeMap<String, Integer> findAllPath(HashMap<String, List<Edgee>> graph, String origin, String dest, int weight,
                                                        HashMap<String, Boolean> visited) {

        TreeMap<String, Integer> result  = new TreeMap<String, Integer>(Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder()));
        List<Edgee> paths = graph.get(origin);
        if(paths==null || paths.isEmpty() || visited.get(origin)){ return   result;}
        if(origin.equals(dest)){
            result.put(origin, weight);
            return result;
        }
        visited.put(origin, true);
        for(Edgee edge : paths) {
            TreeMap<String, Integer> pathTest = findAllPath(graph, edge.destination, dest, edge.weight, visited);
            if (pathTest != null && !pathTest.isEmpty()) {
                pathTest.forEach((key, value) -> result.put(origin.concat("->").concat(key), value + weight));
            }
        }
        visited.put(origin, false);
        return result;
    }
}
