package com.pepao.graph;

import java.util.*;

public class PEP0527_SolveGraphProblem {
    public static void main(String[] args) {
        List<Path> paths = new ArrayList<>();
        paths.add(new Path("A", "B", 5));
        paths.add(new Path("A", "C", 16));
        paths.add(new Path("C", "D", 7));
        paths.add(new Path("D", "B", 8));
        paths.add(new Path("D", "E", 9));
        paths.add(new Path("B", "F", 10));
        paths.add(new Path("E", "F", 21));
        paths.add(new Path("E", "G", 12));
        paths.add(new Path("F", "G", 17));
        paths.add(new Path("B", "A", 5));
        paths.add(new Path("C", "A", 16));
        paths.add(new Path("D", "C", 7));
        paths.add(new Path("B", "D", 8));
        paths.add(new Path("E", "D", 9));
        paths.add(new Path("F", "B", 10));
        paths.add(new Path("F", "E", 21));
        paths.add(new Path("G", "E", 12));
        paths.add(new Path("G", "F", 17));

        HashMap<String, List<Path>> graph = CreateGraph.createGraphFromListOfPath(paths);

        HashMap<String, Boolean> visited = new HashMap<>();
        for(String key : graph.keySet()){
            visited.computeIfAbsent(key, k->false);
        }
        TreeMap<String, Integer> allPath = findAllPath(graph, "A", "F", 0, visited);
       allPath.forEach((key, value) -> System.out.println(key + " -> " + value));
        // For smallest weight path
        findSmallestWeightPath(allPath);
        // For highest weight path
        findHightestWeightPath(allPath);
        // For smallest turn path
        findSmallestTrunPath(allPath);
        // For highest turn path
        findHighestTrunPath(allPath);
        // For Ceil weight path
        findCeilWeightPath(allPath, 40);
        // For floor weight path
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
        System.out.println("Floor Weight path "+i+" : "+ans);
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
        System.out.println("Ceil Weight path "+i+" : "+ans);
    }

    private static void findHightestWeightPath(TreeMap<String, Integer> allPath) {
        System.out.println( "Heighest weight path : "+ allPath.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null)
        );
    }

    private static void findHighestTrunPath(TreeMap<String, Integer> allPath) {
        System.out.println( "Highest Turn path : "+ allPath.entrySet()
                .stream()
                .max(Map.Entry.comparingByKey(Comparator.comparingInt(String::length)))
                .map(Map.Entry::getKey)
                .orElse(null)
        );
    }

    private static void findSmallestTrunPath(TreeMap<String, Integer> allPath) {
                System.out.println( "Smallest Turn path : "+ allPath
                        .entrySet()
                        .stream()
                        .min(Map.Entry.comparingByKey(Comparator.comparingInt(String::length)))
                        .map(Map.Entry::getKey)
                        .orElse(null)
                );
    }

    private static void findSmallestWeightPath(TreeMap<String, Integer> allPath) {
        System.out.println( "Smallest weight path : "+ allPath
                .entrySet()
                .stream().
                min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null)
        );
    }

    private static TreeMap<String, Integer> findAllPath(HashMap<String, List<Path>> graph, String origin, String dest, int weight,
                                                        HashMap<String, Boolean> visited) {

        TreeMap<String, Integer> result  = new TreeMap<String, Integer>(Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder()));
        List<Path> paths = graph.get(origin);
        if(paths==null || paths.isEmpty() || visited.get(origin)){ return   result;}
        if(origin.equals(dest)){
            result.put(origin, weight);
            return result;
        }
        visited.put(origin, true);
        for(Path path : paths) {
            TreeMap<String, Integer> pathTest = findAllPath(graph, path.destination, dest, path.weight, visited);
            if (pathTest != null && !pathTest.isEmpty()) {
                pathTest.forEach((key, value) -> result.put(origin.concat("->").concat(key), value + weight));
            }
        }
        visited.put(origin, false);
        return result;
    }
}
