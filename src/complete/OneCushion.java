package complete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * 프로그래머스의 마스코트인 머쓱이는 최근 취미로 당구를 치기 시작했습니다.
머쓱이는 손 대신 날개를 사용해야 해서 당구를 잘 못 칩니다. 
하지만 끈기가 강한 머쓱이는 열심히 노력해서 당구를 잘 치려고 당구 학원에 다니고 있습니다.
오늘도 당구 학원에 나온 머쓱이에게 당구 선생님이"원쿠션"(당구에서 공을 쳐서 벽에 맞히는 걸 쿠션이라고 부르고, 벽에 한 번 맞힌 후 공에 맞히면 원쿠션이라고 부릅니다) 
연습을 하라면서 당구공의 위치가 담긴 리스트를 건네줬습니다. 
리스트에는 머쓱이가 맞춰야 하는 공들의 위치가 담겨있습니다. 
머쓱이는 리스트에 담긴 각 위치에 순서대로 공을 놓아가며 "원쿠션" 연습을 하면 됩니다. 
이때, 머쓱이는 항상 같은 위치에 공을 놓고 쳐서 리스트에 담긴 위치에 놓인 공을 맞춥니다.
머쓱이와 달리 최근 취미로 알고리즘 문제를 풀기 시작한 당신은, 머쓱이가 친 공이 각각의 목표로한 공에 맞을 때까지 최소 얼마의 거리를 굴러가야 하는지가 궁금해졌습니다.
당구대의 가로 길이 m, 세로 길이 n과 머쓱이가 쳐야 하는 공이 놓인 위치 좌표를 나타내는 두 정수 startX, startY, 
그리고 매 회마다 목표로 해야하는 공들의 위치 좌표를 나타내는 정수 쌍들이 들어있는 2차원 정수배열 balls가 주어집니다. 
"원쿠션" 연습을 위해 머쓱이가 공을 적어도 벽에 한 번은 맞춘 후 목표 공에 맞힌다고 할 때, 
각 회마다 머쓱이가 친 공이 굴러간 거리의 최솟값의 제곱을 배열에 담아 return 하도록 solution 함수를 완성해 주세요.
단, 머쓱이가 친 공이 벽에 부딪힐 때 진행 방향은 항상 입사각과 반사각이 동일하며, 
만약 꼭짓점에 부딪힐 경우 진입 방향의 반대방향으로 공이 진행됩니다. 
공의 크기는 무시하며, 두 공의 좌표가 정확히 일치하는 경우에만 두 공이 서로 맞았다고 판단합니다. 
공이 목표 공에 맞기 전에 멈추는 경우는 없으며, 목표 공에 맞으면 바로 멈춘다고 가정합니다.
[입출력 예]
m    n   startX   startY            balls                 result
10   10    3        7       [[7, 7], [2, 7], [7, 3]]    [52, 37, 116]
[그림예시]
https://school.programmers.co.kr/learn/courses/30/lessons/169198
*/
public class OneCushion {
	//점들 간 거리 구하는 공식이 아니라 피타고라스 공식으로 직각삼각형 만들어서 빗변의 길이로 거리 구함.
	static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int [balls.length];
        int[] arr = new int[4];
        for(int i=0; i<balls.length; i++) {
        	if(startY==balls[i][1]) { //y좌표가 같은 선상에 있는 경우
        		int minY = Math.min(n-startY, startY);
        		arr[0]=(int)Math.pow(balls[i][0]-startX, 2) + (int)Math.pow(minY*2, 2);
        		if(startX<balls[i][0]) { //직선 원쿠션
        			arr[1]=(int)Math.pow(startX+balls[i][0], 2);
        		}else{
        			arr[1]=(int)Math.pow((m-startX)+(m-balls[i][0]), 2);
        		}
        		answer[i] = Math.min(arr[0], arr[1]);
        	}
        	else if(startX==balls[i][0]) { //x좌표가 같은 선상에 있는 경우
        		int minX=Math.min(m-startX, startX);
        		arr[0]=(int)Math.pow(balls[i][1]-startY,2) + (int)Math.pow(minX*2, 2);
        		if(startY<balls[i][1]) {
        			arr[1]=(int)Math.pow(startY+balls[i][1], 2);
        		}else {
        			arr[1]=(int)Math.pow((n-startY)+(n-balls[i][1]), 2);
        		}
        		answer[i] = Math.min(arr[0], arr[1]);
        	}
        	else {
        		//x가 m(벽)과과 가까운 경우
        		arr[0] = (int)Math.pow((m-startX)+(m-balls[i][0]), 2) + (int)Math.pow(startY-balls[i][1], 2);
        		//x가 0과 가까운 경우
        		arr[1] = (int)Math.pow(startX+balls[i][0], 2) + (int)Math.pow(startY-balls[i][1], 2);
        		//y가 n(벽)과 가까운 경우ㄴ
        		arr[2] = (int)Math.pow((n-startY)+(n-balls[i][1]), 2) + (int)Math.pow(balls[i][0]-startX, 2);
        		//y가 0과 가까운 경우
        		arr[3] = (int)Math.pow(startY+balls[i][1], 2) + (int)Math.pow(balls[i][0]-startX, 2);
        		
        		//최소값
        		int min = arr[0];
        		for(int a=0; a<arr.length; a++) {
        			if(min>arr[a]) {
        				min=arr[a];
        			}
        		}
        		answer[i]=min;
        	}        	
        }
        return answer;
    }

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10,10,3,7, new int[][] {{7,7}, {2,7}, {7,3}})));
	}

}