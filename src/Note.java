
import java.util.*;
import java.io.*;

public class Note {
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
				cursor.remove();
			} else if(command.equals("P")) {
				String word = st.nextToken();
                for (char c : word.toCharArray()) {
                    cursor.add(c);
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

