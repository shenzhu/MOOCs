#include<iostream>
using namespace std;

int main(){
	char chCompareOne[80];
	char chCompareTwo[80];
	//read data
	cin.getline(chCompareOne, 80);
	cin.getline(chCompareTwo, 80);

	//convert both to lower case using ASCII
	for (int i = 0; chCompareOne[i] != '\0'; i++){
		if (65 <= chCompareOne[i] && chCompareOne[i] <= 90){
			chCompareOne[i] += 32;
		}
	}
	for (int i = 0; chCompareTwo[i] != '\0'; i++){
		if (65 <= chCompareTwo[i] && chCompareTwo[i] <= 90){
			chCompareTwo[i] += 32;
		}
	}

	//compare
	int index = 0;
	char result;
	while (chCompareOne[index] != '\0' && (chCompareOne[index] == chCompareTwo[index])){
		index++;
	}
	if (chCompareOne[index] > chCompareTwo[index]){
		result = '>';
	}
	else if (chCompareOne[index] < chCompareTwo[index]){
		result = '<';
	}
	else{
		result = '=';
	}

	cout << result << endl;
	return 0;
}

