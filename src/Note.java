import java.util.*;
import java.io.*;

public class Note {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String[] minus = br.readLine().split("-");
		
		int init = Integer.MAX_VALUE; //초기값 설정
		
		for(int i=0; i<minus.length; i++) {
			String[] plus = minus[i].split("\\+"); //+는 정규식에서 특수한 문자 => 이스케이프 처리 해야함
			
			int sum = 0;
			for(int j=0; j<plus.length; j++) {
				sum+=Integer.parseInt(plus[j]);
			}
			
			if(init == Integer.MAX_VALUE) {
				init = sum;
			} else {
				init -= sum;
			}
			
		}
		
		System.out.println(init);
		
	}

}
