import java.io.*;
import java.util.*;

public class Main {

	static boolean[][] map;
	static int n;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		map = new boolean[n][n];
		
		queen(0);
		bw.write(result+"\n");
		bw.flush();
	}
	static int result = 0;
	public static void queen(int x)
	{
		if(x == n)
		{
			result++;
			return;
		}
		
		for(int i = 0;i<n;i++)
		{
			map[x][i] = true;
			if(check(x,i)) {
				queen(x+1);
			}
			map[x][i] = false;
		}
	}
	
	public static boolean check(int x,int y)
	{
		//x축
		for(int i = 0;i<n;i++)
		{
			if(i == x)
				continue;
			if(map[i][y])
				return false;
		}
		
		//왼쪽 아래 대각선
		for(int i = 1;i<n;i++)
		{
			if(x-i >=0 && y-i >= 0)
				if(map[x-i][y-i])
					return false;
		}
		//오른쪽 아래 대각선
		for(int i = 1;i<n;i++)
		{
			if(x-i >=0 && y + i < n)
				if(map[x-i][y+i])
					return false;
		}
		
		return true;
	}
}