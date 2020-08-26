import java.io.*;
import java.util.*;

public class Main {


	static class ctime {
		int start;
		int end;
		ctime(int s, int e)
		{
			this.start = s;
			this.end = e;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static ctime arr[];
	
	public static void main(String[] args) throws Exception {
		
		int n = Integer.parseInt(br.readLine());
		arr = new ctime[n];
		for(int i = 0;i<n;i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new ctime(Integer.parseInt(st.nextToken()),
								Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(arr, new Comparator<ctime>() {
			@Override
			public int compare(ctime a, ctime b) {
				if(a.start > b.start)
					return -1;
				else
				{
					if(a.start == b.start)
					{
						if(a.end > b.end)
							return -1;
						else
							return 1;
					}
					else
						return 1;
				}
			}
        });
		int start = arr[0].start;
		int cnt = 1;
		for(int i = 1;i< n;i++)
		{
			if(arr[i].end <= start)
			{
				cnt++;
				start = arr[i].start;
			}
		}
		
		bw.write(cnt+"\n");
		bw.flush();
	}
}