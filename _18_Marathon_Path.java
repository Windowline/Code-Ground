import java.util.*;

public class _18_Marathon_Path 
{
	static int m,n,k;
	static int[][] map, cache;
	
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i=1; i<=tc; i++)
		{
			m = sc.nextInt(); //열-x
			n = sc.nextInt(); // 행-y
			k = sc.nextInt();
			map = new int[n+1][m+1];
			cache = new int[n+1][m+1];
			for(int y=0; y<=n; y++)
				for(int x=0; x<=m; x++)
				{
					map[y][x] = sc.nextInt(); // 음수일경우 생수통
					cache[y][x] = -200;
				}
			
			System.out.println("Case #"+i);
			System.out.println(minHeight(0,0,0));
		}
	}
	
	
	public static int minHeight(int y, int x, int t) // 현재 확보한 생수통이 t개고 y,x ~ m,n 까지 이동하며, k-t이상의 생수통을 확보해야할 때 최소 고도차이의 합
	{
		if(x<0 || y<0 || y>n || x>m)
			return -1;
		if(y==n && x==m)
		{
			int plus = (map[y][x]) < 0 ? 1 : 0;		
			t += plus;
	
			if(k>t)
				return -1; //생수부족
			if(k<=t)
				return 0; //만족하거나 그 이상
		}
		if(cache[y][x]!=-200)
			return cache[y][x];
		
		int plus = (map[y][x]) < 0 ? 1 : 0;		
		int tmp1 = minHeight(y+1, x, t+plus);
		int tmp2 = minHeight(y, x+1, t+plus);
		
		int subAns1 = (tmp1 > -1) ? tmp1 +  Math.abs(Math.abs(map[y][x]) - Math.abs(map[y+1][x])) : -1;
		int subAns2 = (tmp2 > -1) ? tmp2 +  Math.abs(Math.abs(map[y][x]) - Math.abs(map[y][x+1])) : -1;
		
		int answer = -1;
		if(subAns1> -1 && subAns2> -1)
			answer = Math.min(subAns1, subAns2);
		else if(subAns1>-1)
			answer = subAns1;
		else if(subAns2>-1)
			answer = subAns2;
		
		if(answer!=-1)
			cache[y][x] = answer;
		
		return answer;
	}
}
