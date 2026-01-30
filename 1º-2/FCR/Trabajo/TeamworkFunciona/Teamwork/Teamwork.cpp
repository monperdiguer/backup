#include <iostream>
#include<string>

using std::cout;
using std::endl;
using std::cin;
using std::string;
using std::stoi;

//ID utilizado es UO306389

extern "C" bool IsValidAssembly(int num1, int num2, int num3);

char ID[] = "306389";



void ControlInAsm() {
    int num1, num2, num3;

    std::cout << "Ingrese tres numeros enteros: ";
    std::cin >> num1 >> num2 >> num3;

    if (IsValidAssembly(num1, num2, num3) == 0) {
        std::cout << "Algo salio mal" << std::endl;
        exit(1);
    }

    std::cout << "Condiciones validas" << std::endl;
}

void CheckPassword() {
    char ID[20];
    char password[20];

    std::cout << "Ingrese el ID: ";
    std::cin >> ID;

    if (strlen(ID) < 10 || ID[5] != ID[2]) {
        std::cout << "Acceso incorrecto" << std::endl;
        exit(1);
    }

    std::cout << "Ingrese la contraseña: ";
    std::cin >> password;

    if (strcmp(password, "yumBwE") != 0) {
        std::cout << "El acceso no fue correcto" << std::endl;
        exit(1);
    }
}



void MaskAccess() {
    unsigned int num1, num2;
    cout << "Ingrese dos numeros enteros sin signo de 32 bits: ";
    cin >> num1 >> num2;


    int ID1 = ID[1] - '0';
    int ID2 = ID[2] - '0';
    int ID3 = ID[3] - '0';
    int ID4 = ID[4] - '0';


    if (((num1 >> ID2) & 1) != ((num2 >> ID4) & 1)) {
        cout << "Intruso detectado" << endl;
        exit(EXIT_FAILURE);
    }


    unsigned int mask = ((1U << (ID3 - ID1 + 1)) - 1) << ID1;
    if (num2 & mask) {
        cout << "¡Alto ahi!" << endl;
        exit(EXIT_FAILURE);
    }

    cout << "Acceso concedido" << endl;
}

void ChecksumVerifier() {
    int valores[4], suma = 0;
    cout << "Ingrese 4 numeros enteros: ";
    for (int i = 0; i < 4; i++) {
        cin >> valores[i];
        suma += valores[i];
        cin >> suma;
    }
    cout << suma;
    if ((suma * ID[1]) > 450) { // ID[1] = 0, por lo que la multiplicación siempre será 0
        cout << "¡Alto ahí!" << endl;
        exit(EXIT_FAILURE);
    }

    cout << "Verificacion correcta" << endl;
}

int main() {
    CheckPassword();
    MaskAccess();
    ControlInAsm();
    ChecksumVerifier();

    std::cout << "Acceso permitido" << std::endl;
    return 0;
}