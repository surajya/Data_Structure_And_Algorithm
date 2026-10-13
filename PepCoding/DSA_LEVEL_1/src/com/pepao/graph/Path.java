package com.pepao.graph;

public class Path {
    String origin;
    String destination;
    int weight;
    public Path(String origin, String destination, int weight){
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }
}
