#include<iostream>
using namespace std;

int main(){
	int n;
	int k;
	int iNumbers[1000];

	//cin
	cin >> n >> k;
	for (int i = 0; i < n; i++){
		cin >> iNumbers[i];
	}

	for (int i = 0; i < n; i++){
		for (int j = 0; j < n; j++){
			//jump when i = j
			if (i == j) continue;
			int result = iNumbers[i] + iNumbers[j];
			if (result == k){
				cout << "yes" << endl;
				return 0;
			}
		}
	}
	cout << "no" << endl;
	return 0;
}