import java.util.Scanner;
import java.io.FileInputStream;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class Solution {
	public static void main(String args[]) throws Exception	{ //기수정렬로 K까지정렬
		int T;
        int test_case;
      
        
		Scanner sc = new Scanner(System.in);
        
		T = sc.nextInt();        
		int N,K;
		int[] score;
		
		for(test_case = 1; test_case <= T; test_case++) {
			//	이 부분에서 알고리즘 프로그램을 작성하십시오.
        
			int answer = 0;
			
			N = sc.nextInt();
			K = sc.nextInt();
			score = new int[N];
		
			for(int i=0; i<N; i++)
				score[i] = sc.nextInt();
				
		
			radixSort2(score, K);
		
		
			
			for(int i=0; i<K; i++)
				answer+=score[i];
		
			
			System.out.println("Case #" + test_case);
            if(N>=K)
				System.out.println(answer);
		}
	}
	
	public static void radixSort2(int[] arr, int K) //상위 K까지만 정렬
	{
		int[][] Qarr = new int[10][arr.length];
		int[] rear = new int[10];
		int[] front = new int[10];
		
		int max=0;
		int exp=1;
		for(int i=0; i<arr.length; i++)if(max<arr[i]) max=arr[i];
		
		while( (max/exp) > 0 )
		{
			for(int i=0; i<arr.length; i++)
			{
				Qarr[ (arr[i]/exp)%10 ][ rear[(arr[i]/exp)%10] ] = arr[i];
				rear[(arr[i]/exp)%10]++;
			}
			
			for(int i=9, t=0; i>=0; i--)
			{
			
				
				while(front[i]<rear[i])
				{
					
					arr[t] = Qarr[i][front[i]];
			
					front[i]++;
					t++;
					if( (max/exp)==1 && t>K) break;
				}
				
				if( (max/exp)==1 && t>K) break;
				
				front[i]=0;
				rear[i]=0;
			}
			
			exp*=10;
		}
		
	}

	
}
