#include<iostream>
using namespace std;

int main(){
	int n;
	cin >> n;

	for (int i = 10; i <= n; i++){
		int iLowDigit = i % 10;
		int iHighDigit = (i / 10) % 10;
		if (i % (iLowDigit + iHighDigit) == 0){
			cout << i << endl;
		}
	}
	
	return 0;
}