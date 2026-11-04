package com.pepao.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class PEP0539_PerfectFriendsProblem {
    public static void main(String[] args) {
        List<Edge> paths = new ArrayList<>();
        int vertices = 7;
        paths.add(new Edge(0, 1, 10));
        paths.add(new Edge(1, 0, 10));

        paths.add(new Edge(2, 3, 15));
        paths.add(new Edge(3, 2, 15));

        paths.add(new Edge(4, 5, 30));
        paths.add(new Edge(5, 4, 30));

        paths.add(new Edge(6, 5, 30));
        paths.add(new Edge(5, 6, 30));
        paths.add(new Edge(4, 6, 40));
        paths.add(new Edge(6, 4, 40));

        List<Edge>[] graph = CreateGraph.createGraph(paths, vertices);

        boolean[] visited = new boolean[vertices];
        int totalPerfectFriends = 1;
        for(int i = 0; i < vertices; i++){
            if(visited[i]) continue;
            int totalFriend = findPerfectFriendMatch(graph, i, visited, 0);
            totalPerfectFriends *= totalFriend;
        }
        System.out.println("Total friend is :"+ totalPerfectFriends);
    }

    private static int findPerfectFriendMatch(List<Edge>[] graph, int i, boolean[] visited, int totalFriend) {
        Stack<Path> q = new Stack<>();
        q.push(new Path(i, "0", 0));

        while(!q.isEmpty()){
            Path path = q.pop();
            if(visited[path.dest()]) continue;
            visited[path.dest()] = true;
            totalFriend++;
            for(Edge edge : graph[path.dest()]){
                int to = edge.destination();
                if(visited[to]) continue;
                q.add(new Path(to, path.path()+edge.destination(), path.weight()+edge.weight()));
            }
        }
        return totalFriend;
    }
}
