#include<iostream>
using namespace std;

int main(){
	int N;
	int iNumbers[15000];

	//cin
	cin >> N;
	if (N == 0){
		//cout << 0 << endl;
		return 0;
	}
	for (int i = 0; i < N; i++){
		cin >> iNumbers[i];
	}

	//sort
	for (int i = 0; i<N - 1; i++)
	{
		int k = i;
		int key = iNumbers[i];
		for (int j = i + 1; j<N; j++)
		{
			if (iNumbers[j]<key)
			{
				k = j;
				key = iNumbers[j];
			}
		}
		if (k != i){
			int temp = iNumbers[i];
			iNumbers[i] = iNumbers[k];
			iNumbers[k] = temp;
		}
	}

	//cout
	if (N % 2 == 0){
		cout << (iNumbers[N / 2] + iNumbers[N / 2 - 1]) / 2 << endl;
	}
	else{
		cout << iNumbers[N / 2] << endl;
	}
	return 0;
}