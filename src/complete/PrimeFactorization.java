import java.util.Scanner;
/*
 * 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
 * */
public class PrimeFactorization {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		while(N!=1) {
			for(int i=2; i<=Math.sqrt(N); i++) {
				if(N%i==0) {
					System.out.println(i);
					N/=i;
					break;
				}
			}
		}
		
	}
}
