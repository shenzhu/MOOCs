#include <iostream>
using namespace std;
int main(){
	int m, n, result = 0;
	cin >> m >> n;
	while (m <= n){
		//if it is odd, then add it
		if (m % 2 == 1){
			result += m;
		}
		m++;
	}
	//cout
	cout << result << endl;
	return 0;
}