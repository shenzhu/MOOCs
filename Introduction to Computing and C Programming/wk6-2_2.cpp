#include<iostream>
using namespace std;

int main(){
	int h;
	int r;
	int numOfBuckets = 1;

	//cin
	cin >> h >> r;

	double bucketWater = r * r * h * 3.14159 / 1000;
	while (bucketWater * numOfBuckets < 20)
	{
		numOfBuckets++;
	}

	//cout
	cout << numOfBuckets << endl;

	return 0;
}