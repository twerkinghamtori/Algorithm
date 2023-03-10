
import java.util.Scanner;
/*
 * 숫자 n을 입력받아 n숫자보다 작은 소수(primary number)의 갯수를 구하기
 * 숫자를 입력하세요
 * 20
 * 
 * 1,2,3,5,7,11,13,17,19
 * 20숫자까지의 소수의 갯수:9
 * 
 */
public class PrimaryNum {
	public static void main(String[] args) {
		//앞에 수로 나눠서 나머지가 0이면 break;
		System.out.println("숫자를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int cnt = 0;
		boolean b = true;
		
		for(int i=2; i<num; i++) {
			for(int j=2; j<i; j++) {
				if(i%j==0) b=false;
			} 
			if(b==true) {
				System.out.print(i+",");
				cnt++;
			}
			b=true;
		}
		
		System.out.println();

		System.out.println(num + "까지의 소수의 개수 : " + cnt);
}
	
}