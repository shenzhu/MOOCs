#include<iostream>
using namespace std;

int main(){
	char chReads[80];
	int iTimes[5] = { 0 };
	//read data
	cin.getline(chReads, 80);

	for (int i = 0; chReads[i] != '\0'; i++){
		switch (chReads[i])
		{
		case 'a':
			iTimes[0]++;
			break;
		case 'e':
			iTimes[1]++;
			break;
		case 'i':
			iTimes[2]++;
			break;
		case 'o':
			iTimes[3]++;
			break;
		case 'u':
			iTimes[4]++;
			break;
		default:
			break;
		}
	}

	//cout
	for (int i = 0; i < 5; i++){
		cout << iTimes[i] << " ";
	}
	return 0;
}