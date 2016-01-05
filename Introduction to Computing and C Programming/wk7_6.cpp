#include<iostream>
using namespace std;

int main(){
	int n;
	cin >> n;

	int i100Num = 0;
	int i50Num = 0;
	int i20Num = 0;
	int i10Num = 0;
	int i5Num = 0;
	int i1Num = 0;
	while (n >= 100)
	{
		n -= 100;
		i100Num++;
	}
	while (n >= 50)
	{
		n -= 50;
		i50Num++;
	}
	while (n >= 20)
	{
		n -= 20;
		i20Num++;
	}
	while (n >= 10)
	{
		n -= 10;
		i10Num++;
	}
	while (n >= 5)
	{
		n -= 5;
		i5Num++;
	}
	while (n >= 1)
	{
		n -= 1;
		i1Num++;
	}

	cout << i100Num << endl;
	cout << i50Num << endl;
	cout << i20Num << endl;
	cout << i10Num << endl;
	cout << i5Num << endl;
	cout << i1Num << endl;
	return 0;
}