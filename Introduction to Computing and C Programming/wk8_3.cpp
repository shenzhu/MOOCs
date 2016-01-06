#include<iostream>
using namespace std;

int main(){
	//cin
	int n;
	cin >> n;
	int iDistances[100];
	for (int i = 0; i < n; i++){
		cin >> iDistances[i];
	}

	const int iFindBike = 27;
	const int iLockBike = 23;
	const double dWalkSpeed = 1.2;
	const double dBikeSpeed = 3.0;
	for (int i = 0; i < n; i++)
	{
		double dWalkTime = iDistances[i] / dWalkSpeed;
		double dBikeTime = iDistances[i] / dBikeSpeed + iFindBike + iLockBike;
		if (dWalkTime > dBikeTime){
			cout << "Bike" << endl;
		}
		if (dWalkTime < dBikeTime){
			cout << "Walk" << endl;
		}
		if (dWalkTime == dBikeTime){
			cout << "All" << endl;
		}
	}

	return 0;
}