#include<iostream>
using namespace std;

//300 monkeys in total
//this array stores the succedent of a monkey
int succedent[300];
//this array stores the precedent of a monkey
int precedent[300];

int main(){
	int n, m;

	//handle cin
	while (true)
	{
		cin >> n >> m;
		if (n == 0 && m == 0){
			break;
		}
		//init array
		for (int i = 0; i < n - 1; i++){
			succedent[i] = i + 1;
			precedent[i + 1] = i;
		}
		succedent[n - 1] = 0;
		precedent[0] = n - 1;

		int current = 0;
		while (true)
		{
			//find the monkey that's going to quit
			for (int count = 0; count < m - 1; count++){
				current = succedent[current];
			}

			int pre = precedent[current];
			int suc = succedent[current];
			//current monkey quit
			succedent[pre] = suc;
			precedent[suc] = pre;

			//if pre == suc, then only two monkeys left
			//current is the one that's going to quit, so pre/suc is king
			//index from 0, so cout +1
			if (pre == suc){
				cout << pre + 1 << endl;
				break;
			}

			//find the next monkey
			current = suc;
		}
	}
	return 0;
}