#include<iostream>
#include<iomanip>
using namespace std;

int main(){
	int n;
	int ages[100];

	//cin
	cin >> n;
	for (int i = 0; i < n; i++){
		cin >> ages[i];
	}

	//statistics
	int iUnder18 = 0;
	int i19To35 = 0;
	int i36To60 = 0;
	int iOver60 = 0;
	double dUnder18 = 0.0;
	double d19To35 = 0.0;
	double d36To60 = 0.0;
	double dOver60 = 0.0;
	for (int i = 0; i < n; i++){
		if (ages[i] <= 18) iUnder18++;
		if (19 <= ages[i] && ages[i] <= 35) i19To35++;
		if (36 <= ages[i] && ages[i] <= 60) i36To60++;
		if (ages[i] > 60) iOver60++;
	}
	dUnder18 = ((double)iUnder18 / n) * 100;
	d19To35 = ((double)i19To35 / n) * 100;
	d36To60 = ((double)i36To60 / n) * 100;
	dOver60 = ((double)iOver60 / n) * 100;

	//cout
	cout << "1-18: " << fixed << setprecision(2) << dUnder18 << "%" << endl;
	cout << "19-35: " << d19To35 << "%" << endl;
	cout << "36-60: " << d36To60 << "%" << endl;
	cout << "60-: " << dOver60 << "%" << endl;
	return 0;
}