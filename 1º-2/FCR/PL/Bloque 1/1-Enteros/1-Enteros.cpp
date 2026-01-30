#include <iostream>
using namespace std;

int main()
{	
	int a;
	int b;

	cout << "Introduzca el valor a: " << endl;

	cin >> a;

	cout << endl;

	cout << "Introduzca el valor b: " << endl;

	cin >> b;

	cout << endl;

	int c = a + b;
	cout << "c:";
	cout << c << endl;
	
	int d = a / 2 + b / 2;
	cout << "d:";
	cout << d << endl;
	
	cout << "a: " << a << " b: " << b << endl;

	if (a < b)
	{
		cout << "a es menor que b" << endl;
	}

	return 0;

	const int UN_MILLON = 1000000;

	int contador = 0;

	for (int i = 0; i < 3000 * UN_MILLON; i++)
		contador++;

	cout << "contador " << contador << endl;
}
