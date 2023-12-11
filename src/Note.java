
import java.util.*;
import java.io.*;

//백준 19637 IF문 좀 대신 써줘 이분탐색
public class Note {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[][] title=new String[n][2];
		
		for(int i=0;i<n;i++){
		    st=new StringTokenizer(br.readLine());
		    title[i][0]=st.nextToken();
		    title[i][1]=st.nextToken();
		}
		
		//이분탐색
		for(int i=0;i<m;i++){
            int num=Integer.parseInt(br.readLine());

            int left=0;
            int right=n-1;
            int mid=(left+right)/2;
            while(left<=right){
                mid=(left+right)/2;

                int titleInt=Integer.parseInt(title[mid][1]);
                if(titleInt<num){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }

            bw.write(title[left][0]+"\n");
        }
		bw.flush();
	}
}
