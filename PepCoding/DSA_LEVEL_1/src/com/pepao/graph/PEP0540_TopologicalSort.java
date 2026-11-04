package com.pepao.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class PEP0540_TopologicalSort {
    public static void main(String[] args) {
        List<Edge> paths = new ArrayList<>();
        int vertices = 7;
        paths.add(new Edge(0, 1, 10));
        paths.add(new Edge(0, 3, 10));

        paths.add(new Edge(1, 2, 15));
        paths.add(new Edge(2, 3, 15));

        paths.add(new Edge(4, 5, 30));
        paths.add(new Edge(4, 3, 30));

        paths.add(new Edge(5, 6, 30));
        paths.add(new Edge(4, 6, 40));

        List<Edge>[] graph = CreateGraph.createGraph(paths, vertices);

        boolean[] visited = new boolean[vertices];
        int totalPerfectFriends = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < vertices; i++){
            if(visited[i]) continue;
            findPerfectFriendMatch(graph, i, visited, 0, stack);
        }
        System.out.println("Stack is :"+ stack);
    }

    private static void findPerfectFriendMatch(List<Edge>[] graph, int i, boolean[] visited, int totalFriend,  Stack<Integer> stack) {
            if(visited[i]) return;
            visited[i] = true;
            for(Edge edge : graph[i]){
                int to = edge.destination();
                if(visited[to]) continue;
                findPerfectFriendMatch(graph, to, visited, totalFriend, stack);
            }
            stack.push(i);
    }
}
