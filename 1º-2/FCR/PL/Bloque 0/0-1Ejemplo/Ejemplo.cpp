#include <iostream>

using std::cout; // cout será lo mismo que std::cout
using std::endl; // endl será lo mismo que std::endl
using std::cin;

void set23(int& number)
{
    number = 23;
}

void f(int v[], int longV); // funcion f que recive un vector de enteros y el tamaño como parametros


int main()
{
    //Salir por pantalla
    cout << "Hello, World!" << endl; 
    cout << "Integer: " << 3 << " Floating-point: " << 4.5 << endl;

    //Pedir por pantalla
    int i;

    cout << "Input an integer: ";
    cin >> i;

    //Ejercicio 4

    int a = 23; //Quitar unsigned para que funcione
    int b = -5;

    cout << "a: " << a << " b: " << b << endl;

    if (a < b)
    {
        cout << "a less than b" << endl;
    }

    //Ejercicio 5

    int j = 10;

    set23(j);
    cout << "j now contains: " << j << endl;

    //Ejericio 6

    int v[4];

    v[0] = 2131; // primer elemento
    v[3] = 112;  // ultimo elemento
    int c[] = { 300, 123, 12 }; // vector de longitud 3

    //Ejercicio 7

    char str[] = "abc"; // str[0]='a' str[1]='b' str[2]='c' str[3]=\0

    const unsigned int maxChars = 100; // const define constantes
    char cadena[maxChars]; //Se pasa a un caracter
    cin.getline(str, maxChars); //Lee los 99 caracteres de la consola

    //Ejercicio 9

    int* pI;   // pI es un puntero para int
    float* pF; // pF es un puntero para float

    int* p;          
    int number = 35;

    cout << "number: " << number << endl;

    p = &number;     // p ahora apunta al numero
    *p = 555;
    number = 101;

    cout << "number: " << number << endl;
    cout << "*p: " << *p << endl;

    /*
    void* p; // p is a pointer to anything
    int i = 23;
    float f = 55.2;
    p = &i;
    int i2 = *((int*)p);
    p = &f;
    float f2 = *((float*)p);
    */

    return 0;
}