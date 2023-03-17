package complete;


import java.util.Arrays;

/*
다음의 희소 행렬을 2차원 배열의 논리적 구조로 표현하시오.
 	A=	0	0	0	9			B = 7	4	4
 		0	1	0	0				0	3	9			
 		0	0	0	0				1	1	1				
		0	0	7	0				3	2	7			
 		0	0	0	0				5	0	3				
		3	0	0	0
 		0	0	0	0
 		
 	B 배열 : 7 4 4 : A배열의 행의수,열의수,값의갯수
 	        0 3 9 : A배열의 0행3열 값:9
 	        1 1 1 : A배열의 1행1열 값:1	
 	        3 2 7 : A배열의 3행2열 값:7	
 	        5 0 3 : A배열의 5행0열 값:3	
 */
public class MatrixInfo {
	public static void main(String[] args) {
		int[][] a = {
				{0,0,0,9},
				{0,1,0,0},
				{0,0,0,0},
				{0,0,7,0},
				{0,0,0,0},
				{3,0,0,0},
				{0,0,0,0}
			};	
		int b[][] = new int [5][3];
		
		int colcnt=0, rowcnt=0, valuecnt = 0;;
		for(int i=0; i<a.length; i++) {
			   rowcnt++;
		    for(int j=0; j<a[i].length; j++) {
				if(i==0) colcnt++;
				if(a[i][j] != 0) valuecnt++;
		    }
		}		

		b[0][0] = rowcnt;
		b[0][1] = colcnt;
		b[0][2] = valuecnt;
		
		int ridx=0, cidx=0, vidx=0;
		int colnum[] = new int[valuecnt];
		int rownum[] = new int[valuecnt];
		int value[] = new int[valuecnt];
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				if(a[i][j]!=0) {
					rownum[ridx++]=i;
					colnum[cidx++]=j;
					value[vidx++]=a[i][j];
				}
			}
		}
		
		for(int i=1; i<=4; i++) {
			b[i][0] = rownum[i-1];
			b[i][1] = colnum[i-1];
			b[i][2] = value[i-1];
		}
		
		for(int i=0; i<b.length; i++) {
			for(int j=0; j<b[i].length; j++) {
				System.out.print(b[i][j] + "\t");
			}
			System.out.println();
		}
		
		

	}
}