#include<iostream>
using namespace std;

int main(){
	//multi-line input
	int N;
	int K;
	int M;

	while (cin >> N >> K)
	{
		double dHousePrice = 200;
		int iIncome = 0;
		bool bAffordable = false;

		for (int i = 0; i < 20; i++){
			iIncome += N;
			if (iIncome >= dHousePrice){
				M = i + 1;
				bAffordable = true;
				break;
			}
			dHousePrice *= (100.0 + K) / 100;
		}

		if (bAffordable){
			cout << M << endl;
		}
		else
		{
			cout << "Impossible" << endl;
		}
	}

	return 0;
}