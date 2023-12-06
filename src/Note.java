
import java.util.*;
import java.io.*;

//백준 7568 덩치 정렬, 구현
public class Note {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //사람 수
		
		List<Person> list = new ArrayList<>(); //사람 정보를 저장할 리스트
		
		for(int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			list.add(new Person(i,Integer.parseInt(temp[0]),Integer.parseInt(temp[1]), 0)); //번호, 몸무게, 키, 등수
		}
		//입력 끝
		
		//몸무게가 큰 순서대로 정렬. 같다면 키가 큰 순서대로 정렬
		Collections.sort(list);
		
		list.get(0).rate = 1; //첫번째는 1등
		
		int cnt = 0;
		
		for(int i=1; i<list.size(); i++) {
			Person p = list.get(i);
			//p 보다 앞 순서의  배열을 순회하며 몸무게와 키가 더 큰 사람의 수를 카운트
			for(int j=0; j<i; j++) {
				if(p.w< list.get(j).w && p.h < list.get(j).h) cnt++;
			}
			//자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1 (문제 조건)
			p.rate = cnt+1;
			cnt = 0; //카운트 초기화
		}
		
		//출력을 위해 다시 번호 순서대로 정렬
		Collections.sort(list, (o1,o2) -> o1.num - o2.num);
		
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i).rate);
			if(i != list.size()-1) System.out.print(" ");
		}
	}

}

class Person implements Comparable<Person> {
	int num, w,h,rate;
	Person(int num, int w, int h, int rate) {
		this.num = num;
		this.w = w;
		this.h = h;
		this.rate = rate;
	}

	@Override
	public int compareTo(Person p) {
		if(p.w != this.w) {
			return p.w - this.w;
		} else return p.h - this.h;		
	}
}