package complete;


import java.util.*;
import java.io.*;

//백준 3758 KCPC 정렬
public class KCPC {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(st.nextToken());
		while(T>0) {
			T--;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); //팀 개수
			int k = Integer.parseInt(st.nextToken()); //문제 수
			int t = Integer.parseInt(st.nextToken()); //팀 id
			int m = Integer.parseInt(st.nextToken()); //로그 엔트리
			
			int[][] score = new int[n+1][k+1]; //팀별, 문제별 점수
			int[] log = new int[n+1]; //로그 횟수 체크
			int[] last = new int[n+1]; //마지막 제출 체크
			
			List<Team> list = new ArrayList<>();
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());				
				int id = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				score[id][num] = Math.max(score[id][num], s); //같은 문제에 제출 시 높은 점수 저장
				log[id]++;
				last[id] = i;
			}
			
			int[] sarr = new int[n+1]; //팀별 점수 합
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=k; j++) {
					sarr[i] += score[i][j];
				}				
			}
			
			for(int i=1; i<=n; i++) {
				list.add(new Team(i, sarr[i], log[i], last[i]));
			}
			
			//정렬(점수 높은 순 -> 제출(로그) 적은 순 -> 마지막 제출이 빠른 순)
			Collections.sort(list);

			//우리 팀 순위 출력
			for(int i=0; i<list.size(); i++) {
				Team team = list.get(i);
				if(team.id == t) {
					bw.write((i+1) + "\n"); 
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

class Team implements Comparable<Team> {
	int id,score,log, last;
	Team(int id, int score, int log, int last) {
		this.id = id;
		this.score = score;
		this.log = log;
		this.last = last;
	}
	@Override
	public int compareTo(Team t) {
		if(t.score != this.score) {
			return t.score - this.score;
		} else if(t.log != this.log) {
			return this.log - t.log;
		} else {
			return this.last - t.last;
		}
	}	
}

