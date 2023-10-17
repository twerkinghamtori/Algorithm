package complete;

//프로그래머스 덧칠하기
public class Repainting {
	public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] wall = new int[n];
        
        for(int i=0; i<section.length; i++) {
            wall[section[i]-1] = -1;
        }
    
        for(int i=0; i<wall.length; i++) {
            if(wall[i] == -1) {
                answer ++;
            } else continue;
            for(int j=i; j<i+m; j++) {
                if(j<wall.length) {
                    wall[j] = 0;
                } else break;                
            }
        }
        return answer;
    }
}
