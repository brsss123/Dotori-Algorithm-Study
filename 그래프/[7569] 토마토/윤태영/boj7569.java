import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M;// 가로
	static int N;// 세로
	static int H;// 높이
	static int box[][][]; // 상자
	static boolean visited[][][];
	static int dx[] = { 1, -1, 0, 0, 0, 0 };
	static int dy[] = { 0, 0, 1, -1, 0, 0 };
	static int dz[] = { 0, 0, 0, 0, 1, -1 };
	static int max = Integer.MIN_VALUE;
	static int result;
    static Queue<Point> q = new LinkedList<>();
    
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[M][N][H];
		visited = new boolean[M][N][H];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					int a = Integer.parseInt(st.nextToken());
					box[k][j][i] = a;
					if (box[k][j][i] == 1) {
						
						// 한번에 큐에 몰아넣어야만 한다
						//나중에 하나씩 넣을려고 하면 문제 발생 
						q.add(new Point(k,j,i));
					 
						
					}
				}
			}
		}

		BFS();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (box[k][j][i] == 0) {
				        System.out.println("-1");
                        //메인 함수 종료
                        return;
	
					}
					max = Math.max(max, box[k][j][i]);
					
				}
			}
		}
         
        System.out.println(max-1);
        return;
	
	}

	static void BFS() {

		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int t = 0; t < 6; t++) {

				int next_x = cur.x + dx[t];
				int next_y = cur.y + dy[t];
				int next_z = cur.z + dz[t];
				boolean check = available(next_x, next_y, next_z);
				if (check == true && visited[next_x][next_y][next_z] == false && box[next_x][next_y][next_z] == 0) {
					visited[next_x][next_y][next_z] = true;
					box[next_x][next_y][next_z] = box[cur.x][cur.y][cur.z] + 1;
					q.add(new Point(next_x, next_y, next_z));

				}

			}
		}

	}

	static boolean available(int a, int b, int c) {

		if (a >= 0 && b >= 0 && c >= 0 && a < M && b < N && c < H) {

			return true;

		}
		return false;
	}

	public static class Point {
		int x;
		int y;
		int z;

		Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;

		}
	}

}
