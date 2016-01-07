#include<iostream>
using namespace std;

int main(){
	int L;
	int M;
	int iHaveTree[10001] = { 0 };
	int iSubStartAndEnd[100][2];

	//cin
	cin >> L >> M;
	for (int i = 0; i < M; i++){
		cin >> iSubStartAndEnd[i][0] >> iSubStartAndEnd[i][1];
	}

	//if has subway, set to 1
	for (int i = 0; i < M; i++){
		for (int j = iSubStartAndEnd[i][0]; j <= iSubStartAndEnd[i][1]; j++){
			iHaveTree[j] = 1;
		}
	}

	//check 0 num;
	int iTreeCount = 0;
	for (int i = 0; i <= L; i++){
		if (iHaveTree[i] == 0){
			iTreeCount++;
		}
	}

	cout << iTreeCount << endl;
	return 0;
}