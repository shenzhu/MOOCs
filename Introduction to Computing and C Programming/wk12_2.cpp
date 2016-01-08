#include<iostream>
using namespace std;

int main(){
	int n;
	
	while (cin >> n){
		bool b3Divisible = false;
		bool b5Divisible = false;
		bool b7Divisible = false;

		if (n % 3 == 0){
			b3Divisible = true;
		}
		if (n % 5 == 0){
			b5Divisible = true;
		}
		if (n % 7 == 0){
			b7Divisible = true;
		}

		if (b3Divisible) cout << 3 << " ";
		if (b5Divisible) cout << 5 << " ";
		if (b7Divisible) cout << 7;
		if (!b3Divisible && !b5Divisible && !b7Divisible) cout << "n";
		cout << endl;
	}

	return 0;
}