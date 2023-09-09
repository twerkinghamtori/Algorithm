import java.util.*;

public class Note {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		
		int money = 1000 - m;
		
		int cnt = 0;
		
		int[] change = {500,100,50,10,5,1};
		
		for(int i=0; i<change.length; i++) {
			cnt+= money/change[i];
			money%=change[i];
		}		
		
		System.out.println(cnt);
	}

}
