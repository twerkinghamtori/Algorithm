package complete;
import java.util.*;
/*
수포자는 수학을 포기한 사람의 준말입니다. 
수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 */

//점수 구하는 건 금방했는데, 점수 정렬해서 index 쓰는데서 헤맴ㅠ -> clone()으로 해결
public class MockTest {
	public static int[] solution(int[] answers) {
		//3명 패턴
		int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        //점수 저장
        int[] score = new int[3];
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == p1[i%p1.length]) score[0]++;
            if(answers[i] == p2[i%p2.length]) score[1]++;
            if(answers[i] == p3[i%p3.length]) score[2]++;
        }
        
        //정렬할 배열
        int[] sortScore = score.clone();   
        //오름차순 정렬
        Arrays.sort(sortScore);
        //최고점 저장
        int max = sortScore[2];       
        
        List<Integer> answerList = new ArrayList<>();
        
        for(int i=0; i<score.length; i++) {
        	//최고점이랑 같은 점수가 있다면
        	if(score[i]==max) {
        		//score배열 index+1 = 수포자 번호
        		answerList.add(i+1);
        	}
        }
        //list -> 배열
        int[] answer = answerList.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
