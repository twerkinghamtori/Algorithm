package complete;

import java.util.ArrayList;
import java.util.List;

/*돌 게임은 두 명이서 즐기는 재밌는 게임이다.
탁자 위에 돌 N개가 있다. 상근이와 창영이는 턴을 번갈아가면서 돌을 가져가며, 
돌은 1개 또는 3개 또는 4개 가져갈 수 있다. 마지막 돌을 가져가는 사람이 게임을 이기게 된다.
두 사람이 완벽하게 게임을 했을 때, 이기는 사람을 구하는 프로그램을 작성하시오.
게임은 상근이가 먼저 시작한다.
상근이가 게임을 이기면 SK를, 창영이가 게임을 이기면 CY을 출력한다.
<입력예시>
6
<출력예시>
SK
*/
public class RockGame2 {
	private static void solution(int N) {
		List<Integer> r = new ArrayList<>();
		r.add(1); r.add(3); r.add(4);
		int cnt=0;
		int rock = 0;
		while(true) {
			rock = r.get((int)(Math.random()*2));
			if((N-rock)<0) rock = r.get((int)(Math.random()*2));
			else {
				N-=rock;
				cnt++;
				System.out.println(rock);
			}
			if(N==0) break;
			
		}
		if(cnt%2==0) System.out.println("CY");
		else System.out.println("SK");
	}

	public static void main(String[] args) {
		solution(6);
	}

}