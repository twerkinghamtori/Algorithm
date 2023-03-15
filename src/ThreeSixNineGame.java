/*
 * 시작 수(a)와 마지막 수(b)가 입력되면 그 범위의 369게임에서 박수를 쳐야 될 횟수의 합을 출력하시오.
※ 369게임의 룰은 다음과 같다.
1. 숫자에 3이나 6이나 9가 들어가면 369 수에 해당된다.
2. 369 수에 해당될 경우 3이나 6이나 9가 들어간 개수만큼 박수를 친다. (예: 36은 박수를 두번 친다.)
3. 그 외의 숫자들은 박수를 치지 않는다.
아주 큰 범위의 테스트 데이터가 입력된다.
<출력 결과>
5 
실행시간 : 0초
13
실행시간 : 0초
240000000 
실행시간 : 0초
 */
public class ThreeSixNineGame {
	public static void main(String[] args){
		solution(3, 16);
		solution(30, 39);
		solution(1, 100000000);
	}

	private static void solution(int start, int end) {
		long s = System.currentTimeMillis();
		int[] nums = {0,0,0,1,0,0,1,0,0,1};
		for(int i=start; i<=end; i++) {
			if(nums[i%10]==1) 
		}
		long e = System.currentTimeMillis();
		System.out.println("실행시간 : "+((e-s)/1000)+"초");
		
	}
}