//
// SESION 1.2: ALGORITMOS 2 y 3
//
// ANALISIS EXPERIMENTAL DE FACTORIAL (VERSIONES RECURSIVA E ITERATIVA)
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define NUM_TALLAS 11

// prototipos de funciones
long int Factorial_RECURSIVO(int n);
long int Factorial_ITERATIVO(int n);

// funcion principal
int main()
{
 int i, j, talla, repite;
 double tiempo_RECURSIVO, tiempo_ITERATIVO;
 clock_t tiempo_inicial_RECURSIVO, tiempo_final_RECURSIVO;
 clock_t tiempo_inicial_ITERATIVO, tiempo_final_ITERATIVO;

 int Vtallas[NUM_TALLAS] = { 10000, 12000, 14000, 16000, 18000, 20000, 22000, 24000, 26000, 28000, 30000 };
 int Vrepite[NUM_TALLAS] = { 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000 };

 printf("\n\nSESION 1.2\n\n");
 printf("ALGORITMOS 2 Y 3\n\n");
 printf("Tiempo empleado:\n\n\n");
 printf("\t\tTalla\t\tTiempo recursivo\t\tTiempo iterativo\n");
 printf("\t\t-----\t\t----------------\t\t----------------\n");


 for (i=0; i<NUM_TALLAS; i++)
 {
    talla  = Vtallas[i];
    repite = Vrepite[i];

    // RECURSIVO

    tiempo_inicial_RECURSIVO=clock();
       for(j=0; j<repite; j++)
         Factorial_RECURSIVO(talla);
    tiempo_final_RECURSIVO=clock();


    // ITERATIVO

    tiempo_inicial_ITERATIVO=clock();
       for(j=0; j<repite; j++)
         Factorial_ITERATIVO(talla);
    tiempo_final_ITERATIVO=clock();

    tiempo_RECURSIVO =  (tiempo_final_RECURSIVO-tiempo_inicial_RECURSIVO) / (double)CLOCKS_PER_SEC / repite;
    tiempo_ITERATIVO = (tiempo_final_ITERATIVO-tiempo_inicial_ITERATIVO) / (double)CLOCKS_PER_SEC / repite;

    printf("\t\t%d\t\t%f\t\t\t%f\n", talla, tiempo_RECURSIVO, tiempo_ITERATIVO);

  }
  return 0;
}

//
// definiciones de funciones
//

long int Factorial_RECURSIVO(int n)
{
  if( n == 0){
    return 1;
  }
  else{
    return Factorial_RECURSIVO(n-1)*n;
  }
}


long int Factorial_ITERATIVO(int n)
{
  int i, p;
  p = 1;
  for ( i = 1; i < n; i++)
  {
    p = p * i;
  }
  return p;
  
}
