import java.io.*;
import java.util.*;

public class Main {

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
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	static int[][] map;
	static int m,n;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[m][n];
		
		for(int i = 0;i< k;i++)
		{
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			paint(x1,x2,y1,y2);
		}
		
		for(int i = 0;i< m;i++)
		{
			for(int j = 0;j<n;j++)
			{
				if(map[i][j] == 0)
				{
					map[i][j] = 1;
					cnt = 1;
					dfs(i,j);
					que.add(cnt);
				}
			}
		}
		
		bw.write(que.size()+"\n");
		while(!que.isEmpty())
		{
			bw.write(que.poll()+" ");
		}
		bw.flush();
	}
	static int cnt = 0;
	static PriorityQueue<Integer> que = new PriorityQueue<>();
	public static void paint(int x1,int x2, int y1,int y2)
	{
		for(int i = x1;i<x2;i++)
		{
			for(int j = y1;j<y2;j++)
			{
				map[i][j] = 1;
			}
		}
	}
	
	public static void dfs(int x,int y)
	{
		for(int i = 0;i<4;i++)
		{
			int tx = x + d[i][0];
			int ty = y + d[i][1];
			
			if(tx >= m || ty >= n || tx < 0 || ty < 0) continue;
			
			if(map[tx][ty] == 0)
			{
				cnt++;
				map[tx][ty] = 1;
				dfs(tx,ty);
			}
		}
	}
}