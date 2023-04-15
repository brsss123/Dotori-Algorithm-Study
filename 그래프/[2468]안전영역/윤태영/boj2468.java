import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	
	static int N;// 정사각형의 변의 길이
	static int map[][];
	static boolean safe[][];
	static boolean visited[][];
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,1,-1};
	static int max=Integer.MIN_VALUE;
	public static void main(String[]args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     N=Integer.parseInt(br.readLine());
	     map=new int[N][N];
	     for(int i=0;i<N;i++) {
	    	 StringTokenizer st=new StringTokenizer(br.readLine());
	    	 for(int j=0;j<N;j++) {
	    		 int a=Integer.parseInt(st.nextToken());
	    		 map[i][j]=a;	    		 
	    	 }	    	 
	     }
	    
	     for(int t=0;t<=100;t++) {
	    	 int cnt=0;
	    	 visited=new boolean[N][N];
	    	  for(int i=0;i<N;i++) {
	 	    	 for(int j=0;j<N;j++) {
	 	    	    	if(map[i][j]>t && visited[i][j]==false) {
                      
	 	    	    		bfs(i,j,t);	 
	 	    	    		cnt++;
	 	    	    	}
	 	    	 }	    	 
	 	     }
	    	  // 높이별 안전 지역의 개수 cnt 이것을 계속 max 로 비교 해서 max 값 업데이트
	    	  max=Math.max(max, cnt);
	     } 
    //list 선언후 cnt 삽입 내림/오름 차순하여 첫 값을 구하면 max or min
//     ArrayList<Integer>list=new ArrayList<>();    
// 		  list.add(cnt); 
// 		Collections.sort(list,Collections.reverseOrder());
		System.out.println(max);
	}
	     static void bfs(int s,int e, int h) {
	    	 Queue<Point>q=new LinkedList<>();
	         q.add(new Point(s,e));
	         visited[s][e]=true;
	         while(!q.isEmpty()) {
	        	 
	        	 Point temp=q.poll();
	        	 for(int i=0;i<4;i++) {
	        		 
	        		 int next_x=temp.x+dx[i];
	        		 int next_y=temp.y+dy[i];
	        		 if(next_x>-1&& next_y>-1 && next_x<N && next_y<N) {
	        		 if(visited[next_x][next_y]==false && map[next_x][next_y]>h) {
	        			 visited[next_x][next_y]=true;
	        			 q.add(new Point(next_x,next_y));
	        		 }
	        		 }	        		 
	        		 
	        	 }
	        	 
	         }
	     
	     
	     }
	     
	     public static class Point{
	    	 int x;
	    	 int y;
	    	 Point(int x, int y){
	    		 
	    		 this.x=x; 
	    		 this.y=y;
	    		 
	    	 }
	    	 
	    	 
	     }
}
