import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*극장에 n개의 빈 좌석이 있다. 
k명의 관객들이 영화를 보기 위해서 왔다. 
이 관객들이 n개의 좌석에 앉을 수 있는 서로 다른 방법의 수를 구하는 프로그램을 작성하시오. 
(단, k명의 사람을 서로 구분하지 않으며, 한 명이 좌석에 앉으면 그 양 옆자리는 비어 있도록 배치해야 한다.)
첫 번재 줄에 n 과 k 가 공백으로 구분되어 입력된다.
<입력예시>
4 2
<출력예시>
3
*/
public class MovieSeats {
	private static int cnt=0;
	private static ArrayList<int[]> list = new ArrayList<>();
	
	public static void combine(int[] seats, boolean[] checked, int people, int start) {
		if(cnt==people) {
			list.add(Arrays.copyOf(seats, seats.length));
			return; // for문 안에서 불러온 combine 종료.
		}
		
		for(int i=start; i<seats.length; i++) {
			if(!checked[i]) {
				checked[i]=true;
				cnt++;
				seats[i]=1;
				combine(seats, checked, people, start+1);
				checked[i]=false;
				cnt--;
				seats[i]=0;
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] seats = new int[scan.nextInt()];
		boolean[] checked = new boolean[seats.length];
		int people = scan.nextInt();
		int cnt=0;
		int cntsum=0;
		combine(seats,checked, people, 0);
		HashSet<int[]> set = new HashSet<>(list); //왜 중복제거 안되지?
		
		for(int[] i : set) {
			System.out.println(Arrays.toString(i));
		}
		for(int[] i : set) {
			for(int j=0; j<i.length-1; j++) {
				if(i[j]==1 && i[j+1]==1) continue;
				else cnt++;
			}
			cntsum+=cnt;
			cnt=0;
		}
		System.out.println(cntsum);
		
	}
}