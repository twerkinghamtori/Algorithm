package complete;

import java.util.*;

//프로그래머스 2018 KAKAO BLIND RECRUITMENT	 [1차]프렌즈4블록 구현
public class Friends4Blcok {
	
	static String[][] map;
    static List<String> list = new ArrayList<>();
    static int[] X = {0,0,1,1}; //시계방향 이동 행 좌표
    static int[] Y = {0,1,0,1}; //시계방향 이동 열 좌표
    static int answer = 0;
    
    public static int solution(int m, int n, String[] board) {
        map = new String[m][n];
        //블록 하나씩 저장
        for(int i=0; i<m; i++) {
            map[i] = board[i].split("");
        }
        //더 이상 터트릴 블록이 없을 때까지 반복
        while(true) {
        	//2x2 형태로 4개 붙어있는 블록 탐색 후 list에 시작 블록 좌표 저장
            select(map);
         
            if(list.size() == 0) break; //더 이상 터트릴 블록이 없는 경우
            else {
                erase(list); //list에 저장된 시작블록 좌표부터 4개 빈 칸 처리
                down(map); //지워진 블록 위에 있는 블록 아래로 떨어짐
            }
            list.clear(); //리스트 클리어
        }
        
        return answer;
    }
    
    //2x2 같은 4개 블록 탐색 함수
    private static void select(String[][] map) {
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                String s = map[i][j];
                if(s.equals("")) continue; //이미 터진 블록인 경우
                int cnt = 0;
                for(int a=0;a<4;a++) {
                    int newx = i+X[a];
                    int newy = j+Y[a];
                    if(newx>=map.length || newy>=map[i].length) continue;
                    else {
                        if(map[newx][newy].equals(s)) cnt++;
                    }
                }
                if(cnt==4) {
                   list.add(i+" "+j);
                } 
            }
        }
    }
    
    //빈 칸 처리하는 함수
    private static void erase(List<String> list) {
        for(String s : list) {
            String[] xy = s.split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            for(int a=0;a<4;a++) {
                int newx = x+X[a];
                int newy = y+Y[a];
                if(newx>=map.length || newy>=map[0].length) continue;
                else if(!map[newx][newy].equals("")) {                	
                    map[newx][newy] = "";
                    //이미 터진 경우 제외하고 빈 칸 처리할 때마다 answer 증가
                    /* 예)
                     * AAA
                     * AAA
                     */
                    answer++;
                }
            }
        }
    }
    
    //빈 칸에 블록 내려오는 함수
    private static void down(String[][] map) {
        for (int i = 0; i < map[0].length; i++) {
            int emptyCount = 0; // 빈 공간의 개수
            //아래부터 탐색
            for (int j = map.length - 1; j >= 0; j--) {
                if (map[j][i].equals("")) {
                    emptyCount++;
                } else if (emptyCount > 0) {
                    // 현재 위치에 블록이 있고, 바로 아래에 빈 공간이 있을 경우 위치를 변경
                    map[j + emptyCount][i] = map[j][i];
                    map[j][i] = "";
                }
            }
        }
    }
    
	public static void main(String[] args) {
		int m = 6;
		int n = 6;
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(solution(m,n,board));

	}

}