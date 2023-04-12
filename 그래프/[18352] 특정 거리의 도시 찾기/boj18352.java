import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N; // 1~N 까지의 도시의 개수
	static int M; // M 개의 단방향 도로
	static int K; // 최단거리 k
	static int X; // 출발도시 x =
	static int dis[];
	static ArrayList<Integer> adj[];
	static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		dis = new int[N + 1];
		Arrays.fill(dis, -1);
		for (int j = 0; j <= N; j++) {
			adj[j] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
		}
         BFS(X);
	}
	static void BFS(int x) {
		//큐선언
		Queue<Integer>q=new LinkedList<>();
		q.add(x);
		dis[x]=0;
		//큐반복
		while(!q.isEmpty()) {
			
		   int temp=q.poll();
		   //인접 노드 탐색
		   for(int follow:adj[temp]) {
			   // 인접 노드가 -1 이라면 즉 아직 방문 하지 않은 상태
			   if(dis[follow]==-1){
				   //이전 노드기준 값을 +함으로써 최소거리를 구할수 있다 
				   dis[follow]=dis[temp]+1;
				   q.add(follow);
		         }		   
		   }						
		}
		//최소거리가 k인 노드를 출력 만약 한번도 없다면 -1 출력
		int cnt=0;
        for(int i=1;i<=N;i++) {
        	if(dis[i]==K) {
        		System.out.println(i);
        		cnt++;
        	}

        }
        if(cnt==0){
        	System.out.println(-1);
        }
						
	}


}
