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
		long hi = 0;
		
		for(int i = 0;i<n;i++)
		{
			int temp = Integer.parseInt(br.readLine());
			hi = hi > temp ? hi : temp;
			arr[i] = temp;
		}
		
		long lo = 1;
		while(lo <= hi)
		{
			long mid = (hi + lo) / 2;
			long cnt = 0;
			for(int i = 0;i< n;i++)
			{
				cnt += (arr[i] / mid);
			}
			if (m > cnt) hi = mid - 1;
			else if (m  <= cnt) lo = mid + 1;
		}
		
		bw.write(hi+"\n");
		bw.flush();
	}
}