#include<iostream>
using namespace std;

int main(){
	int N;
	int iCT[100][100];

	//read
	cin >> N;
	for (int i = 0; i < N; i++){
		for (int j = 0; j < N; j++){
			cin >> iCT[i][j];
		}
	}

	//find abnormal cell
	int iAbnormalCellNum = 0;
	for (int i = 1; i < N - 1; i++){
		for (int j = 1; j < N - 1; j++){
			if ((iCT[i - 1][j] - iCT[i][j]) >= 50 &&
				(iCT[i][j - 1] - iCT[i][j]) >= 50 &&
				(iCT[i + 1][j] - iCT[i][j]) >= 50 &&
				(iCT[i][j + 1] - iCT[i][j]) >= 50){
				iAbnormalCellNum++;
			}
		}
	}

	cout << iAbnormalCellNum << endl;
	return 0;
}