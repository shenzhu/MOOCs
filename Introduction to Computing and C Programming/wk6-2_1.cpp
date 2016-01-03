#include<iostream>
using namespace std;

int main(){
	int n;
	int x;
	int y;

	//read data
	cin >> n >> x >> y;

	double appEaten = (double)y / x;
	int result = (int)(n - appEaten);
	if (result < 0) result = 0;

	//cout
	cout << result << endl;
	return 0;
}