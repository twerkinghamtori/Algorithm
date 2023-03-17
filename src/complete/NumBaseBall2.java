package complete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/*
 * 숫자 맞추기 게임
 * 시스템이 4자리의 서로 다른 수를 저장한 후 사용자가 저장된 수를 맞추는 게임
 *    자리수도 맞는 경우 : 스트라익
 *    자리수는 틀리지만 숫자가 존재하면 : 볼
 *  4스트라익이 되면 정답
 *  알고리즘
 *  1. 시스템의 수를 지정 (Random함수 사용) 중복 되지 안도록 4자리 수 지정하기 (0~9)
 *  2. 화면으로 부터 4자리 정수를 입력
 *  3. 시스템의 수와 입력된 수를 비교하여 스트라익, 볼을 결정, 화면 출력
 *  4. 4스트라익이 될때 까지 2,3 을 계속 실행  
 *  5. 정답인 된경우 몇번만에 정답을 맞췄는지 입력 갯수를 화면에 출력하기
 */
public class NumBaseBall2 {
	public static void main(String[] args) {		
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		Set<Integer> set = new LinkedHashSet<>();
		//랜덤숫자 중복되지 않게 set에 저장
		for(int i=0; i<10; i++) {
			set.add(rand.nextInt(10));
			if(set.size()==4) break;
		}
		//인덱스 쓰려고 list에 다시 저장(좀 비효율적인가..)
		List<Integer> system = new ArrayList<>(set);		
		System.out.println(system);		
		
		int scnt=0, bcnt=0, answercnt=0; 
		while(scnt<4) {			
			System.out.println("4자리의 서로 다른 수를 입력하세요.");
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			//입력숫자는 그냥 배열에 저장(안겹치게 입력하면 되지ㅜ)
			int[] me = new int[4];
			for(int i=3; i>=0; i--) {
				me[i] = num%10;
				num/=10;
			}
			System.out.println(Arrays.toString(me));
			
			for(int i=0; i<4; i++) {
				if(system.get(i)==me[i]) { //자리수까지 같을때 strike++
					scnt++; continue; //ball에서 2번 카운트 되지 않게 continue
				}
				for(int j=0; j<4; j++) {
					 if(system.get(i) == me[j]) { //자리수는 다른데 같은 수 일 때, ball++
						bcnt++;
					}
				}				
			}
			answercnt++;
			if(scnt==4)  {
				System.out.println("ㅊㅊ정답입니다.");
				System.out.println(answercnt + "회 시도만에 맞추셨습니다.");
				break;
			}
			System.out.println(scnt + "스트라이크" + bcnt + "볼");			
		    scnt=0; bcnt=0; 
		}
		
	}
}