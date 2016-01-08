#include<iostream>
using namespace std;

int main(){
	int a;
	bool bIsLeapYear = false;
	cin >> a;
	
	if (a % 4 == 0){
		if (!(a % 100 == 0 && a % 400 != 0)){
			if (!(a % 3200 == 0)){
				bIsLeapYear = true;
			}
		}
	}

	if (bIsLeapYear){
		cout << "Y" << endl;
	}
	else{
		cout << "N" << endl;
	}

	return 0;
}