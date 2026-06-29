// ---------------------------------------------------------------------------------
//
// ALGORITMIA: PRACTICA DE DISEÑO DE ALGORITMOS RECURSIVOS
//
// Se recoge la implementacion en C del algoritmo recursivo que calcula la
// potencia n-esima de a donde a>=0 y n>=0
//
//
// -------------------------------------------------------------------------------------
//
// Completar con las tareas indicadas para el alumno en la sesion 2.1 de practicas
//
//--------------------------------------------------------------------------------------


#include <stdio.h>
#include <stdbool.h>

#define ELEMENTOS 6
#define ORDEN 4

//
// Prototipos de funciones
//
int POTENCIA(int,int);
int POTENCIA_funcionamiento_interno(int,int);


// Prototipos de las funciones a realizar por el alumno
// Completar por el alumno

int POTENCIA3 (int);
int POTENCIA3_funcionamiento_interno(int);
int MCD (int, int);
int MCD_funcionamiento_interno(int, int);
int FACTORIAL(int);
int FACTORIAL_funcionamiento_interno(int);
int SEMIFACTORIAL(int);
int SEMIFACTORIAL_funcionamiento_interno(int);

// OPCIONAL

int iCONTAR_PARES(int [], int);
int iCONTAR_SIMETRICOS (int [][ORDEN], int);


//
// Programa principal
//
int main() 
{
  int n,a;

  printf("\t\t CALCULO LA POTENCIA n-ESIMA DE UN NUMERO\n\n");

  // leer la base
  do{
  printf(" Introduce la base a (a>=0): ");
  scanf("%d",&a);
  } while(a<0);

  // leer el exponente
  do{
  printf(" Introduce el exponente n (n>=0): ");
  scanf("%d",&n);
  } while(n<0);

  printf("\n\n");
  printf(" --------\n");
  printf(" POTENCIA\n");
  printf(" --------\n");

  printf(" La potencia %d-esima de %d es: %d \n\n\n", n, a, POTENCIA(a,n));

  printf(" ---------------------------------------------\n");
  printf(" POTENCIA mostrando el funcionamiento interno \n");
  printf(" ---------------------------------------------\n");

  printf(" \n Se muestra el proceso interno: sucesivas llamadas a la funcion, resultado en el caso base y \n");
  printf(" resultados parciales hasta alcanzar el resultado final");

  printf("\n\n\n DESCENSO en la cadena de llamadas ... (se aplica la FUNCION SUCESOR hasta alcanzar caso base)\n\n");

  printf("\n\nLa potencia %d-esima de %d es: %d \n\n", n, a, POTENCIA_funcionamiento_interno(a,n));


  // Invocacion a las funciones a realizar por el alumno con su entrada y validacion de precondicion correspondiente

  // Invocaciones a las funciones POTENCIA_3 y POTENCIA_3_funcionamiento_interno
  printf("\t\t CALCULO LA POTENCIA n-ESIMA DE 3\n\n");

  do{
  printf(" Introduce el exponente n (n>=0): ");
  scanf("%d",&n);
  } while(n<0);

  printf("\n\n");
  printf(" --------\n");
  printf(" POTENCIA 3\n");
  printf(" --------\n");

  

  printf(" La potencia %d-esima de 3 es: %d \n\n\n", n, POTENCIA3(n));

  printf(" ---------------------------------------------\n");
  printf(" POTENCIA3 mostrando el funcionamiento interno \n");
  printf(" ---------------------------------------------\n");

  printf(" \n Se muestra el proceso interno: sucesivas llamadas a la funcion, resultado en el caso base y \n");
  printf(" resultados parciales hasta alcanzar el resultado final");

  printf("\n\n\n DESCENSO en la cadena de llamadas ... (se aplica la FUNCION SUCESOR hasta alcanzar caso base)\n\n");

   printf("\n\nLa potencia %d-esima de 3 es: %d \n\n", n, POTENCIA3_funcionamiento_interno(n));

  // Invocaciones a las funciones MCD y MCD_funcionamiento_interno
  int b;
  printf("\t\t CALCULO DEL MCD DE DOS NUMEROS\n\n");
  do{
        printf(" Introduce el primer numero (a>=0): ");
        if(scanf("%d",&a) != 1) return 0;
  } while(a<=0);

  // leer el exponente
  do{
        printf(" Introduce el segundo numero (b>=0): ");
        if(scanf("%d",&b) != 1) return 0;
  } while(b<=0);

  printf("\n\n");
  printf(" --------\n");
  printf(" MCD\n");
  printf(" --------\n");

  printf("El MCD de %d y de %d es: %d \n\n\n", a, b, MCD(a,b));

  printf(" ---------------------------------------------\n");
  printf(" MCD mostrando el funcionamiento interno \n");
  printf(" ---------------------------------------------\n");

  printf(" \n Se muestra el proceso interno: sucesivas llamadas a la funcion, resultado en el caso base y \n");
  printf(" resultados parciales hasta alcanzar el resultado final");

  printf("\n\n\n DESCENSO en la cadena de llamadas ... (se aplica la FUNCION SUCESOR hasta alcanzar caso base)\n\n");

   printf("\n\nEl MCD de %d y %d es: %d \n\n", a, b, MCD_funcionamiento_interno(a,b));


  // Invocaciones a las funciones: FACTORIAL y FACTORIAL_funcionamiento_interno
  printf("\t\t CALCULO DEL FACTORIAL DE UN NUMERO\n\n");

  do{
        printf(" Introduce el numero n (n>=0): ");
        if(scanf("%d",&n) != 1) return 0;
  } while(n<0);

  printf("\n\n");
  printf(" --------\n");
  printf(" FACTORIAL\n");
  printf(" --------\n");

  

  printf(" El factorial de %d es: %d \n\n\n", n, FACTORIAL(n));

  printf(" ---------------------------------------------\n");
  printf(" FACTORIAL mostrando el funcionamiento interno \n");
  printf(" ---------------------------------------------\n");

  printf(" \n Se muestra el proceso interno: sucesivas llamadas a la funcion, resultado en el caso base y \n");
  printf(" resultados parciales hasta alcanzar el resultado final");

  printf("\n\n\n DESCENSO en la cadena de llamadas ... (se aplica la FUNCION SUCESOR hasta alcanzar caso base)\n\n");

   printf("\n\nEl factorial de %d es: %d \n\n", n, FACTORIAL_funcionamiento_interno(n));


  // Invocaciones a las funciones: SEMIFACTORIAL y SEMIFACTORIAL_funcionamiento_interno
  // Completar por el alumno
  printf("\t\t CALCULO DEL SEMIFACTORIAL DE UN NUMERO\n\n");

  do{
        printf(" Introduce el numero n (n>=0): ");
        if(scanf("%d",&n) != 1) return 0;
  } while(n<1);

  printf("\n\n");
  printf(" --------\n");
  printf(" SEMIFACTORIAL\n");
  printf(" --------\n");

  

  printf(" El semifactorial de %d es: %d \n\n\n", n, SEMIFACTORIAL(n));

  printf(" ---------------------------------------------\n");
  printf(" SEMIFACTORIAL mostrando el funcionamiento interno \n");
  printf(" ---------------------------------------------\n");

  printf(" \n Se muestra el proceso interno: sucesivas llamadas a la funcion, resultado en el caso base y \n");
  printf(" resultados parciales hasta alcanzar el resultado final");

  printf("\n\n\n DESCENSO en la cadena de llamadas ... (se aplica la FUNCION SUCESOR hasta alcanzar caso base)\n\n");

  printf("\n\nEl semifactorial de %d es: %d \n\n", n, SEMIFACTORIAL_funcionamiento_interno(n));


  //
  // OPCIONAL
  //

 // CONTAR PARES
 
 while(n < 1);
 int V[ELEMENTOS]={1,2,3,3,2,1};
 printf(" -----------\n");
 printf(" CONTAR PARES\n");
 printf(" -----------");
 printf("\n\n El numero de elementos pares es: %d \n\n",iCONTAR_PARES(V,ELEMENTOS));
 

 //CONTAR SIMETRICOS
 
 int M[][ORDEN]={{1,2,5,7},
                 {2,8,6,9},
                 {5,6,9,2},
                 {7,9,2,1}};
 
 printf(" ---------------- \n");
 printf(" CONTAR SIMETRICOS \n");
 printf(" ----------------  ");
 printf("\n\n El numero de parejas simetricas es: %d \n\n", iCONTAR_SIMETRICOS(M,ORDEN));

  return 0;
}

//
// Definiciones de funciones
//

// Potencia
int POTENCIA(int a, int n){
  if (n==0) return 1;
  else return POTENCIA(a,n-1)*a;
}

// Potencia_funcionamiento_interno
int POTENCIA_funcionamiento_interno(int a, int n){
int p;
if (n==0){
        printf("\tpotencia(%d,%d)\n\n",a,n);
        p=1;
        printf("\n\n CASO BASE y su resultado\n\n");
        printf("\tpotencia(%d,%d) ---> resultado = %d\n\n",a,n,p);
        printf("\n\n ASCENSO en la cadena de llamadas ... (se aplica la FUNCION de COMBINACION hasta alcanzar la llamada inicial)\n\n");
        return p;
        }
else{
    printf("\tpotencia(%d,%d)\n",a,n);
    p=POTENCIA_funcionamiento_interno(a,n-1)*a;
    printf("\tpotencia(%d,%d) ---> resultado = %d\n",a,n,p);
    return p;
    }
}


//
// Definicion de las funciones a realizar por el alumno
//

// POTENCIA_3
int POTENCIA3(int n){
  if (n==0) return 1;
  else if (n==1) return 3;
  else return 2*POTENCIA3(n-1) + 3*POTENCIA3(n-2);
}

// POTENCIA_3_funcionamiento_interno
int POTENCIA3_funcionamiento_interno(int n){
int p;
if (n==0){
        printf("\tPOTENCIA3(%d)\n\n",n);
        p=1;
        printf("\n\n CASO BASE n = 0 \n\n");
        printf("\tPOTENCIA3(%d) ---> resultado = %d\n\n",n,p);
        return p;
        }
else if (n==1){
        printf("\tPOTENCIA3(%d)\n\n",n);
        p=3;
        printf("\n\n CASO BASE n = 1 \n\n");
        printf("\tPOTENCIA3(%d) ---> resultado = %d\n\n",n,p);
        return p;
        }
else{
    printf("\tPOTENCIA3(%d)\n",n);
    p=2*POTENCIA3_funcionamiento_interno(n-1) + 3*POTENCIA3_funcionamiento_interno(n-2);
    printf("\tPOTENCIA3(%d) ---> resultado = %d\n",n,p);
    return p;
    }
}

// MCD
int MCD(int a, int b){
  if (a==b) return a;
  else if(a>b) return MCD(a-b,b);
  else return MCD(a,b-a);
}

// MCD_funcionamiento_interno
int MCD_funcionamiento_interno(int a, int b){
int p;
if (a==b){
        printf("\n\n CASO BASE a = b\n\n");
        printf("\tMCD(%d,%d) ---> resultado = %d\n\n",a, b , a);
        return a;
        }
else if(a>b){
   printf("\tMCD(%d,%d)\n",a,b);
   p=MCD_funcionamiento_interno(a-b,b);
   printf("\tpotencia(%d,%d) ---> resultado = %d\n",a,b,p);
   return p;
  }

else{
    printf("\tMCD(%d,%d)\n",a,b);
    p=MCD_funcionamiento_interno(a,b-a);
    printf("\tpotencia(%d,%d) ---> resultado = %d\n",a,b,p);
    return p;
    }
  }

// FACTORIAL
int FACTORIAL(int n){
 if (n==0) return 1;
 else return FACTORIAL(n-1)*n;

}

// FACTORIAL_funcionamiento_interno
int FACTORIAL_funcionamiento_interno(int n){
int p;
if (n==0){
        printf("\tfactorial(%d)\n\n",n);
        p=1;
        printf("\n\n CASO BASE n = 0\n\n");
        printf("\tfactorial(%d) ---> resultado = %d\n\n",n,p);
        return p;
        }
else{
    printf("\tfactorial(%d)\n",n);
    p=FACTORIAL_funcionamiento_interno(n-1)*n;
    printf("\tfactorial(%d) ---> resultado = %d\n",n,p);
    return p;
    }
}
// SEMIFACTORIAL
int SEMIFACTORIAL(int n){
 if (n<=1) return 1;
 else return SEMIFACTORIAL(n-2)*n;

}

// SEMIFACTORIAL_funcionamiento_interno
int SEMIFACTORIAL_funcionamiento_interno(int n){
int p;
if (n<=1){
        printf("\tsemifactorial(%d)\n\n",n);
        p=1;
        printf("\n\n CASO BASE n<=1\n\n");
        printf("\tsemifactorial(%d) ---> resultado = %d\n\n",n,p);
        return p;
        }
else{
    printf("\tsemifactorial(%d)\n",n);
    p=SEMIFACTORIAL_funcionamiento_interno(n-2)*n;
    printf("\tsemifactorial(%d) ---> resultado = %d\n",n,p);
    return p;
    }
}


//
// OPCIONAL
//

int iCONTAR_PARES(int V[], int n){
    if(n == 0) return 0;
    int cnt = iCONTAR_PARES(V, n-1);
    return cnt +((V[n-1] % 2== 0) ? 1 : 0);
}

int iCONTAR_SIMETRICOS(int M[][ORDEN], int n)
{
        return contar_pareas(M,n,0,1);
}

static int contar_pares(int M[][ORDEN], int n, int i, int j){
  if (i >= n-1) return 0;
  if (j >= n) return coontar_pares(M, n, i+1, i+2);
  int add = (M[i][j] == M[j][i]) ? 1 : 0;
  return add + coontar_pares(M, n, i, j+1);
}
