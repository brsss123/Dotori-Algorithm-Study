import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N; // 수빈
	static int K; // 동생
	static int max=100000;
	static int invisited[];
	public static void main(String[]args)throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		invisited=new int[max+1];
		BFS(N);
	
	}
	static void BFS(int N) {
		
	 Queue<Integer>q=new LinkedList<>();
	 q.add(N);
     invisited[N]=1;
	 while(!q.isEmpty()) {
		 int temp=q.poll();
		 if(temp==K) {
			
			 System.out.println(invisited[temp]-1);
             break;
		 }
		 if(temp+1<=max&& invisited[temp+1]==0){			 
		     invisited[temp+1]=invisited[temp]+1;
			 q.add(temp+1);
		  
		 }
		 if(temp*2<=max&&invisited[temp*2]==0) {
			 invisited[temp*2]=invisited[temp]+1;
			 q.add(temp*2);
		 }
		 if(temp-1>=0&&invisited[temp-1]==0) {
			 invisited[temp-1]=invisited[temp]+1;
			 q.add(temp-1);
			 
		 }		 
	 }
		
		
	}
}
