package complete;

import java.util.*;

//프로그래머스 다리를 지나는 트럭 큐
public class TruckPassingBridge {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitQ = new LinkedList<>();//대기 트럭
        Queue<Integer> progressQ = new LinkedList<>(); //건너는 트럭
        Queue<Integer> timeQ = new LinkedList<>(); //경과시간
        
        //대기 큐에 각 트럭 무게 삽입
        for(int truckWeight : truck_weights) {
            waitQ.add(truckWeight);
        }
        
        int minute = 0; //전체 경과 시간
        int bridgeWeight = 0; //현재 다리 중량
        int bridgeTruckCnt = 0; //현재 다리 위의 트럭 수
        int totalCnt = 0; //다리를 지난 트럭 수
        
      //다 건넌 트럭 수(totalCnt)가 전체 트럭수(truck_weights.length)와 같아지기 전까지 반복
        while(totalCnt != truck_weights.length) { 
            minute++; //진입 경과시간 +1
            
            //다리를 건너는 시간과 다리 길이와 일치할 때,
            if(timeQ.peek() != null && timeQ.peek() == bridge_length) {
                timeQ.poll(); //해당 시간을 poll
                bridgeWeight -= progressQ.poll(); //현재 다리 위의 무게에서 지나간 트럭 무게 뺌
                bridgeTruckCnt -= 1; //다리 위 트럭수 -1
                totalCnt++; //지나간 트럭 수 +1
            }
            
            //아직 대기 중인 트럭이 있을 때,
            if(waitQ.peek() != null) {
                int truck = waitQ.peek();
                //트럭 무게와 현재 중량이 수용중량을 넘지 않고, 다리 위에 있는 트럭 수가 수용가능 수를 넘지 않을 때,
                if(truck + bridgeWeight <= weight && bridgeTruckCnt <= bridge_length) {
                    bridgeWeight += truck; //현재 다리 위의 트럭 무게 추가
                    bridgeTruckCnt++; //현재 다리 위의 트럭 수 추가
                    progressQ.add(waitQ.poll()); //대기 큐에서 빼서 진행큐에 삽입
                    timeQ.add(0); //시간큐에 0삽입
                }
            }
            
            for(int i=0; i<timeQ.size(); i++) {
                timeQ.add(timeQ.poll()+1);
            }
        }
        return minute;
    }
}
