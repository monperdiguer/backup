//
// SESION 1.2: ALGORITMO 1
//
// ANALISIS EXPERIMENTAL DE LA FUNCION COMPRUEBA
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

#define NUM_TALLAS 10

// prototipos de funciones
int **CreaMatriz(int n);
int *CreaVector(int n);
void RellenaMatriz(int **M, int n, int p);
void RellenaVector(int *V, int n, int p);
void LiberaMatriz(int **M, int n);
void LiberaVector(int *V);
bool Comprueba(int **M, int *V, int n);

int main()
{
 int i, j, talla, repite;
 int **M=NULL, *V=NULL;
 double tiempo_MC, tiempo_PC;
 clock_t tiempo_inicial_MC, tiempo_final_MC;
 clock_t tiempo_inicial_PC, tiempo_final_PC;

 // tallas y repeticiones
 int Vtallas[NUM_TALLAS] = { 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
 int Vrepite[NUM_TALLAS] = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};


 printf("\n\nSESION 1.2\n\n");
 printf("ALGORITMO 1\n\n");
 printf("\t\tTalla\t\tTiempo MC\t\tTiempo PC\n");
 printf("\t\t-----\t\t---------\t\t---------\n");

// bucle para las tallas a medir
 for (i=0; i<NUM_TALLAS; i++)
 {
    talla  = Vtallas[i];
    repite = Vrepite[i];

    
    // crear matriz y vector
    M=CreaMatriz(talla);
    V=CreaVector(talla);

    //
    // MEJOR CASO
    //

    // rellenar matriz y vector
   
    RellenaMatriz(M, talla, repite);
    RellenaVector(V, talla, repite);

    tiempo_inicial_MC=clock();
      // bucle repeticiones
       for(j=0; j<repite; j++)
         Comprueba(M, V, talla);
    tiempo_final_MC=clock();

    //
    // PEOR CASO
    //

    // rellenar matriz y vector
    
    RellenaMatriz(M, talla, 8);
    RellenaVector(V, talla, 9);

    tiempo_inicial_PC=clock();
      // bucle repeticiones
       for(j=0; j<repite; j++)
         Comprueba(M, V, talla);
    tiempo_final_PC=clock();

    // libera matriz y vector
    LiberaMatriz(M, talla);
    LiberaVector(V);

    M=NULL; V=NULL;

    // calculo de los tiempos empleados
    tiempo_MC = (tiempo_final_MC-tiempo_inicial_MC) / (double)CLOCKS_PER_SEC / repite;
    tiempo_PC = (tiempo_final_PC-tiempo_inicial_PC) / (double)CLOCKS_PER_SEC / repite;
   
    // mostrar talla y tiempos empleados
    printf("\t\t%d\t\t%f\t\t%f\n", talla, tiempo_MC, tiempo_PC);

  }
  return 0;
}
//
// definiciones de funciones
//

int **CreaMatriz(int n)
{
   int **M = NULL;

   M = (int **) malloc(n * sizeof(int*));

   int i;
   for( i = 0; i < n; i++){
      M[i] = (int *) malloc(n * sizeof(int));
   }

   return M;
}

int *CreaVector(int n)
{
   int *V = NULL;

   V = (int *) malloc(n * sizeof(int));

   return V;
}

void RellenaMatriz(int **M, int n, int p)
{
   int i, j;
   for(i = 0; i < n; i++)
      for(j = 0; j < n; j++)
         M[i][j] = p;
}

void RellenaVector(int *V, int n, int p)
{
   int i;
   for(i = 0; i < n; i++)
         V[i] = p;
}

void LiberaMatriz(int **M, int n)
{
   int i;
   for(i = 0; i < n; i++){
      free(M[i]);
   }
}

void LiberaVector(int *V){
       free(V);
}

bool Comprueba(int **M, int *V, int n)
{
      bool resultado;
       int i, j;
       resultado = false;
       for(i = 0; i < n  && !resultado; i++){
              for(j = 0; j < n  && !resultado; j++){
                     if(M[i][j] == V[j]){
                            resultado = true;
                     }
              }

       }
       return resultado;
}