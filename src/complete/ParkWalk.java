package complete;

//프로그래머스 공원산책

public class ParkWalk {
	public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        String[][] map = new String[park.length][park[0].length()];
        for(int i=0; i<map.length; i++) {
            map[i] = park[i].split("");
        }
        int startX = 0;
        int startY = 0;
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j].equals("S")) {
                    startX = i;
                    startY = j;
                }
            }
        }
        int x = startX;
        int y = startY;
        
        for(int i=0; i<routes.length; i++) {
            String[] move = routes[i].split(" ");
            if(move[0].equals("N")) {
                boolean s = checkX(x, y, move[0], move[1], map);
                if(s==true) {
                    x -= Integer.parseInt(move[1]);
                }                
            } else if(move[0].equals("S")) {
                boolean s = checkX(x, y, move[0], move[1], map);
                if(s==true) {
                    x += Integer.parseInt(move[1]);
                }                
            } else if(move[0].equals("W")) {
                boolean s = checkX(x, y, move[0], move[1], map);
                if(s==true) {
                    y -= Integer.parseInt(move[1]);
                }                
            } else if (move[0].equals("E")) {
                boolean s = checkX(x, y, move[0], move[1], map);
                if(s==true) {
                    y += Integer.parseInt(move[1]);
                }                
            }
            
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
    
    static boolean checkX(int x, int y, String direction, String c, String[][] map) { 
        if(direction.equals("N")) {
            if(x-Integer.parseInt(c) >= 0) {
                for(int i=x; i>=x - Integer.parseInt(c); i--) {
                    if(map[i][y].equals("X")) return false;
                }
            } else return false;
        }
        else if(direction.equals("S")) {
            if(x+Integer.parseInt(c) < map.length) {
                for(int i=x; i<=x + Integer.parseInt(c); i++) {
                    if(map[i][y].equals("X")) return false;
                }
            } else return false;
        }
        else if(direction.equals("W")) {
            if(y-Integer.parseInt(c) >= 0) {
                for(int i=y; i>=y- Integer.parseInt(c); i--) {
                    if(map[x][i].equals("X")) return false;
                }
            } else return false;
        }
        else if(direction.equals("E")) {
            if(y+Integer.parseInt(c) < map[0].length) {
                for(int i=y; i<=y+ Integer.parseInt(c); i++) {
                    if(map[x][i].equals("X")) return false;
                }
            } else return false;
        }
        return true;        
    }

}
