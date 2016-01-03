#include<iostream>
using namespace std;

int main(){
	int n;
	int grades[100];

	//cin
	cin >> n;
	for (int i = 0; i < n; i++){
		cin >> grades[i];
	}

	//find max number
	int maxGrade = 0;
	for (int i = 0; i < n; i++){
		if (grades[i] > maxGrade)
		{
			maxGrade = grades[i];
		}
	}

	//cout
	cout << maxGrade << endl;
	return 0;
}