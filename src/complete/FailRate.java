package complete;
import java.util.*;

//프로그래머스 실패율
//실패율 높은 순으로 정렬은 빨리 했는데 단계로 표현하는게 오래 걸림
//map으로 (index, 실패율)로 나타내고 실패율 순서대로 정렬했으면 더 빨랐을 듯
public class FailRate {
	public int[] solution(int N, int[] stages) {
		//실패율 계산
        Arrays.sort(stages);
        int[] arr = new int[N+1];
        for(int i=0; i<stages.length; i++) {
            arr[stages[i]-1]++;
        }
        int sum = 0;
        for(int i : arr) {
            sum += i;
        }
        float[] farr = new float[N];
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i]==0 && sum == 0) {
                farr[i] = 0;
            } else {
                farr[i] = (float)arr[i]/(float)sum;
            }
            sum -= arr[i];
        }
        
        //단계로 표현
        float[] copy = Arrays.copyOf(farr, farr.length);
        Arrays.sort(farr);
        int[] answer = new int[N];
        List<Integer> temp = new ArrayList<>();
        for(int i=farr.length-1; i>=0; i--) {
            for(int j=0; j<copy.length; j++) {
                if(farr[i] == copy[j]) {
                    temp.add(j+1);
                    copy[j] = -1;
                    continue;
                }
            }
        }
        for(int i=0; i<temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        return answer;
    }
}
