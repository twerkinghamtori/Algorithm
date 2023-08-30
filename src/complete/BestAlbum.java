package complete;

import java.util.*;

/*
스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 
노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

1.속한 노래가 많이 재생된 장르를 먼저 수록합니다.
2.장르 내에서 많이 재생된 노래를 먼저 수록합니다.
3.장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 
베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 */


// <장르, 횟수 합> -> 정렬 -> <고유번호, 횟수> -> 정렬 -> answerList 추가 -> list 배열로 변환

public class BestAlbum {
	public static int[] solution(String[] genres, int[] plays) {
		List<Integer> answerList = new ArrayList<>();
		//<장르, 재생횟수의 합>
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
        	if(!hm.containsKey(genres[i])) {
        		hm.put(genres[i], plays[i]);
        	} else {
        		int gp = hm.get(genres[i]);
        		gp += plays[i];
        		hm.put(genres[i], gp);
        	}
        }
        //장르별 재생횟수에 따라 내림차순으로 해시맵 정렬
        List<String> list =  new ArrayList<>(hm.keySet());
        if(list.size()>=2) { //장르가 1개만 존재할 경우 제외
            list.sort((i1,i2) -> hm.get(i2) - hm.get(i1));
        }
        //내림차순 정렬된 장르 순서대로 하나씩 반복
        for(String s : list) {
        	//<고유번호, 재생횟수>
        	HashMap<Integer, Integer> hm2 = new HashMap<>();
            for(int i=0; i<genres.length; i++) {
                if(genres[i].equals(s)) {
                    hm2.put(i, plays[i]);
                }
            }
            //고유번호 별 재생횟수에 따라 내림차순으로 정렬
            List<Integer> list2 = new ArrayList<>(hm2.keySet());         
            if(list2.size() < 2) { //고유번호가 1개만 존재할 경우
                answerList.add(list2.get(0));
            } else {
                list2.sort((o1,o2) -> hm2.get(o2)-hm2.get(o1));  
                //재생횟수 같은 경우, 고유번호가 낮은 노래 먼저 수록(3번 조건)
                if(list2.get(0) == list2.get(1) && list2.get(0) > list2.get(1)) {
                        answerList.add(list2.get(1));
                        answerList.add(list2.get(0));
                } else {
                  answerList.add(list2.get(0));
                  answerList.add(list2.get(1));  
                }               
            }             
        }        
        //list -> 배열
        int[] answer = answerList.stream().mapToInt(i->i).toArray();
        return answer;
	}
}
