#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int isLet(char ch) 
{
    return ((('a' <= ch) && (ch <= 'z')) || (('A' <= ch) && (ch <= 'Z')));
}

int myLen(char* str)
{
    int g = 0;
    for (int i = 0; isLet(str[i]) || str[i] == ' '; i++){
      g++;
    }
    return (g);
}

int wordLen(char** pmas, int id, size_t wcntr)
{
    if (id == wcntr-1){
        return myLen(pmas[wcntr-1]);
    }
    return (myLen(pmas[id]) - myLen(pmas[id+1]) - 1);
}

int wordLen(char** pmas, int id)
{
    return (myLen(pmas[id]) - myLen(pmas[id+1]) - 1);
}

void wordOut(char** pmas, int id)
{
    string txt = *pmas;
    for (int i = id; txt[i] != ' '; i++){
        cout << txt[i];
    }
}

void outText(char *arr, size_t cntr, size_t wcntr, const char* word)
{
    char** ptrmas = new char*[wcntr]; 
    int id = 0;
    for (int i = 0; i <= cntr; i++){
        if (isLet(arr[i]) && (arr[i-1] == ' ' || i == 0)){
            ptrmas[id] = new char[myLen(&arr[i])];
            ptrmas[id] = &arr[i];
            id++;
        }
    }
    for (int i = 0; i < wcntr-1; i++){
        int count = 0;
        for (int j = 0; j < wcntr-1; j++){
            string cword;
            for (int r = 0; ptrmas[j][r] != ' ' && ptrmas[j][r] != '\0'; r++){
                cword[r] = ptrmas[j][r];
            }
            if (cword == word){
                count++;
            }
        }
        cout << count << endl;
    }
}

int main()
{
    fstream fs("Lab11Text.txt");
    if (!fs.is_open()){
        cout << "File not found";
        return 0;
    }
    string currfile;
    while (!fs.eof()){
            getline (fs, currfile);
        }
    size_t count = 0;
    char a;
    for (int i = 0; currfile[i] != '\0'; i++){
        count++;
    }
    fs.clear();
    fs.seekg(0);
    char* mas = new char[count];
    for (int i = 0; i < count; i++){
        mas[i] = currfile[i];
    }
    fs.close();
    size_t wcount = 1;
    for (int i = 0; i < count; i++){
        if (isLet(mas[i]) && mas[i-1] == ' '){
            wcount++;
        }
    }
    outText(mas, count, wcount, "programming");
    delete[] mas;
}
