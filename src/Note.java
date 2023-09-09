import java.util.*;

public class Note {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		long n = scan.nextLong();
		
		long cnt = 0;
		long sum = 0;
		long i = 1;
		while(true) {
			
			if(sum > n) break;
			sum += i;
			i++;
			cnt++;
			
		}
		
		System.out.println(cnt-1);
	}

}
