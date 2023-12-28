package complete;

//프로그래머스 2018 KAKAO BLIND RECUIRMENT [3차]방금 그곡 구현
public class ThatSong {
	public static void main(String args[]) {
		String m = "CC#BCC#BCC#BCC#B";
		String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		System.out.println(solution(m,musicinfos));
	}
	
	public static String solution(String m, String[] musicinfos) {
		String answer = "";
        
		//재생 시간이 가장 긴 제목을 반환하기 위해 지난 재생 시간을 저장 할 변수
        int lastruntime = 0; 
        
        //#이 붙은 음을 소문자로 대체
        m = m.replaceAll("C#","c");
        m = m.replaceAll("D#","d");
        m = m.replaceAll("F#","f");
        m = m.replaceAll("G#","g");
        m = m.replaceAll("A#","a");
        
        for(String s : musicinfos) {
            String[] sarr = s.split(",");
            
            //경과 시간 계산
            int startH = Integer.parseInt(sarr[0].substring(0,2));
            int startM = Integer.parseInt(sarr[0].substring(3,5));
            int endH = Integer.parseInt(sarr[1].substring(0,2));
            int endM = Integer.parseInt(sarr[1].substring(3,5));
            int runtime = (endH-startH)*60 + (endM - startM);

            //#이 붙은 음을 소문자로 대체
            sarr[3] = sarr[3].replaceAll("C#","c");
            sarr[3] = sarr[3].replaceAll("D#","d");
            sarr[3] = sarr[3].replaceAll("F#","f");
            sarr[3] = sarr[3].replaceAll("G#","g");
            sarr[3] = sarr[3].replaceAll("A#","a");            
            
            //재생 시간 만큼 melody 변환
            String melody = "";
            int idx = 0;
            while(idx < runtime) {
                melody += sarr[3].substring(idx%sarr[3].length(),idx%sarr[3].length()+1); 
                idx++;
            }

            int c = melody.indexOf(m);
            
            //멜로디에 m이 존재하고, 재생시간이 더 긴 경우 교체
            if(c != -1 && runtime > lastruntime) {
            	answer = sarr[2];
        		lastruntime = runtime;
            }             
        }
        return answer.equals("")?"(None)":answer;
    }
}
