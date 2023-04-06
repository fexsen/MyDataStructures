#include <iostream>
#include "MyLab13.h"
using namespace std;

	myPolynom::myPolynom() {
		power = NULL;
		coef = nullptr;
	}
	myPolynom::myPolynom(unsigned int in_power, double* in_coef) {
		power = in_power;
		coef = new double[power+1];
		for (int i = 0; i <= power; i++) {
			coef[i] = in_coef[i];
		}
	}
	myPolynom::myPolynom(const myPolynom &pol)
	{
		power = pol.power;
		coef = new double[power+1];
		for (int i = 0; i <= power; i++) {
			coef[i] = pol.coef[i];
		}
	}
	myPolynom::~myPolynom()
	{
		delete[] coef;
	}

	void myPolynom::Print()
	{
		for (int i = power; i >= 0; i--) {
			if (i != 0) {
				cout << '(' << coef[i] << 'x' << '^' << i << ')' << '+';
			}
			else {
				cout << '(' << coef[i] << 'x' << '^' << i << ')';
			}
		}
	}
	myPolynom myPolynom::multConst(double K, myPolynom& t)
	{
		if (K == 0) {
			myPolynom result;
			return result;
		}
		else {
			int power = t.power;
			double* tmp_coef = new double[power + 1];
			for (int i = 0; i <= power; i++) {
				tmp_coef[i] = K * t.coef[i];
			}
			myPolynom result(power, tmp_coef);
			delete[] tmp_coef;
			return result;
		}
	}

	myPolynom myPolynom::operator+(const myPolynom &polsec)
	{
		myPolynom *res;
		if (power >= polsec.power) {
			res = new myPolynom(power, coef);
			for (int i = 0; i <= power; i++) {
				if (i <= polsec.power) {
					res->coef[i] = coef[i] + polsec.coef[i];
				}
				else {
					res->coef[i] = coef[i];
				}
			}
			return *res;
		}
		else {
			res = new myPolynom(polsec.power, polsec.coef);
			for (int i = 0; i <= polsec.power; i++) {
				if (i <= power) {
					res->coef[i] = polsec.coef[i] + coef[i];
				}
				else {
					res->coef[i] = polsec.coef[i];
				}
			}
			return *res;
		}
	}
	myPolynom myPolynom::operator-(const myPolynom &polsec)
	{
		myPolynom* res;
		if (power >= polsec.power) {
			res = new myPolynom(power, coef);
			for (int i = 0; i <= power; i++) {
				if (i <= polsec.power) {
					res->coef[i] = coef[i] - polsec.coef[i];
				}
				else {
					res->coef[i] = -coef[i];
				}
			}
			return *res;
		}
		else {
			res = new myPolynom(polsec.power, polsec.coef);
			for (int i = 0; i <= polsec.power; i++) {
				if (i <= power) {
					res->coef[i] = -polsec.coef[i] + coef[i];
				}
				else {
					res->coef[i] = -polsec.coef[i];
				}
			}
			return *res;
		}
	}
	myPolynom myPolynom::operator*(double K)
	{
		return multConst(K, *this);
	}
	myPolynom myPolynom::operator=(const myPolynom polsec)
	{
		power = polsec.power;
		delete[] coef;
		coef = new double[power+1];
		for (int i = 0; i <= power; i++) {
			coef[i] = polsec.coef[i];
		}
		return *this;
	}
	myPolynom myPolynom::operator+=(const myPolynom polsec)
	{
		*this = *this + polsec;
		return *this;
	}
	myPolynom myPolynom::operator-=(const myPolynom polsec)
	{
		*this = *this - polsec;
		return *this;
	}
	myPolynom myPolynom::operator*=(double K)
	{
		*this = *this * K;
		return *this;
	}
	bool myPolynom::operator==(const myPolynom polsec)
	{
		if (power == polsec.power) {
			for (int i = 0; i <= power; i++) {
				if (coef[i] != polsec.coef[i]) {
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	bool myPolynom::operator!=(const myPolynom polsec)
	{
		if (power == polsec.power) {
			for (int i = 0; i <= power; i++) {
				if (coef[i] != polsec.coef[i]) {
					return true;
				}
			}
			return false;
		}
		else {
			return true;
		}
	}
	bool myPolynom::operator>(const myPolynom polsec)
	{
		if (power > polsec.power && coef[power] > 0) {
			return true;
		}
		else if (power == polsec.power) {
			for (int i = power; i >= 0; i--) {
				if (coef[i] > polsec.coef[i]) {
					return true;
				}
				else if (coef[i] < polsec.coef[i]) {
					return false;
				}
			}
		}
		else {
			return false;
		}
	}
	bool myPolynom::operator<(const myPolynom polsec) 
	{
		if (!(*this > polsec) && *this != polsec) {
			return true;
		}
		else {
			return false;
		}
	}
	bool myPolynom::operator<=(const myPolynom polsec)
	{
		if (*this < polsec || *this == polsec) {
			return true;
		}
		else {
			return false;
		}
	}
	bool myPolynom::operator>=(const myPolynom polsec)
	{
		if (*this > polsec || *this == polsec) {
			return true;
		}
		else {
			return false;
		}
	}
