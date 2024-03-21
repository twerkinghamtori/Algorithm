package complete;

import java.util.*;

//프로그래머스 퍼즐 조각 채우기
public class Puzzle {
    
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static List<List<Point>> t = new ArrayList<>();
	static List<List<Point>> g = new ArrayList<>();
	static int answer;
	
	public static void main(String[] args) {
		int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
		int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
		
		System.out.println(solution(game_board, table));
	}
	
	public static int solution(int[][] game_board, int[][] table) {
        answer = 0;
        
        //game_board 빈 공간 확인
        for(int i=0; i<game_board.length; i++) {
        	for(int j=0; j<game_board.length; j++) {
        		if(game_board[i][j] == 1) {
        			game_board[i][j] = 0;
        		} else {
        			game_board[i][j] = 1;
        		}
        	}
        }
        
        boolean[][] visited_t = new boolean[table.length][table.length];
        boolean[][] visited_g = new boolean[game_board.length][game_board.length];
        
        //bfs로 list에 블록, 빈공간 블록정보 저장
        for(int i=0; i<table.length; i++) {
        	for(int j=0; j<table.length; j++) {
        		if(!visited_t[i][j] && table[i][j] == 1) {
        			bfs(i, j, table, visited_t, t);
        		}
        		if(!visited_g[i][j] && game_board[i][j] == 1) {
        			bfs(i, j, game_board, visited_g, g);
        		}
        		
        	}
        }
        
        answer = calBlock(t,g);
        return answer;
    }
	
	private static void bfs(int x, int y, int[][] board, boolean[][] visited, List<List<Point>> list) {
		visited[x][y] = true;
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		
		List<Point> sub_list = new ArrayList<>();
		sub_list.add(new Point(0,0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx<0 || ny<0 || nx>=board.length || ny>=board.length) continue;
				
				if(!visited[nx][ny] && board[nx][ny] == 1) {
					visited[nx][ny] = true;
					sub_list.add(new Point(nx-x, ny-y));
					q.add(new Point(nx, ny));
				}
			}
		}
		
		list.add(sub_list);
	}
	
	//빈 공간에 블록이 맞는지 확인
	private static int calBlock(List<List<Point>> table, List<List<Point>> board) {
		int answer = 0;
		
		boolean[] visited = new boolean[board.size()];
		
		for(int i=0; i<table.size(); i++) {
			for(int j=0; j<board.size(); j++) {
				if(visited[j] || board.get(j).size() != table.get(i).size()) continue;
				
				if(isRotate(table.get(i), board.get(j))) {
					visited[j] = true;
					answer += board.get(j).size();
					break;
				}
			}
		}
		return answer;
	}
	
	//블록 회전
	private static boolean isRotate(List<Point> table, List<Point> board) {
		Collections.sort(board);
		
		//0, 90, 180, 270도 회전
		for(int i=0; i<4; i++) {
			Collections.sort(table);
			
			int cur_x = table.get(0).x;
			int cur_y = table.get(0).y;
			
			for(int j=0; j<table.size(); j++) {
				table.get(j).x -= cur_x;
				table.get(j).y -= cur_y;
			}
			
			//빈 공간에 맞는지
			boolean check = true;
			
			for(int j=0; j<table.size(); j++) {
				if(board.get(j).x != table.get(j).x || board.get(j).y != table.get(j).y) {
					check = false;
					break;
				}
			}
			
			if(check) return true;
			else {
				//빈 공간에 안 맞으면 회전
				//x,y -> y,-x (90도 회전)
				for(int j=0; j<table.size(); j++) {
					int temp = table.get(j).x;
					table.get(j).x = table.get(j).y;
					table.get(j).y = -temp;
				}
			}
		}
		return false;
	}
}

class Point implements Comparable<Point> {
	int x,y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(Point p) {
		if(this.x == p.x) {
			return this.y - p.y;
		} else return this.x- p.x;
	}
}
