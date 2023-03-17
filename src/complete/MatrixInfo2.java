package complete;

/*
다음의 희소 행렬을 2차원 배열의 논리적 구조로 표현하시오.
	A=	7	4	4			B = 0	0	0	9 
		0	3	9				0	1	0	0				
		1	1	1				0	0	0	0				
		3	2	7				0	0	7	0			
		5	0	3 				0	0	0	0				
								3	0	0	0
								0	0	0	0
								
 	A 배열 : 7 4 4 : A배열의 행의수,열의수,값의갯수
 	        0 3 9 : A배열의 0행3열 값:9
 	        1 1 1 : A배열의 1행1열 값:1	
 	        3 2 7 : A배열의 3행2열 값:7	
 	        5 0 3 : A배열의 5행0열 값:3
 	        
    B 배열 : A 배열에서 지정된 내용으로 그대로 배열 복원하기	        
*/
public class MatrixInfo2 {
	static int[][] a = {
			{7,4,4},
			{0,3,9},
			{1,1,1},
			{3,2,7},
			{5,0,3}};
	public static void main(String[] args) {
		int b[][] = new int[a[0][0]][a[0][1]];
		
	for(int i=1; i<a.length; i++) {
		b[ a[i][0] ][ a[i][1] ]=a[i][2];
	}
	
	for(int i=0; i<b.length; i++) {
		for(int j=0; j<b[i].length; j++) {
			System.out.print(b[i][j] + "\t");
		}
		System.out.println();
	}

	}
}