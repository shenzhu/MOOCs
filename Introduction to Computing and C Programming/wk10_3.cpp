#include<iostream>
using namespace std;

int main(){
	char chSentence[500];
	int iWordStIndex[500];
	//read
	cin.getline(chSentence, 500);

	//find all words
	bool bIsWord = false;
	int iWordCount = 0;
	for (int i = 0; chSentence[i] != '.'; i++){
		if (chSentence[i] == ' '){
			bIsWord = false;
		}
		else if (bIsWord == false){
			bIsWord = true;
			iWordStIndex[iWordCount] = i;
			iWordCount++;
		}
	}

	//find length of last word
	int iLastWordLen = 0;
	for (int i = iWordStIndex[iWordCount - 1]; chSentence[i] != '.'; i++){
		iLastWordLen++;
	}

	//find longest word
	int iLWordStart = 0;
	int iMaxLen = -1;
	for (int i = 0; i < iWordCount - 1; i++){
		//decrease ' '
		int iWordLen = iWordStIndex[i + 1] - iWordStIndex[i] - 1;
		if (iMaxLen < iWordLen){
			iMaxLen = iWordLen;
			iLWordStart = iWordStIndex[i];
		}
	}
	//compare with last word
	if (iMaxLen < iLastWordLen){
		iLWordStart = iWordStIndex[iWordCount - 1];
	}

	//cout
	for (int i = iLWordStart; (chSentence[i] != ' ' && chSentence[i] != '.'); i++){
		cout << chSentence[i];
	}
	return 0;
}