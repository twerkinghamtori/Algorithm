package complete;


import java.util.Arrays;

/*
캔디팡은 7 * 7 모양의 격자 판에 같은 색깔이 연속 3개 이상인 부분을 찾아 터치하면 터지면서 점수를 얻는 게임이다. 
이때 연속된 부분은 상, 하, 좌, 우만 판단한다.
캔디팡 격자 정보가 주어졌을 때 터치하면 터지는 영역의 개수를 출력하는 프로그램을 작성하시오.
※ 색깔정보
빨강 = 1 , 노랑 = 2 , 파랑 = 3 , 초록 = 4 , 보라 = 5
입력 예시   
2	1 	5 	1 	1 	3 	4
2	1 	5 	1 	3 	5 	3
2 	3 	4 	5 	2 	2 	4
4 	4 	3 	2 	3 	1 	3
4 	3 	5 	3 	1 	4 	3
5 	4 	4 	3 	3 	5 	5
2 	1 	3 	5 	1 	1 	2
출력 예시
=>4
*/
public class CandyPang {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { 
			{ 2, 1, 5, 1, 1, 3, 4}, 
			{ 2, 1, 5, 1, 3, 5, 3},  
			{ 2, 3, 4, 5, 2, 2, 4},
			{ 4, 4, 3, 2, 3, 1, 3}, 
			{ 4, 3, 5, 3, 1, 4, 3}, 
			{ 2, 4, 4, 3, 3, 5, 5 },
			{ 2, 2, 3, 5, 1, 1, 2}  }));
	}
	
	public static int solution(int[][] candy) {
		int cnt=0;
		int answercnt = 0;
		int wonil[][] = new int[9][9];
		for(int i=1; i<wonil.length-1; i++) {
			for(int j=1; j<wonil.length-1; j++) {
				wonil[i][j] = candy[i-1][j-1];
			}
		}
		
		for(int i=1; i<wonil.length-1; i++) {
			for(int j=1; j<wonil[i].length-1; j++) {
					if(wonil[i][j] == wonil[i][j-1]) cnt++;
					if(wonil[i][j] == wonil[i][j+1]) cnt++;
					if(wonil[i][j] == wonil[i+1][j]) cnt++;
					if(wonil[i][j] == wonil[i-1][j]) cnt++;
					if(cnt==2) {
						answercnt++;
						cnt=0;
					} else {
						cnt=0;
					}
				}
		}

		return answercnt;
	}

}