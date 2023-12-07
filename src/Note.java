
import java.util.*;
import java.io.*;

public class Note {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(n>0) {
			n--;
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int[] cnt= new int[m+1];
			int[] arr = new int[m+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=m; i++) {
				int team = Integer.parseInt(st.nextToken());
				arr[i] = team;
				cnt[team]++;
			}
			int[] score = new int[m+1];
			int s = 1;
			for(int i=1; i<=m; i++) {
				if(cnt[arr[i]]<6) {
					continue;
				} else {
					score[i] = s;
					s++;
				}
			}
			Map<Integer, ArrayList<Integer>> map = new HashMap<>();
			for(int i=1; i<=m; i++) {
				if(score[i] != 0) {
					if(!map.containsKey(arr[i])) {
						map.put(arr[i], new ArrayList<>());						
					} map.get(arr[i]).add(score[i]);
				}
			}
			Map<Integer, Integer> scoreMap = new HashMap<>();
			for(int i : map.keySet()) {
				int sum = 0;
				for(int z=0; z<4; z++) {
					sum+=map.get(i).get(z);
				}
				scoreMap.put(i,sum);
			}
			int minScore = Integer.MAX_VALUE;
			for(int i : scoreMap.keySet()) {
				if(scoreMap.get(i) < minScore) {
					minScore = scoreMap.get(i);
				}
			}
			List<Integer> winners = new ArrayList<>();
			for(int i : scoreMap.keySet()) {
				if(scoreMap.get(i) == minScore) {
					winners.add(i);
				}
			}
			int winner = winners.get(0);
			if(winners.size() == 1) {
				winner = winners.get(0);
			} else {
				for(int i=1; i<winners.size(); i++) {
					int team2 = winners.get(i);
					if(map.get(winner).get(4) == map.get(team2).get(4)) {
						if(map.get(winner).get(5) > map.get(team2).get(5)) {
							winner = team2;
						}
					} else if(map.get(winner).get(4) > map.get(team2).get(4)) {
						winner = team2;
					}
				}
			}
			bw.write(winner + "\n");
		}
		bw.flush();
	}
}
