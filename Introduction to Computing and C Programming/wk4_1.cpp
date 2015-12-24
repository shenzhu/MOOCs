#include<iostream>
using namespace std;

int main(){
	int n, a[1000]; //n numbers, n <= 1000, a stores the number
	cin >> n;
	//enter n numbers
	for (int i = 0; i < n; i++){
		cin >> a[i];
	}

	//bubble, compare neighboring two numbers
	for (int i = 0; i < n - 1; i++){
		for (int j = 1; j < n - i; j++){
			if (a[j - 1] > a[j]){
				int temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
			}
		}
	}

	//output 
	for (int i = 0; i < n; i++){
		cout << a[i] << endl;
	}
	return 0;
}