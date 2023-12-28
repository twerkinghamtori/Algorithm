
import java.util.*;
import java.io.*;

public class Note {
	public static void main(String args[]) throws IOException {
		String m = "A";
		String[] musicinfos = {"12:00,12:01,Sing,A", "12:00,12:01,Song,A"};
		System.out.println(solution(m,musicinfos));
	}
	
	public static String solution(String m, String[] musicinfos) {
String answer = "";
        
        int lastruntime = 0;
        
        for(String s : musicinfos) {
            String[] sarr = s.split(",");
            int startH = Integer.parseInt(sarr[0].substring(0,2));
            int startM = Integer.parseInt(sarr[0].substring(3,5));
            int endH = Integer.parseInt(sarr[1].substring(0,2));
            int endM = Integer.parseInt(sarr[1].substring(3,5));
            int runtime = (endH-startH)*60 + (endM - startM);
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<sarr[3].length()-1; i++) {
                String temp = sarr[3].substring(i,i+2);
                if(temp.charAt(1) == '#') {
                    sb.append(temp.substring(0,1).toLowerCase());
                } else if(temp.charAt(0) == '#') {
                    continue;
                } else {
                    sb.append(temp.substring(0,1));
                }
            }
            if(sarr[3].charAt(sarr[3].length()-1) != '#') {
                sb.append(sarr[3].substring(sarr[3].length()-1,sarr[3].length()));
            }
            //System.out.println(sb.toString());
            
            String melody = "";
            int idx = 0;
            while(idx < runtime) {
                String code = sb.substring(idx%sb.length(),idx%sb.length()+1); 
                if(code.equals(code.toLowerCase())) {
                    melody += code.toUpperCase() + "#";
                } else {
                    melody += code;
                }
                idx++;
            }
            //System.out.println(melody);
            int c = melody.indexOf(m);
            
            System.out.println(c);
            
            if(c != -1) {
            	if(c+m.length() >= melody.length()) {
            		if(runtime > lastruntime ) {
            			answer = sarr[2];
                		lastruntime = runtime;
            		}
            	} else if(!melody.substring(c+m.length(),c+m.length()+1).equals("#")) {
            		if(runtime > lastruntime ) {
            			answer = sarr[2];
                		lastruntime = runtime;
            		}
            	} 
            }
            System.out.println(runtime + " " + lastruntime);
        }
        return answer.equals("")?"(None)":answer;
    }
}

