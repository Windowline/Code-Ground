#include<algorithm>
#include <cstdio>
#include<math.h>
#include <iostream>
#define ull unsigned long long
using namespace std;
int K;

 ull inverse2(int i, ull cur_v)
{
	if (i == K)
		return cur_v;
	ull ret = inverse2(i + 1, cur_v * 2);
	if ((cur_v - 1) >= 6 && (cur_v - 1) % 3 == 0 && (cur_v - 1) % 2 == 1)
			ret = min(ret, inverse2(i + 1, (cur_v - 1) / 3));
	return ret;
}

int main(int argc, char** argv)
{
	setbuf(stdout, NULL);
	int T;
	int test_case;

	scanf("%d", &T);
	for (test_case = 1; test_case <= T; test_case++) 
	{
		scanf("%d", &K);
		printf("Case #%d\n", test_case);
		ull max_v = pow(2, K);
		printf("%llu %llu\n", inverse2(0,1), max_v);

	}

	return 0;	
}
