package incomplete;


import java.util.*;
import java.io.*;

//백준 1205 등수 구하기 미해결
public class Rating {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long score = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		List<Person> list = new ArrayList<>();
		if(n == 0) System.out.println(1);
		else {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				list.add(new Person(i, Long.parseLong(st.nextToken()),0));			
			}
			list.get(0).rate = 1;
			
			list.add(new Person(-1, score, 0));
			
			Collections.sort(list);
			
			for(int i=1; i<list.size(); i++) {
				Person cur = list.get(i);
				if(cur.score == list.get(i-1).score) cur.rate = list.get(i-1).rate;
				else cur.rate = i+1;
				if(list.get(i).num == -1) {
					if(i+1 > p && p==n) System.out.println(-1);
					else System.out.println(list.get(i).rate);
				}
			}
			
//			for(int i=0; i<list.size(); i++) {
//				System.out.println(list.get(i).num + " " + list.get(i).score + " " + list.get(i).rate);
//			}
		}		
		
	}
}

class Person implements Comparable<Person> {
	int num,rate;
	long score;
	Person(int num, long score, int rate) {
		this.num = num;
		this.score = score;
		this.rate = rate;
	}
	@Override
	public int compareTo(Person p) {
		return (int)(p.score- this.score);
	}
}
