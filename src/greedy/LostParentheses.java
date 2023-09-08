package greedy;

import java.io.*;

public class LostParentheses {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//"-"로 split 해서 배열에 저장
		String[] minus = br.readLine().split("-");
		
		int init = Integer.MAX_VALUE; //초기값 설정
		
		for(int i=0; i<minus.length; i++) {
			//다시 +로 split해서 배열에 저장
			String[] plus = minus[i].split("\\+"); //+는 정규식에서 특수한 문자 => 이스케이프 처리 해야함
			
			int sum = 0;
			for(int j=0; j<plus.length; j++) {
				sum+=Integer.parseInt(plus[j]);
			}
			
			if(init == Integer.MAX_VALUE) { //첫번째인 경우
				init = sum;
			} else {
				init -= sum;
			}
			
		}
		
		System.out.println(init);

	}

}
