//
// ANALISIS EXPERIMENTAL DEL PRODUCTO MATRICIAL
//

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define NUM_TALLAS 12

// prototipos de funciones
void RellenaMatriz(double **M, int m, int n);
double **CreaMatriz(int m, int n);
void LiberaMatriz(double **M, int m);
void Multiplica(double **A, double **B, double **C, int n);

// funcion principal
int main()
{
 int i, j, talla, repite;
 double **A=NULL, **B=NULL, **C=NULL, tiempo;
 clock_t tiempo_inicial, tiempo_final;

 // tallas y repeticiones
 int Vtallas[NUM_TALLAS] = { 25,   50,  75, 100, 125, 150, 175, 200, 225, 250, 275, 300};
 int Vrepite[NUM_TALLAS] = {1000, 500, 250, 100,  50,  40,  30,  20,  10,   5,   5,   5};

 printf("\n\nSesion 1.1\n\n");
 printf("Tiempo empleado:\n\n\n");
 printf("\t\tTalla\t\tTiempo\n");
 printf("\t\t-----\t\t------\n");

// bucle para las tallas a medir
 for (i=0; i<NUM_TALLAS; i++)
 {
    talla  = Vtallas[i];
    repite = Vrepite[i];
   
    // crear matrices
    A=CreaMatriz(talla, talla);
    B=CreaMatriz(talla, talla);
    C=CreaMatriz(talla, talla);
   
    // rellenar matrices
    RellenaMatriz(A, talla, talla);
    RellenaMatriz(B, talla, talla);

    // bucle repeticiones
    tiempo_inicial=clock();
       for(j=0; j<repite; j++)
          Multiplica(A, B, C, talla);
    tiempo_final=clock();

    LiberaMatriz(A, talla);
    LiberaMatriz(B, talla);
    LiberaMatriz(C, talla);
    A=NULL; B=NULL; C=NULL;

    tiempo = (tiempo_final-tiempo_inicial) / (double)CLOCKS_PER_SEC / repite;

    // mostrar talla y tiempo empleado
    printf("\t\t%d\t\t%f\n", talla, tiempo);
  }
  return 0;
}

//
// definiciones de funciones
//

void RellenaMatriz(double **M, int m, int n)
{
   int i, j;

   for(i=0; i<m; i++)
      for(j=0; j<n; j++)
         M[i][j]=rand();
}

double **CreaMatriz(int m, int n)
{
   double **M = NULL;

   M = (double **) malloc(m * sizeof(double*));
   int i;
   for(i = 0; i <m; i++){
      M[i] = (double *) malloc(n * sizeof(double));
   }

   return M;
}

void LiberaMatriz(double **M, int m)
{
   int i;
   for(i = 0; i<m; i++){
      free(M[i]);
   }

}
void Multiplica(double **A, double **B, double **C, int n)
{
   int i, j, k;
   for(i = 0; i < n; i++){
      for(j = 0; j <n; j++){
         double dtmp = 0.0;
         for(k = 0; k < n; k++){
            dtmp += A[i][k] * B[k][j];
         }
         C[i][j] = dtmp;
      }
   }
}
