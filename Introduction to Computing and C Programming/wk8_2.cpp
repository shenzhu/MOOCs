#include<iostream>
using namespace std;

int main(){
	int iNumbers[6];
	int result = 0;

	//cin
	for (int i = 0; i < 6; i++){
		cin >> iNumbers[i];
	}

	//find < a and add
	for (int i = 1; i < 6; i++){
		if (iNumbers[i] < iNumbers[0]){
			result += iNumbers[i];
		}
	}

	//cout
	cout << result << endl;
	return 0;
}