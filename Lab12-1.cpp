#include <iostream>
#include "MyLab12-1.h"
using namespace std;

int myLen(const char* str)
{
    int g = 0;
    for (int i = 0; str[i] != '\0'; i++){
      g++;
    }
    return (g);
}
        myString::myString()
        {
            str = nullptr;
        }
        myString::myString(const char* str)
        {
            int len = myLen(str);
            this->str = new char[len+1];
            for (int i = 0; i < len; i++){
                this->str[i] = str[i];
            }
            this->str[len] = '\0';
        }
        
        void myString::chrSplit(const char splstr){
            char** strnew;
            int count = 0;
            int cnt = 0;
            for(int i = 0; i < myLen(str); i++){
                if(str[i] == splstr){
                    count++;
                }
                if(str[i] == splstr && str[i+1] == splstr){
                    cnt++;
                }
            }
            count = count*2+1-cnt;
            strnew = new char*[count];
            int id = 0;
            for(int i = 0; i < count; i++){
                int r = id;
                int sz = 0;
                for(r; str[r] != splstr; r++){
                    sz++;
                }
                if(sz == 0){
                    sz++;
                }
                strnew[i] = new char[sz+1];
                for(int j = 0; j < sz; j++){
                    strnew[i][j] = str[id];
                    id++;
                }
                strnew[i][sz] = '\0';
            }
            for(int i = 0; i < count; i++){
                for(int j = 0; strnew[i][j] != '\0'; j++){
                    cout << strnew[i][j];
                }
                if(i == count-1){break;}
                cout << '|';
            }
            for(int i = 0; i < count; i++){
                delete[] strnew[i];
            }
        }
        void myString::strSplit(const char* string){
            for(int i = 0; i < myLen(string); i++){
                chrSplit(string[i]);
                cout << endl;
            }
        }
        char* myString::strCut(int i1, int i2)
        {
            int len = myLen(str);
            char* strnew;
            int i3 = i1 + len - i2 + 1;
            if(i2 < i1){
                cout << "ERROR";
                return nullptr;
            }
            char* tstr1 = new char[i1+1];
            char* tstr2 = new char[len - i2+1];           
            for(int i = 0; i < i1; i++){
                tstr1[i] = str[i];
            }
            for(int i = i2+1; i < len; i++){
                tstr2[i-i2] = str[i];
            }
            strnew = new char[i3];
            for(int i = 0; i <= i1; i++){
                strnew[i] = tstr1[i];
            }
            for(int i = 0; i < len - i2+1; i++){
                strnew[i+i1] = tstr2[i];
            }
            strnew[i1] = ' ';
            delete[] tstr1;
            delete[] tstr2;
            return strnew;
        }
        
        myString myString::strInsert(int i1, const char* symb)
        {
            myString strnew;
            int i2 = i1;
            int i3 = i1 + myLen(str) - i2 + myLen(symb);
            char* tstr1 = new char[i1];
            char* tstr2 = new char[myLen(str) - i2 + 2];           
            for(int i = 0; i < i1; i++){
                tstr1[i] = str[i];
            }
            for(int i = i2; i < myLen(str); i++){
                tstr2[i-i2] = str[i];
            }
            strnew.str = new char[i3+1];
            for(int i = 0; i < i1; i++){
                strnew.str[i] = tstr1[i];
            }
            for(int i = 0; i < myLen(symb); i++){
                strnew.str[i+i1] = symb[i];
            }
            for(int i = 0; i < myLen(str) - i2; i++){
                strnew.str[i+i1+myLen(symb)] = tstr2[i];
            }
            strnew.str[i3] = '\0';
            delete[] tstr1;
            delete[] tstr2;
            return strnew;
        }
        
        myString::myString(const myString &other)
        {
            int len = myLen(str);
            this->str = new char[len+1];
            for (int i = 0; i < len; i++){
                this->str[i] = str[i];
            }
            this->str[len] = '\0';
        }
        
        myString& myString::operator=(const myString &other)
        {
            if (this->str != nullptr){
                delete[] str;
            }
            int len = myLen(str);
            this->str = new char[len+1];
            for (int i = 0; i < len; i++){
                this->str[i] = str[i];
            }
            this->str[len] = '\0';
            return *this;
        }
        myString myString::operator+(const myString &other)
        {
            myString res;
            int thislen = myLen(this->str);
            int otherlen = myLen(other.str);
            res.str = new char[thislen + otherlen + 1];
            int i = 0;
            for (; i < thislen; i++){
                res.str[i] = this->str[i];
            }
            for (int j = 0; j < otherlen; j++, i++){
                res.str[i] =  other.str[j];
            }
            res.str[thislen + otherlen] = '\0';
            return res;
        }
        
        int myString::myStrlen()
        {
            return myLen(str);
        }
        myString::~myString()
        {
            delete[] this->str;
        }
        void myString::Print()
        {
            cout << str << endl;
        }