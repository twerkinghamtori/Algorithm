
/*
 * 피보나치 수열(0,1,1,2,3,5,8,13,...)
 */
import java.util.*;

public class Fibonacci {

	public static void main(String[] args) {
         System.out.println(fibo(7));
         System.out.println(fibo2(3));
	}
	
	public static int fibo(int num) {
		List<Integer> list = new ArrayList<>();
		list.add(0); list.add(1);		
		
		int answer=0;
			for(int i=2; i<=num; i++) {
				list.add(list.get(i-2) + list.get(i-1));
			}		
		return list.get(num);		
	}
	
	public static int fibo2(int num) {		
		int answer=0;
		if(num==0) {
			answer=0;
		} else if(num==1) {
			answer=1;
		} else if(num>=2) {
			for(int i=2; i<=num; i++) {
				answer = fibo(i-2) + fibo(i-1);
			}
		}
		return answer;		
	}
}