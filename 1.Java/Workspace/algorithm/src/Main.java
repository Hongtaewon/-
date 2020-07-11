import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		String arr = br.readLine();
		int n = arr.length();
		for(int i = 0;i<n;i++)
		{
			left.push(arr.charAt(i));
		}
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0;i<m;i++)
		{
			
			char[] order = br.readLine().toCharArray();
			
			switch (order[0]) {
			case 'L': //왼쪽 이동
				if(!left.isEmpty())
					right.push(left.pop());
				break;
			case 'D': //오른쪽 이동
				if(!right.isEmpty())
					left.push(right.pop());
				break;
			case 'B':
				if(!left.isEmpty())
					left.pop();
				break;
			case 'P':
				left.push(order[2]);
				break;
			}
		}
		
		while(!left.isEmpty())
			right.push(left.pop());
		while(!right.isEmpty())
			bw.write(right.pop());
		
		bw.flush();
	}
}