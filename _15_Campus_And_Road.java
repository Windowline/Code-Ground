import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

class Edge
{
	public int from, to, cost;
	Edge(int u, int v, int c)
	{
		this.from = u;
		this.to= v;
		this.cost = c;
	}
}

class Node implements Comparable<Node>
{
	public int node, cost;
	
	public Node(int node, int cost)
	{
		this.node = node;
		this.cost = cost;
	}
	public int compareTo(Node a)
	{
		return this.cost < a.cost ? -1 : 1;
	}
}


public class _15_Campus_And_Road 
{
	static ArrayList<Edge>[] grp;
	static int n, e;
	static boolean[] ansChk;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++)
		{
			System.out.println("Case #"+t);
			n = sc.nextInt();
			e = sc.nextInt();
			ansChk = new boolean [n+1];
			grp = (ArrayList<Edge>[]) new ArrayList[n+1];
			for(int i=1; i<=n; i++)
				grp[i] = new ArrayList<Edge>();
			
			for(int i=1; i<=e; i++)
			{
				int from = sc.nextInt();
				int to = sc.nextInt();
				int c = sc.nextInt();
				grp[from].add(new Edge(from, to, c));
				grp[to].add(new Edge(to, from, c));
				
			}
			
			for(int s=1; s<=n; s++)
				dstra(s);
			
			int cnt = 0;
			for(int a=1; a<=n; a++)
				if(!ansChk[a])
					cnt++;
			
			System.out.print(cnt);
			
			for(int a=1; a<=n; a++)
				if(!ansChk[a])
					System.out.print(" "+a);
			
			System.out.println();	
		}

	}
	
	public static void dstra(int start)
	{
		final int inf = 987654321;
		boolean[] visit = new boolean[n+1];
		int[] cost = new int[n+1];
		for(int i=1; i<=n; i++)
			cost[i] = inf;				
		
		cost[start] = 0;
		visit[start] = true;
		PriorityQueue<Node> PQ = new PriorityQueue<Node> ();
		PQ.add(new Node(start, 0));		
		while(!PQ.isEmpty())
		{
			Node min = null;
			while(!PQ.isEmpty())
			{
				min = PQ.poll();
				if(cost[min.node] >= min.cost)
					break;
			}
			int minNode = min.node;
			visit[minNode] = true;
			for(Edge e : grp[minNode])
			{
				int newCost = cost[e.from] + e.cost;
				if(cost[e.to] > newCost)
				{
					cost[e.to] = newCost;
					PQ.add(new Node(e.to, newCost));
												
				}
			}
		}
		
		for(int i=1; i<=n; i++)
		{
			if(start==i)
				continue;
			for(Edge edge : grp[i])
			{
				if(cost[i] + edge.cost == cost[edge.to])
					ansChk[i] = true;
			}
		}
	
	}

}
