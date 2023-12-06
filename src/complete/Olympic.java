package complete;

import java.util.*;
import java.io.*;

//백준 8979 올림픽 정렬, 구현
public class Olympic {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<Country> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			int num = Integer.parseInt(temp[0]);
			int gold = Integer.parseInt(temp[1]);
			int silver = Integer.parseInt(temp[2]);
			int bronze = Integer.parseInt(temp[3]);
			list.add(new Country(num, gold, silver, bronze, 0)); //국가번호, 금메달 수, 은메달 수, 동메달 수, 등수
		}
		
		Collections.sort(list); //정렬

		list.get(0).rate = 1; //첫번째는 1등
		
		int end = 0;
		
		for(int i=1; i<list.size(); i++) {
			int g = list.get(i-1).gold;
			int s = list.get(i-1).silver;
			int b = list.get(i-1).bronze;
			Country cur = list.get(i);
			if(cur.num == k) {
				end = i;
			}
			if(cur.gold == g && cur.silver == s && cur.bronze == b) {
				cur.rate = list.get(i-1).rate;
			} else {
				cur.rate = i+1;
			}
		}
		System.out.println(list.get(end).rate);
	}	
}

class Country implements Comparable<Country> {
	int num, gold, silver, bronze, rate;
	
	Country(int num, int gold, int silver, int bronze, int rate) {
		this.num = num;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
		this.rate = rate;
	}

	@Override
	public int compareTo(Country c) {
		if(this.gold != c.gold) {
			return c.gold- this.gold;
		} 
		if(this.silver != c.silver) {
			return c.silver - this.silver;
		}
		return c.bronze - this.bronze;
	}
}