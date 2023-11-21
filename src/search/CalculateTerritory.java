package search;

import java.io.*;
import java.util.*;

//백준 2583 영역 구하기 dfs
//dfs에서 return문 구현하는데 어려움. -> 예외의 경우 continue;말고 return 0으로 해결
public class CalculateTerritory {
    static List<Integer> list = new ArrayList<>();
    static boolean[][] visited;
    static int[][] board;
    static int[] X = {0, 0, 1, -1};
    static int[] Y = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        board = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            for (int j = b; j <= d - 1; j++) {
                for (int z = a; z <= c - 1; z++) {
                    board[j][z]++;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!visited[i][j] && board[i][j] == 0) {
                    list.add(dfs(i, j));
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (int i : list) System.out.print(i + "\t");
    }

    static int dfs(int x, int y) {
    	if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y] || board[x][y] != 0) {
            return 0;
        }
    	visited[x][y] = true;
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int cx = x + X[i];
            int cy = y + Y[i];
            cnt += dfs(cx, cy);
        }
        return cnt;
    }
}