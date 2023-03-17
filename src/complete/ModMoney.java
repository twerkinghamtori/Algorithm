package complete;
import java.util.ArrayList;
import java.util.List;

/*어떤 가게의 욕심쟁이 점원은 거스름돈을 나눠줄때 거스름돈의 개수를 적게해서 주고자 한다.
거스름돈을 입력 받아 점원이 줄 수 있는 최소 거스름돈의 개수를 출력하시오.
예를 들어 54520원인 경우,
거스름돈으로 50000원권 1장, 1000원권 4장, 500원 1개, 10원 2개 해서 총 8개이다.
<입력예시>
54520
<출력예시>
8
*/
public class ModMoney {
	private static int solution(int money) {
		int answer = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=4; i>=0; i--) {
			list.add(money/(int)Math.pow(10, i));
			money%=(int)(Math.pow(10, i));
		}
		for(int i=0; i<list.size(); i++) {
			if(list.get(i)<5) answer+=list.get(i);
			else {
				answer += (1 + list.get(i)%5);
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(54520));
	}

}