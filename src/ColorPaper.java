import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/*가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다. 
이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다. 
이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.
첫째 줄에 색종이의 수가 주어진다. 
이어 둘째 줄부터 한 줄에 하나씩 색종이를 붙인 위치가 주어진다.
 색종이를 붙인 위치는 두 개의 자연수로 주어지는데 
 첫 번째 자연수는 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리이고,
 두 번째 자연수는 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리이다. 
 
(주의!) 색종이의 수는 100 이하이며, 색종이가 도화지 밖으로 나가는 경우는 없다
   ex) 91 10 or 10 91을 입력하면 색종이가 도화지 밖으로 나간다.
<입력예시>
색종이 갯수를 입력하세요.
3
각 종이의 위치를 입력하세요. (왼쪽 변과의 거리, 아래쪽 변과의 거리
3 7
15 7
5 2
<출력예시>
260
*/
public class ColorPaper {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("색종이 갯수를 입력하세요.");
		int hm = scan.nextInt();
		System.out.println("각 종이의 위치를 입력하세요.");
		int[][] square = new int [100][100];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println(br.readLine());
		//사각형 만큼 1씩 배열 값을 증가시켜서 겹치는 부분=2이상, 그러면 1인 부분만 count.
		//개어렵다 ㅁㅊ 
		String[] arr = new String[hm];
		for(int i=0; i<hm; i++) {
			arr[i]=br.readLine();
		}
		Function<String, Integer> f =  s-> {
			String[] str = s.split(" ");
			int left = Integer.parseInt(str[0]);
			int bottom = Integer.parseInt(str[1]);
			for(int i=1; i<=10; i++) {
				for(int j=0; j<10; j++) {
					square[100-bottom-i][left+j]=1;
				}
			}
			
			int cnt=0;
			for(int i=0; i<square.length; i++) {
				for(int j=0; j<square[i].length; j++) {
					if(square[i][j]==1) {
						cnt++;
					}
				}				
			}
			return cnt;
		};
		List<Integer> list = Arrays.asList(arr).stream().map(f).collect(Collectors.toList());
		System.out.println(list.get(hm-1));
	}
}
