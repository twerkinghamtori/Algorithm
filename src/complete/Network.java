package complete;
import java.util.*;

public class Network {
	static List<int[]> list = new ArrayList<>();
	
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        
        for(int i=0; i<computers.length; i++) {
            for(int j=0; j<computers[i].length; j++) {
                if(i!=j) {
                    if(computers[i][j]==1 && computers[j][i]==1) {
                        int[] temp = new int[2];
                        temp[0] = i+1; temp[1] = j+1;
                        list.add(temp);
                    }
                }
            }
        }
        for(int[] arr : list) {
        	for(int i : arr) {
        		System.out.println(i);
        	}
        	System.out.println("==========");
        }
        return answer;
    }
	
	static void dfs(int n, int[][] computers) {
		
		for(int i=0; i<list.size(); i++) {
			if(i%2==0) {
				if(list.get(i)[1] == list.get(i+1)[0]) {
					dfs(n, computers);
				} 
			}
		}
	}
	
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1,1,0}, {1,1,1}, {0,1,1}};
		solution(n, computers);

	}

}
