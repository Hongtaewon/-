import java.io.*;
import java.util.*;

class Main {
	
	static int n,m;
	static char[][] map;
	
	static int[][] d = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	static class axis {
		int x;
		int y;
		
		public axis(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		for(int i=0 ;i<n;i++)
		{
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for(int j =0;j<m;j++)
			{
				map[i][j] = temp.charAt(j);	
			}
		}
		
		System.out.println(check());
	}

	public static int check() {
		return dfs(0,0,String.valueOf(map[0][0]),1);
		
	}
	static int max = 0;
	public static int dfs(int x,int y,String s,int cnt)
	{
		int tx,ty;
		
		for(int i = 0;i<4;i++)
		{
			tx = x + d[i][0];
			ty = y + d[i][1];
			
			if(tx >= n || ty >= m || tx < 0 || ty < 0) continue;
			
			if(!s.contains(String.valueOf(map[tx][ty])))
			{
				dfs(tx,ty,s+String.valueOf(map[tx][ty]),cnt+1);
			}
		}
		
		if(max < cnt) max = cnt;
		
		return max;
	}
}