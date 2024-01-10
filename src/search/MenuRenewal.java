package search;

import java.util.*;
import java.util.Map.Entry;

//프로그래머스 메뉴리뉴얼 dfs
public class MenuRenewal {
	
	static Map<String, Integer> map;
	
	public String[] solution(String[] orders, int[] course) {
		
        List<String> answerList = new ArrayList<>();
        
        //답을 오름차순으로 정렬하기 위해 주문을 오름차순으로 미리 정렬
        for(int i=0; i<orders.length; i++) {
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }
        
        //course를 반복하면서 필요한 조합을 구함
        for(int i=0; i<course.length; i++) {
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            for(int j=0; j<orders.length; j++) {
                StringBuilder sb = new StringBuilder();
                if(course[i] <= orders[j].length()) {
                    combi(orders[j], sb, 0, 0, course[i]);
                }
            }
            
            //가장 많이 주문한 횟수 구하기
            for(Entry<String,Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue()); 
            }
            
            //최소 2번 이상 주문 && 가장 많이 주문한 횟수와 같은 경우 답 배열에 추가
            for(Entry<String,Integer> entry : map.entrySet()) {
                if(max >= 2 && entry.getValue() == max) {
                    answerList.add(entry.getKey());
                }
            }
        }
        
        Collections.sort(answerList);
        
        String[] answer = new String[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    static void combi(String order, StringBuilder sb, int idx, int cnt, int n) {
    	//개수가 코스 조합 수와 같다면
        if(cnt == n) {
        	//map에 삽입 및 카운팅
            map.put(sb.toString(), map.getOrDefault(sb.toString(),0)+1);
            return;
        }
        
        for(int i=idx; i<order.length(); i++) {
            sb.append(order.charAt(i));
            combi(order, sb, i+1, cnt+1, n);
            sb.delete(cnt, cnt+1);
        }
    }
}
