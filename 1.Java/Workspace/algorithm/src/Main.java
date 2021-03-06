import java.util.*;
import java.io.*;

public class Main {

	
	static class node {
		int x;
		int cnt;
		node(int x,int cnt)
		{
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n,k;
	static int[] arr;
	static boolean[] used;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[2*n];
		used = new boolean[2*n];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0;i<2*n;i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		bw.write(moving()+"\n");
		bw.flush();
	}
	
	public static int moving() {
		
		int num = 0;
		int step = 0;
		int pos = 0;
		Queue<node> que = new LinkedList<>();
		while(num < k)
		{
			step++;
			
			pos--;
			if(pos<0)
				pos = 2*n-1;
			
			int size = que.size();
			
			for(int i = 0;i<size;i++)
			{
				node now = que.poll();
				int x = now.x;
				int cnt = now.cnt;
				used[x] = false;
				cnt++;
				if(cnt < n)
				{
					int next = (x+1) % (2*n);
					
					if(used[next] == false)
					{
						if(arr[next] > 0)
						{
							cnt++;
							if(arr[next] == 1)
								num++;
							arr[next]--;
							
							if(cnt < n)
							{
								used[next] = true;
								que.add(new node(next, cnt));
							}
						}
						else
						{
							used[x] = true;
							que.add(new node(x, cnt));
						}
					}
					else
					{
						used[x] = true;
						que.add(new node(x, cnt));
					}
					
				}
			}
			
			if(used[pos] == false && arr[pos] > 0)
			{
				if(arr[pos] == 1)
					num++;
				arr[pos]--;
				used[pos] = true;
				que.add(new node(pos, 1));
			}
			
		}
		
		return step;
	}
}
