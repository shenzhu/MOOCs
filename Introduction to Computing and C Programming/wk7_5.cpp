#include<iostream>
using namespace std;

int main(){
	int N, K;
	int iNumbers[100];

	//cin
	cin >> N;
	cin >> K;
	for (int i = 0; i < N; i++){
		cin >> iNumbers[i];
	}

	//find Kth max
	int iKMax[100];
	int iKMaxIndex = 0;
	for (int i = 0; i < N; i++){
		iKMax[i] = 0;
	}
	while (K--){
		for (int i = 0; i < N; i++){
			if (iNumbers[i] > iKMax[K]){
				iKMax[K] = iNumbers[i];
				iKMaxIndex = i;
			}
		}
		iNumbers[iKMaxIndex] = 0;
	}
	cout << iKMax[0] << endl;
	return 0;
}