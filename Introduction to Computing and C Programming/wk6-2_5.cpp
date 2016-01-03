#include<iostream>
using namespace std;

int main(){
	int n;
	int a;
	int b;
	int c;

	//cin
	cin >> n;
	c = n % 10;
	b = (n / 10) % 10;
	a = (n / 100) % 10;

	//cout
	cout << a << endl;
	cout << b << endl;
	cout << c << endl;
	return 0;
}