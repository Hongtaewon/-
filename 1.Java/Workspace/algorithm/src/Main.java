import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		String s = br.readLine();
		String[] temp = s.split(",");
		for(int i = 0;i<n;i++)
		{
			arr[i] = Integer.valueOf(temp[i]);
		}
		
		for(int i = 0;i<k;i++)
		{
			for(int j = 0;j<n-1;j++)
			{
				arr[j] = arr[j+1] - arr[j];
			}
			n--;
		}

		for(int i = 0;i<n;i++)
		{
			if(i == n-1)
				bw.write(arr[i]+"\n");
			else
				bw.write(arr[i]+",");
		}
		
		bw.flush();
	}

}