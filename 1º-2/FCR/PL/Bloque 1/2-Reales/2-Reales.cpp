#include <iostream>
#include <iomanip>
using namespace std;

int main()
{	
	float f = -27.625;

	cout << "f: ";
	cout << f << endl;
	

	float f1 = 0.1;
	float f2 = 0.3;
	cout << "f1: " << setprecision(15) << f1 << endl; //añade más cifraws significativas

	cout << "f2: " << setprecision(15) << f2 << endl;

	const float TOLERANCIA = 0.0000001;
	if (fabs(f1 * 3.0 - f2) < TOLERANCIA) //fabs = valor absoluto
		cout << "Son iguales" << endl;
	else
		cout << "Son distintos" << endl;

	char c1 = 'a';
	char c2 = 'ñ';

	cout << "c1: "; //Para ver la ventana de memoria, depurar, ventana, memoria, memoria1
	cout << c1 << endl;

	c2 = 0xa4;
	cout << "c2: ";
	cout << c2 << endl;


	return 0;
}
