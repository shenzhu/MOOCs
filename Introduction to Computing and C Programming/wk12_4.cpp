#include<iostream>
using namespace std;

int main(){
	int iNumbers[2];
	char chOperator;
	int result;

	//cin
	cin >> iNumbers[0] >> iNumbers[1];
	cin >> chOperator;

	switch (chOperator)
	{
	case '+':
		result = iNumbers[0] + iNumbers[1];
		cout << result << endl;
		break;
	case '-':
		result = iNumbers[0] - iNumbers[1];
		cout << result << endl;
		break;
	case '*':
		result = iNumbers[0] * iNumbers[1];
		cout << result << endl;
		break;
	case '/':
		if (iNumbers[1] == 0){
			cout << "Divided by zero!" << endl;
			break;
		}
		else{
			result = iNumbers[0] / iNumbers[1];
			cout << result << endl;
			break;
		}
	default:
		cout << "Invalid operator!" << endl;
		break;
	}

	return 0;
}