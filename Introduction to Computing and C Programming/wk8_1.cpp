#include<iostream>
using namespace std;

int main(){
	//use best to enum cars
	int best;
	for (best = 1; best <= 4; best++){
		//use a, b, c, d to record four sentences
		bool a = (best == 2);
		bool b = (best == 4);
		bool c = !(best == 3);
		bool d = !b;
		if (a + b + c + d != 1){
			continue;
		}

		//cout
		cout << best << endl;
		if (a == 1){
			cout << "A" << endl;
		}
		else if (b == 1)
		{
			cout << "B" << endl;
		} 
		else if (c == 1){
			cout << "C" << endl;
		}
		else if (d == 1){
			cout << "D" << endl;
		}
	}
	return 0;
}