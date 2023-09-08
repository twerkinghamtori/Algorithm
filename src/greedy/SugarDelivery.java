package greedy;

import java.util.*;

public class SugarDelivery {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int five = Integer.MAX_VALUE;
		int three = Integer.MAX_VALUE;
		boolean b = false;

		List<Integer> list = new ArrayList<>();

		if (n % 5 == 0) {
			five = n / 5;
			list.add(five);
		}
		
		if (n % 3 == 0) {
			three = n / 3;
			list.add(five);
		}
		
		for(int i=0; i<=n/5; i++) {
			for(int j=0; j<=n/3; j++) {
				if(i*5+j*3 == n) {
					b=true;
					list.add(i+j);
				}
			}
		}

		if (five == Integer.MAX_VALUE && three == Integer.MAX_VALUE&& !b)
			System.out.println(-1);
		else {
			list.sort((o1, o2) -> o1 - o2);
			System.out.println(list.get(0));
		}

	}

}
