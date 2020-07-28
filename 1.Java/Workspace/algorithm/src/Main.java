import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		
		int m = 6;
		int n = 4;
		int[][] pic = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		
		System.out.println(solution(m,n,pic));
	}
	
	
	static int[][] d = {
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	
	static class axis{
		int x;
		int y;
		axis(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Queue<axis> que = new LinkedList<>();
	public static int[] solution(int m, int n, int[][] pic) {
		
		int[][] picture = new int[m][n];
		for(int i = 0;i< m;i++)
		{
			for(int j = 0;j<n;j++)
			{
				picture[i][j] = pic[i][j];
			}
		}
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for(int i = 0;i<m;i++)
        {
        	for(int j = 0;j<n;j++)
        	{
        		if(picture[i][j] != 0)
        		{
        			que.add(new axis(i,j));
        			int result = 0;
        			int find = picture[i][j];
        			while(!que.isEmpty())
        			{
        				axis now = que.poll();
        				
        				for(int k=0;k<4;k++)
        				{
        					int tx = now.x + d[k][0];
        					int ty = now.y + d[k][1];
        					
        					if(tx >= m || ty >= n || tx < 0 || ty < 0) continue;
        					
        					if(picture[tx][ty] == find)
        					{
        						picture[tx][ty] = 0;
        						result++;
        						que.add(new axis(tx, ty));
        					}
        				}
        			}
        			numberOfArea++;
        			maxSizeOfOneArea = maxSizeOfOneArea > result ? maxSizeOfOneArea : result;
        		}
        	}
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
	
}