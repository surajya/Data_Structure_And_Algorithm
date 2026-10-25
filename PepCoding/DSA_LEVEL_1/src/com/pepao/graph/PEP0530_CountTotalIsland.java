package com.pepao.graph;

import java.util.ArrayList;
import java.util.List;

public class PEP0530_CountTotalIsland {
    public static void main(String[] args) {
        int row=8, col= 8;
        int[][] graph = {
                {0,0,1,1,1,1,1,1},
                {0,0,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,0},
                {1,1,0,0,0,1,1,0},
                {0,1,1,1,0,1,1,0},
                {0,0,1,1,0,1,1,0},
                {1,1,1,1,1,1,1,0},
                {1,1,0,1,0,1,1,0},
        };


        boolean[][] visited = new boolean[row][col];

        int numberOfIslands = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (visited[i][j] || graph[i][j] == 1) continue;
                findIslands(graph, i, j, visited);
                numberOfIslands++;
            }
        }

        {System.out.println("Total Number of island : "+ numberOfIslands);}
    }

    private static void findIslands(int[][] graph, int i, int j,boolean[][] visited) {
        if(!validPoint(graph, i, j) || visited[i][j] ) return;
        visited[i][j] = true;


            //right
        findIslands(graph,i,j+1,visited);
            //down
        findIslands(graph,i+1,j,visited);
            //left
        findIslands(graph,i,j-1,visited);
            //up
        findIslands(graph,i-1,j,visited);

    }

    private static boolean validPoint(int[][] graph, int i, int j) {
        int row = graph.length;
        int col = graph[0].length;

        if(i>=0&&j>=0&&i<row&&j<col && graph[i][j] == 0) return true;
        return false;
    }
}
