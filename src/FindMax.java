import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/*
×9 격자판에 쓰여진 81개의 자연수 또는 0이 주어질 때, 
이들 중 최댓값을 찾고 그 최댓값이 몇 행 몇 열에 위치한 수인지 구하는 프로그램을 작성하시오.
<입력예시>
3	23	85	34	17	74	25	52	65
10	7	39	42	88	52	14	72	63
87	42	18	78	53	45	18	84	53
34	28	64	85	12	16	75	36	55
21	77	45	35	28	75	90	76	1
25	87	65	15	28	11	37	28	74
65	27	75	41	7	89	78	64	39
47	47	70	45	23	65	3	41	44
87	13	82	38	31	12	29	29	80
<출력예시>
90
5 7
*/
public class FindMax {
	private static int[][] arr =   {{3,23,85,34,17,74,25,52,65},
									{10,7,39,42,88,52,14,72,63},
									{87,42,18,78,53,45,18,84,53},
									{34,28,64,85,12,16,75,36,55},
									{21,77,45,35,28,75,90,76,1},
									{25,87,65,15,28,11,37,28,74},
									{65,27,75,41,7,89,78,64,39},
									{47,47,70,45,23,65,3,41,44},
									{87,13,82,38,31,12,29,29,80}};
	public static void main(String[] args) {
		int[] max = new int[9]; 
		int maxcol=0; int maxrow=0;
		int maxnum = arr[0][0];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length-1; j++) {
				if(maxnum<arr[i][j+1]) {
					maxnum = arr[i][j+1];
					maxcol = j+2;
					maxrow = i+1;
				} 
			}
		}
		System.out.println(maxnum);
		System.out.println(maxrow + "\t" + maxcol);
	}
}
