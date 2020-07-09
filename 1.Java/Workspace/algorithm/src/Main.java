import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static boolean arr[] = new boolean[1000001];
	public static void eratos(int last)
	{
		for (int i = 2; i <= last; i++)
		{
			if (arr[i] == false)
			{
				for (int j = i+i; j <= last; j = j + i)
					arr[j] = true;
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		eratos(1000000);
		arr[1] = true;
		arr[2] = true;
		while(true)
		{
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			
			int a = 0,b = 0;
			for(int i = n-1;i>=n/2;i--)
			{
				if(arr[i] == true) continue;
				
				if(arr[n-i] == false)
				{
					if(b-a <= 2*i-n)
					{
						a = n-i;
						b = i;
						break;
					}
				}
			}
			if(a == 0) System.out.println("Goldbach's conjecture is wrong.");
			
			bw.write(n+" = "+a+" + "+b+"\n");
		}
		bw.flush();
	}
}