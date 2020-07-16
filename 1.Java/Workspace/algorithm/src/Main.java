import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int n;
	static class axis{
		int x;
		int y;
		int num;
		axis(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
		axis(int x,int y,int num)
		{
			this.x = x;
			this.y = y;
			this.num = num;
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
		
		for(int i = 0;i<n;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<n;j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0;i<n;i++)
		{
			for(int j = 0;j<n;j++)
			{
				if(map[i][j] == 1)
				{
					map[i][j] = cnt;
					dfs(i,j,cnt++);
				}
			}
		}
		
	
		find();
		
		bw.write(min+"\n");
		
		bw.flush();
	}
	static int cnt = 2;
	static Queue<axis> que = new LinkedList<>();
	public static void dfs(int x,int y,int cnt)
	{
		int tx,ty;
		boolean flag = false;
		for (int i = 0; i < 4; i++)
		{
			tx = x + d[i][0];
			ty = y + d[i][1];

			if (tx >= n || ty >= n || tx < 0 || ty < 0)
				continue;

			if(map[tx][ty] == 0)
				flag = true;
			
			
			if(map[tx][ty] == 1) 
			{
				map[tx][ty] = cnt;
				dfs(tx,ty,cnt);
			}
		}
		
		if(flag == true)
			que.add(new axis(x,y,cnt));
		
	}
	
	static int min = 9999999;
	public static void find()
	{
		int[] len = new int[cnt-2];
		boolean flag = false;
		while(!que.isEmpty())
		{
			int change = que.peek().num;
			int size = que.size();
			for(int k = 0;k<size;k++)
			{
				axis now = que.poll();
				
				if(change != now.num)
				{
					len[change-2]++;
					change = now.num;
				}
				
				for (int i = 0; i < 4; i++)
				{
					int tx = now.x + d[i][0];
					int ty = now.y + d[i][1];

					if (tx >= n || ty >= n || tx < 0 || ty < 0)
						continue;
					
					if(map[tx][ty] == 0)
					{
						map[tx][ty] = now.num;
						que.add(new axis(tx,ty,now.num));
					}
					else if(map[tx][ty] != 0 && map[tx][ty] != now.num)
					{
						min = Math.min(min,len[map[tx][ty]-2] + len[now.num-2]);
						flag = true;
					}
					
					if(flag == true && now.num == cnt-1)
						return;
				}
			}
			len[change-2]++;
		}
	}
}