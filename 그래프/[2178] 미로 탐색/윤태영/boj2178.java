package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BACK2178 {

	static int N;
	static int M;
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,1,-1};
	static int adj[][];
	
	static boolean visited[][];
	public static void main(String[]args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
	     
		adj=new int[N+1][M+1];
		visited=new boolean[N+1][M+1];
		
		for(int x=1;x<=N;x++){
			 
		    String[]arr=br.readLine().split("");
			for(int y=1;y<=M;y++) {
				//String arr 로 값을 받고 arr.charAt(y-1)-'0' 정수로 출력			
				adj[x][y]=Integer.parseInt(arr[y-1]);				
			}
		}
				
		bfs(1,1);
		System.out.println(adj[N][M]);	
	}
	static void bfs(int x, int y) {
		Queue<int[]>q=new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y]=true;
		while(!q.isEmpty()) {
			int temp[]=q.poll();
			for(int k=0;k<4;k++) {
				int a=temp[0]+dx[k];
				int b=temp[1]+dy[k];
	           if(a>0 && b>0 && b<=M&&a<=N) {
	        	   if(adj[a][b]==1 && visited[a][b]==false) {
	        		      visited[a][b]=true;	 
                 //이전 값기준 +
	        		      adj[a][b]=adj[temp[0]][temp[1]]+1;
	        		     q.add(new int[] {a,b});	        		   
	        		   
	        	   }
	           }			
   				
			}
			
			
		}
		
		
	}
	
	//생성자를 생성해서 위에서 큐선언시 Queue<Point>q=new LinkedList<>(); 선언하고 값 삽입시 객체 형태 q.add(new Point(x,y)) .. temp.x / temp.y
//	static class Point {
//		int x;
//		int y;
//		Point(int x,int y){
//			this.x=x;
//			this.y=y;
//			
//		}
//		
//	}
}
