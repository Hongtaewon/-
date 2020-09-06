import java.io.*;
import java.util.*;

public class Main {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i = 1;i<= n;i++)
			que.add(i);
		
		while(que.size() != 1)
		{
			que.poll();
			que.add(que.poll());
		}
		
		bw.write(que.poll()+"\n");
		
		bw.flush();
	}
}