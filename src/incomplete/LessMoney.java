package incomplete;

public class LessMoney {

	public static void main(String[] args) {
		long answer = solution(3,20,4);
		System.out.println(answer);
	}
	
	 public static long solution(long price, long money, int count) {
		 long answer = 0;
		 long a = (count*(count+1))/2;
		 money -= price*a;
//		 for(int i=1; i<=count; i++) {
//			money -= price*i; 
//		 }
		 if(money>=0) answer=0;
		 else answer = (long)Math.abs(money);
		 
		 return answer;
	 }

}
