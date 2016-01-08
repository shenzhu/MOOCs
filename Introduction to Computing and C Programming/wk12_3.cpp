#include<iostream>
#include<iomanip>
#include<cmath>
using namespace std;

int main(){
	int n;
	double dDots[100][2];

	//cin
	cin >> n;
	for (int i = 0; i < n; i++){
		cin >> dDots[i][0] >> dDots[i][1];
	}

	//find max distance
	double dMaxDistance = 0.0;
	for (int i = 0; i < n; i++){
		for (int j = 0; j < n; j++){
			if (i == j) continue;
			double dCurrentDistance = sqrt((dDots[i][0] - dDots[j][0]) * (dDots[i][0] - dDots[j][0])
										 + (dDots[i][1] - dDots[j][1]) * (dDots[i][1] - dDots[j][1]));
			if (dCurrentDistance > dMaxDistance){
				dMaxDistance = dCurrentDistance;
			}
		}	
	}
	
	cout << fixed << setprecision(4) << dMaxDistance << endl;
	return 0;
}