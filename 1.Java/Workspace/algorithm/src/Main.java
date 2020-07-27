import java.io.*;
import java.util.*;

public class Main {

	static int n,m;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[n];
		long sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++)
		{
			int temp = Integer.parseInt(st.nextToken());
			sum += temp;
			arr[i] = temp;
		}
		
		long hi = sum/m;
		long lo = 0;
		long time = 0;
		long max = 0;
		while(lo < hi)
		{
			time = 0;
			long mid = (hi + lo) / 2;
			long cnt = 0;
			max = 0;
			for(int i = 0;i< n;i++)
			{
				if(mid >= time + arr[i])
				{
					time += arr[i];
					
				}
				else
				{
					cnt++;
					if(cnt == m) break;
					time = arr[i];
				}
				max = max > time ? max : time;
			}
			if (m > cnt) lo = mid + 1;
			else if (m  < cnt) hi = mid - 1;
			else if (m == cnt)
			{
				lo = mid + 1;
				hi = hi + 1;
			}
		}
		
		bw.write(max+"\n");
		bw.flush();
	}
}