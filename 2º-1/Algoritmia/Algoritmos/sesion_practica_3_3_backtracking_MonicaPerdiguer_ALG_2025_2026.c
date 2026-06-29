// ------------------------------------------------------------------------------------------
//
//  ALGORITMIA: IMPLEMENTACION SEGUN BACKTRACKING DE LA SOLUCION DEL PROBLEMA DE DESCOMPONER
//              UN NUMERO N EN M SUMANDOS CON N>=M>0 DE TAL MODO QUE LOS M SUMANDOS
//              SUMEN N Y SU PRODUCTO SEA MAXIMO. SE GENERARAN ADEMAS: TODAS LAS
//              SOLUCIONES FACTIBLES Y LA PRIMERA FACTIBLE.
//
//
//  SESION 3.3 DE PRACTICAS (ESQUEMAS ALGORITMICOS - BACKTRACKING)
//
// -------------------------------------------------------------------------------------------

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <string.h>
#include <stdbool.h>

// prototipos de las funciones backtracking
void DESCOMPONER_BACK_TODAS(int , int , int , int *);
void DESCOMPONER_BACK_UNA(int , int , int , int *, bool *);
void DESCOMPONER_BACK_OPTIMA(int , int , int , int *, int *, int *);

// prototipos de las funciones auxiliares que utiliza backtracking: correcto, valor, tratar
int correcto(int , int , int* , int);
int valor(int *, int );
void tratar(int *, int );

// funcion main
int main(){
int N,M;
int *x,*x_mejor,v_mejor;
bool flag;

do{
   printf ("\nIntroduce el numero N a descomponer (N>0): ");
   scanf("%d",&N);
}while(N<=0);

do{
    printf("\nIntroduce el numero de sumandos en los que se va a descomponer:  ");
    scanf("%d",&M);
} while(M<=0||M>N);

//
// Los vectores x y x_mejor tienen tamaño M+1, no utilizaremos la posicion 0
//

x=(int*)malloc((M+1)*sizeof(int));
x_mejor=(int *)malloc((M+1)*sizeof(int));

// invocamos a TODAS_LAS_FACTIBLES de BACKTRACKING
printf("\n\nTODAS LAS SOLUCIONES FACTIBLES\n");
DESCOMPONER_BACK_TODAS(N,M,1,x);

// invocamos a UNA_FACTIBLE de BACKTRACKING
printf("\n\nUNA TUPLA FACTIBLE:\n");
flag=true;
DESCOMPONER_BACK_UNA(N,M,1,x,&flag);

// invocamos a OPTIMA de BACKTRACKING
printf("\n\nSOLUCION OPTIMA:\n");
v_mejor=INT_MIN;
DESCOMPONER_BACK_OPTIMA(N,M,1,x,x_mejor,&v_mejor);

// mostrar la solucion (secuencia de decisiones optima y beneficio maximo)
tratar(x_mejor,M);
printf("\t\tEl producto maximo de la descomposicion es: %d\n", v_mejor);

// liberar memoria
free(x);
free(x_mejor);

return 0;
}


//
// BACKTRACKING
//

// definiciones de las funciones auxiliares que utiliza backtracking: correcto, valor y tratar
int correcto(int N, int M, int *x, int k){
    int i, suma=0;
    for(i=1;i<=k;i++){
        suma +=x[i];
    }
    return suma;
}

int valor(int *x, int M){
    int p = 1;
    for(int i = 1; i <= M; i++)
        p = p * x[i];
    return p;
}

void tratar(int *x, int n){
    printf("< ");
    for(int i = 1; i <= n; i++)
        printf("%d ", x[i]);
    printf(">\n");
}


void DESCOMPONER_BACK_TODAS(int N, int M, int k, int *x){
  x[k]=0;    // preparar_recorrido_nivel_k
  while (x[k]< (N - M + 1)){  // mientras exista_hermano_nivel_k
        x[k]=x[k]+1; // siguiente_hermano_nivel_k
        if (k==M && correcto(N,M,x,k)== N)
            tratar(x, M); // si solucion(x,k) y correcto(x,k)
        if(k<M && correcto(N,M,x,k)<N)
            DESCOMPONER_BACK_TODAS(N, M, k+1, x);// si no es solucion(x,k) y correcto(x,k)
       }
    }

void DESCOMPONER_BACK_UNA(int N, int M, int k, int *x, bool *flag){
  x[k] = 0;
  while(x[k] < (N - M + 1) && *flag == true){
        x[k]=x[k]+1;
        if(k == M && correcto(N,M,x,k) == N){
            *flag = false;
            tratar(x,M);
        }

        if(k<M && correcto(N,M,x,k) <N)
            DESCOMPONER_BACK_UNA(N, M, k+1, x, flag);
    }
}


void DESCOMPONER_BACK_OPTIMA(int N, int M, int k, int *x, int *x_mejor, int *v_mejor){
  int i, aux;
    x[k] = 0;
    while(x[k] < (N - M + 1)){
        x[k]=x[k]+1;
        if(k == M && correcto(N,M,x,k) == N){
            aux = valor(x, M); // funcion objetivo

            if(aux > *v_mejor){
                *v_mejor = aux;
                memcpy(x_mejor, x, (M+1)*sizeof(int));
                //memcpy copia los primeros n bytes del area de memoria apuntada por
                //s2 al area de memoria apuntada por s1
            }
        }

        if(k < M && correcto(N,M,x,k) < N)
            DESCOMPONER_BACK_OPTIMA(N, M, k+1, x, x_mejor, v_mejor);
    }
}

