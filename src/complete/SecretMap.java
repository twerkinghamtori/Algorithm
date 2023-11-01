package complete;

//프르그래머스 [1차] 비밀지도
//Integer.toBinaryString(arr1[i] | arr2[i]) -> 10진수를 2진수로 변환 -> arr1, arr2 OR 비트연산
//위 메서드로 한 번에 풀 수 있었음ㅠ
public class SecretMap {
	public String[] solution(int n, int[] arr1, int[] arr2) {        
        String[][] map1 = new String[n][n];
        String[][] map2 = new String[n][n];
        for(int i=0; i<arr1.length; i++) {
            int pw1 = arr1[i];
            int pw2 = arr2[i];
            for(int j=n-1; j>=0; j--) {
                if(pw1%2 == 1) {
                    map1[i][j] = "#";
                } else {
                    map1[i][j] = " ";
                }
                if(pw2%2 == 1) {
                    map2[i][j] = "#";
                } else {
                    map2[i][j] = " ";
                }
                pw1/=2;
                pw2/=2;
            }
        }
        
        String[] answer = new String[n];
        for(int i=0; i<map1.length; i++) {
            String s = "";
            for(int j=0; j<map1[i].length; j++) {
                if(map1[i][j].equals(" ") && map2[i][j].equals(" ")) {
                    s += " ";
                } else {
                    s += "#";
                }
            }
            answer[i] = s;
        }
        return answer;
    }
}
