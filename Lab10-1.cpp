#include <iostream>
#include <string>
#include <fstream>
using namespace std;

int isLet(char ch) 
{
    return ((('a' <= ch) && (ch <= 'z')) || (('A' <= ch) && (ch <= 'Z')) || (('0' <= ch) && (ch <= '9')) || (ch == '_') || (ch == '-'));
}

char ParseArr(string cfile, int n)
{
    ofstream res("arraysinCprog1.txt", ofstream::app); 
    if(res.is_open()){
        int pos1 = -1;
        int pos2 = 0;
        int pos3 = 0;
        int count = 0;
        pos1 = cfile.find('[');
        if(pos1 != -1){
            for(int i = pos1-1; cfile[i] != '\0'; i++){
                if(cfile[i] == '['){
                    count++;
                }
                if(cfile[i] == '\"') {
                    break;
                }
            }
        }
        if(count > n){
            for(int r = pos1; !isLet(cfile[r]); r--){
                pos2 = r;
            }
            for(int i = pos2 - 1; cfile[i] != ' ' && cfile[i] != '('; i--){
                pos3 = i;
            }
            for(int j = pos3; j <= pos2; j++){
                if(isLet(cfile[j])){
                    res << cfile[j];
                }
            }
            res << ' ';
        }
    }
    res.close();  
    return 0;
}


int main()
{
    ofstream outclear("arraysinCprog1.txt");
    outclear << ' ';
    outclear.close();
    string currfile;
    int n;
    cout << "Enter array dimension: " << endl;
    cin >> n;
    ifstream f("inputCprog.txt");
    if(f.is_open()){
        while(!f.eof()){
            getline (f, currfile);
            ParseArr(currfile, n);
        }
    }
    else return 0;
    f.close();
    return 0;
}
