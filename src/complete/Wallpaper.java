package complete;

//프로그래머스 바탕화면 정리
public class Wallpaper {
	
	//새로운 풀이
	public static int[] solution2(String[] wallpaper) {
		
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		
		for(int i=0; i<wallpaper.length; i++) {
			for(int j=0; j<wallpaper[i].length(); j++) {
				if(wallpaper[i].charAt(j) == '#') {
					minX = Math.min(minX, i);
					minY = Math.min(minY, j);
					maxX = Math.max(maxX, i);
					maxY = Math.max(maxY, j);
				}
			}
		}
		
		return new int[]{minX,minY,maxX+1,maxY+1};
		
	}

	//기존 풀이
	public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        String[][] map = new String[wallpaper.length][wallpaper[0].length()];
        for(int i=0; i<map.length; i++) {
            map[i] = wallpaper[i].split("");
        }
        
        int leftx = 0;
        int rightx = 0;
        boolean check = false;
        
        for(int i=0; i<map[0].length; i++) {
            for(int j=0; j<map.length; j++) {
                if(map[j][i].equals("#")) {
                    leftx = i;
                    check = true;
                    break;
                }
            }
            if(check) break;
        }
        
        
        for(int i=map[0].length-1; i>=0; i--) {
            for(int j=0; j<map.length; j++) {
                if(map[j][i].equals("#")) {
                    rightx = i;
                    check = false;
                    break;
                }
            }
            if(!check) break;
        }
        
        int lefty = 0;
        int righty = 0;
        
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j].equals("#")) {
                    lefty = i;
                    check = true;
                    break;
                }
            }
            if(check) break;
        }
        
        for(int i=0; i<map.length; i++) {
            for(int j=map[i].length-1; j>=0; j--) {
                if(map[i][j].equals("#")) {
                    righty = i;
                    break;
                }
            }
        }
        
        answer[0] = lefty;
        answer[1] = leftx;
        answer[2] = righty+1;
        answer[3] = rightx+1;
        
        return answer;
    }

}
