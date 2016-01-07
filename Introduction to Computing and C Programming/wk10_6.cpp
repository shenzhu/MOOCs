#include<iostream>
using namespace std;

int main(){
	int n;
	int m;
	int iNumbers[100];

	//cin
	cin >> n >> m;
	for (int i = 0; i < n; i++){
		cin >> iNumbers[i];
	}

	//move numbers
	while (m--){
		int iTemp = iNumbers[n - 1];
		for (int i = n - 1; i > 0; i--){
			iNumbers[i] = iNumbers[i - 1];
		}
		iNumbers[0] = iTemp;
	}

	//cout
	for (int i = 0; i < n; i++){
		cout << iNumbers[i] << " ";
	}
	cout << endl;

	return 0;
}