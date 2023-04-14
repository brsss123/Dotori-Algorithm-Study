=
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
 
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,1,-1};
	static int map[][];
	static int N;
	static boolean visited[][];
	
   public static void main(String[]args)throws IOException{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    N=Integer.parseInt(br.readLine());
    
    map=new int[N][N];
    visited=new boolean[N][N];
    for(int i=0;i<N;i++) {
    	String str=br.readLine();
    	for(int k=0;k<N;k++) {
    		int a=str.charAt(k)-'0';
    		map[i][k]=a;
    		
    	}
    }    	
    int index=0;
     ArrayList<Integer>list=new ArrayList<>(); 
	 for(int a=0;a<N;a++) {	    
	    	for(int b=0;b<N;b++) {
	    		
	    		if (visited[a][b]==false && map[a][b]>=1) {
	    			int cnt=BFS(a,b,index);	 
	    	        list.add(cnt);  
	    			index++;
	    			
	    		}
	    	}
	   }
	 //리스트 오름 차순 정렬 해야하므로
	// Collections.sort(list,Collections.reverseOrder());     // 내림차순정렬시 
	 Collections.sort(list);
	 StringBuilder sb=new StringBuilder();
	 sb.append(index+"\n");
	 for(int i=0; i<list.size();i++) {
		 sb.append(list.get(i)+"\n");
	 }
	System.out.println(sb);
   }
	static int BFS(int a, int b ,int index) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(a, b));
		int count=1;
		visited[a][b] = true;
		while (!q.isEmpty()) {
            Point temp=q.poll();
            for(int i=0;i<4;i++) {
            	int x =temp.x+dx[i];
            	int y= temp.y+dy[i];
            	if(x>=0 && y>=0 && x<N && y<N){
            		if(visited[x][y]==false && map[x][y]>=1) {
            		visited[x][y]=true;
            		// 이전 map의 값에서 +1 해줘야함
                    map[x][y]=map[temp.x][temp.y]+1;
            		count++;
                    
            		q.add(new Point(x,y));     
            		}
            	}
            	            	
            }
            			
 		}
	     return count;
	}
   // 생성자 즉 변수객체를 생성하는것 static을 해야지 모든 객체가 공유 가능하다// 단 garbage collector의 관리영역 이외에 존재하므로 프로그램종료시까지 메모리 할당
   // 멤버변수 명과 매개변수명을 동일하게 설정할 시에는 this로 구분을 해주어야 한다
   public static class Point{
	   
	   int x;
	   int y;
	   Point(int x, int y){
		   this.x=x;
		   this.y=y;
		   
		   
	   }
	   
	   
   }
   
}
