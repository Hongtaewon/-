import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int n;
	static class axis{
		int x;
		int y;
		axis(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	static int[][] d = {
		{0,1},
		{1,0},
		{-1,0},
		{0,-1}
		
	};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		

		map = new int[n][n];
		visited = new boolean[n][n];
		for(int i = 0;i<n;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 2;
		for(int i = 0;i<n;i++)
		{
			for(int j = 0;j<n;j++)
			{
				if(map[i][j] == 1)
				{
					dfs(i,j,cnt++);
				}
			}
		}
		
		for(int i = 0;i<n;i++)
		{
			for(int j = 0;j<n;j++)
			{
				if(map[i][j] != 0)
				{
					visited[i][j] = true;
					find(i,j,map[i][j],0);
				}
			}
		}
		
		bw.write(min+"\n");
		
		bw.flush();
	}
	
	public static void dfs(int x,int y,int cnt)
	{
		int tx,ty;
		
		for (int i = 0; i < 4; i++)
		{
			tx = x + d[i][0];
			ty = y + d[i][1];

			if (tx >= n || ty >= n || tx < 0 || ty < 0)
				continue;

			if(map[tx][ty] == 1) 
			{
				map[tx][ty] = cnt;
				dfs(tx,ty,cnt);
			} 
		}
	}
	
	static int min = 9999999;
	public static void find(int x,int y,int val,int cnt)
	{
		if(min <= cnt) return;
		int tx,ty;
		
		for (int i = 0; i < 4; i++)
		{
			tx = x + d[i][0];
			ty = y + d[i][1];

			if (tx >= n || ty >= n || tx < 0 || ty < 0 || map[tx][ty] == val || visited[tx][ty] == true)
				continue;

			if(map[tx][ty] == 0) 
			{
				visited[tx][ty] = true;
				find(tx,ty,val,cnt+1);
			}
			else if(map[tx][ty] != val)
			{
				if(min > cnt) 
					min = cnt;
				
				return;
			}
		}
	}
}