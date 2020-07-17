import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int n,t;
	static class Node{
		int val;
		boolean isLast=false;
		Node[] node = new Node[10];
		Node(int val,boolean last)
		{
			this.val = val;
			this.isLast = last;
		}
		public void setNode(Node node)
		{
			this.node[node.val] = node;
		}
		public Node getNode(int val)
		{
			return this.node[val];
		}
		public boolean checkLast(Node node)
		{
			return this.node[node.val].isLast;
		}
		public boolean checkNode(Node node)
		{
			if(this.node[node.val] != null )
			{
				return false;
			}
			return true;
		}
		public void setLast()
		{
			this.isLast = true;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<t;i++)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			Node root = new Node(99, false);
			boolean flag = true;
			for(int j=0;j<n;j++)
			{
				Node now = root;
				st = new StringTokenizer(br.readLine());
				String temp = st.nextToken();
				for(int k=0;k<temp.length();k++)
				{
					Node tn = new Node(temp.charAt(k)-48,false);
					if(now.checkNode(tn))
						now.setNode(tn);
					else
					{
						if(now.checkLast(tn) || k+1 == temp.length())
						{
							flag = false;
							break;
						}
						else
						{
							now = now.getNode(tn.val);
							continue;
						}
					}
					now = tn;
				}
				now.isLast = true;
			}
			if(flag == false)
				bw.write("NO\n");
			else
				bw.write("YES\n");
		}
		
		bw.flush();
	}
	
}