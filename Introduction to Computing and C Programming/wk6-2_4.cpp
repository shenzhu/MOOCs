#include<iostream>
using namespace std;

int main(){
	int number[6];
	int maxDiff;

	//cin
	for (int i = 0; i < 6; i++){
		cin >> number[i];
	}

	//find max numbers
	int maxOdd = -1;
	int minEven = 1000;
	for (int i = 0; i < 6; i++){
		//even
		if (number[i] % 2 == 0){
			if (number[i] < minEven){
				minEven = number[i];
			}
		}
		//odd
		else if (number[i] > maxOdd)
		{
			maxOdd = number[i];
		}
	}
	
	if ((maxOdd - minEven) < 0){
		maxDiff = minEven - maxOdd;
	}
	else
	{
		maxDiff = maxOdd - minEven;
	}

	//cout
	cout << maxDiff << endl;
	return 0;
}