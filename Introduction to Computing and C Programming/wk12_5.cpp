#include<iostream>
using namespace std;

int main(){
	char chArray[50];

	//read 
	while (cin.getline(chArray, 15)){
		int iSpacePos = 0;
		char chStr[15];
		char chSubstr[3];

		//find sub and str length
		for (int i = 0; chArray[i] != 32; i++){
			chStr[i] = chArray[i];
			if (chArray[i + 1] == 32) iSpacePos = i + 1;
		}
		chStr[iSpacePos] = '\0';	//add '\0'


		//find substr
		for (int i = iSpacePos + 1; chArray[i] != '\0'; i++){
			chSubstr[i - iSpacePos - 1] = chArray[i];
		}

		//find char with max ASCII in str
		int iMaxASCIIPos = 0;
		int iMaxASCII = 0;
		for (int i = 0; chStr[i] != '\0'; i++){
			if (chStr[i] > iMaxASCII){
				iMaxASCII = chStr[i];
				iMaxASCIIPos = i;
			}
		}

		//move char after max 3 pos
		chStr[iSpacePos + 3] = '\0';	//add '\0'
		for (int i = iSpacePos - 1; i > iMaxASCIIPos; i--){
			chStr[i + 3] = chStr[i];
		}

		//insert substr
		for (int i = 0; i < 3; i++){
			chStr[iMaxASCIIPos + 1 + i] = chSubstr[i];
		}

		for (int i = 0; i < iSpacePos + 3; i++){
			cout << chStr[i];
		}
		cout << endl;
	}
	return 0;
}