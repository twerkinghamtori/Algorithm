
import java.util.*;
import java.io.*;

public class Note {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(st.nextToken()); //단어 수
		int m = Integer.parseInt(st.nextToken()); //단어 길이
		Map<String, Integer> words = new HashMap<>();
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			if(s.length() >= m) {
				words.put(s,(words.getOrDefault(s, 0)+1));
			}			
		}
		String [] dic = new String[words.size()];
		int idx = 0;
		for(String s : words.keySet()) {
			dic[idx] = s;
			idx++;
		}
		
		//알파벳 순 정렬
		Arrays.sort(dic);

		//길이 긴 순서로 정렬
		Arrays.sort(dic, (o1,o2) -> o2.length() - o1.length());
		
		//자주 나오는 순서로 정렬
		Arrays.sort(dic, (o1, o2) -> words.get(o2) - (words.get(o1)));
		
		for(String s : dic) {
			bw.write(s + "\n");
		}
		bw.flush();
	}
}
