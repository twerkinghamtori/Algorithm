package complete;

import java.util.*;
import java.io.*;

//백준 1406 에디터 LinkedList, ListIterator
//substring -> 시간초과 -> ListIterator로 해결
public class Editor {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int m = Integer.parseInt(br.readLine());
		
		LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        
        ListIterator<Character> cursor = list.listIterator(list.size());

		while(m>0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(command.equals("L") && cursor.hasPrevious()) {
				cursor.previous();
			} else if(command.equals("D") && cursor.hasNext()) {
				cursor.next();
			} else if(command.equals("B") && cursor.hasPrevious()) {
				cursor.previous();
				cursor.remove(); //최근 커서 위치의 인덱스에서 삭제
			} else if(command.equals("P")) {
				String word = st.nextToken();
                for (char c : word.toCharArray()) {
                    cursor.add(c); //최근 커서 위치의 인덱스에서 추가
                }
			}
			m--;
		}
		
		StringBuilder sb = new StringBuilder();
		for (char c : list) {
			sb.append(c);
        }
		System.out.println(sb.toString());
	}
}

