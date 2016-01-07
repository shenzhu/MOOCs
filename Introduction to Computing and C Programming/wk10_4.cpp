#include<iostream>
#include<iomanip>
using namespace std;

int main(){
	int iMatrix[5][5];
	int n;
	int m;
	//read data
	for (int i = 0; i < 5; i++){
		for (int j = 0; j < 5; j++){
			cin >> iMatrix[i][j];
		}
	}
	cin >> n >> m;

	//check n and m
	if ((n < 0 || n >= 5) || (m < 0 || m >= 5)){
		cout << "error" << endl;
		return 0;
	}

	//exchange
	for (int i = 0; i < 5; i++){
		int iTemp = iMatrix[n][i];
		iMatrix[n][i] = iMatrix[m][i];
		iMatrix[m][i] = iTemp;
	}

	//cout
	for (int i = 0; i < 5; i++){
		for (int j = 0; j < 5; j++){
			cout << setw(4) << iMatrix[i][j];
		}
		cout << endl;
	}

	return 0;
}