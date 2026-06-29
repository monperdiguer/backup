// --------------------------------------------------------------------------
//
//  ALGORITMIA: IMPLEMENTACION DEL ALGORITMO "MOCHILA 0/1" Y
//
//              DEL ALGORITMO "DESCOMPONER UN NUMERO N EN M SUMANDOS"
//
//              [OPCIONAL] EMBARCADEROS
//
//  SESION 3.2 DE PRACTICAS (ESQUEMAS ALGORITMICOS - PROGRAMACION DINAMICA)
//
// ---------------------------------------------------------------------------


#include <stdio.h>
#include <stdlib.h>

// prototipos de funciones
int MOCHILA_programacion_dinamica (int *, int *, int, int);
int DESCOMPONER_programacion_dinamica(int,int);

// EMBARCADEROS (OPCIONAL)
int EMBARCADEROS_programacion_dinamica(int, int **);

int main(){
int n,C,i;
int *P;
int *B;

do{
    printf("Introduce la capacidad de la mochila: ");
    scanf("%d",&C);
} while(C<0);

do{
    printf("\nIntroduce el numero de objetos:  ");
    scanf("%d",&n);
} while(n<0);

// reserva dinamica de memoria para vectores de pesos y beneficios
// los vectores P y B tienen n+1 elementos, en esta implementacion ignoraremos la posicion 0
// de ese modo, es igual al algoritmo visto en clase

P=(int *)malloc((n+1)*sizeof(int));
B=(int *)malloc((n+1)*sizeof(int));

// posición 0 reservada (+ facil pa indexar)
//P[0] = 0;
//B[0] = 0;

printf("\n\nIntroduce los pesos de los %d objetos\n",n);
for (i=1;i<=n;i++){
   do {
    printf("\nPeso[%d]= ", i);
    scanf("%d",&P[i]);
   } while(P[i]<=0);
}

printf("\n\nIntroduce los beneficios de los %d objetos\n",n);
for (i=1;i<=n;i++){
    do {
        printf("\nBeneficio[%d]= ", i);
        scanf("%d",&B[i]);
    } while(B[i]<=0);
   }

// La funcion MOCHILA_programacion_dinamica recibe:
// - los vectores P y B con los pesos y beneficios de los objetos, respectivamente,
// - el numero de objetos, n, y
// - la capacidad de la mochila, C

printf("\n\n\n y el beneficio maximo es: %d\n",MOCHILA_programacion_dinamica(P,B,n,C));
printf("\n\n");

// liberar memoria
free(P);
free(B);

//
// DESCOMPOSICION DE N EN M SUMANDOS
//
int N,M;
do{
    printf("Introduce el numero a descomponer: ");
    scanf("%d",&N);
} while(N<=0);
do{
    printf("\nIntroduce el numero de sumandos en los que se va a descomponer:  ");
    scanf("%d",&M);
} while(M<=0||M>N);

printf("\n\n\n y producto maximo es: %d\n",DESCOMPONER_programacion_dinamica(N,M));
printf("\n\n");


//
// EMBARCADEROS [OPCIONAL]
//

int **c;
printf("Introduce el numero de embarcaderos: ");
scanf("%d",&n);

// reserva dinámica de memoria para la matriz de costes C
c = (int **)malloc((n+1)*sizeof(int *));
for(int i=1;i<=n;i++){
    c[i] = (int *)malloc((n+1)*sizeof(int));
}

// lectura de la matriz C de costes
printf("\n\nIntroduce la matriz de costes:\n");
int j;
for(i=1;i<=n;i++){
    for(j=1;j<=n;j++){
        do{
        printf("C[%d][%d] = ", i, j);
        scanf("%d",&c[i][j]);
        } while(c <= 0);
    }
}

printf("\n\nEl coste final del recorrido es %d\n",EMBARCADEROS_programacion_dinamica(n,c));


return 0;
}

//
// definiciones de funciones
//
int MOCHILA_programacion_dinamica (int *P, int *B, int n, int C){
int **Bmax;
int **Dec;
int *X;

// reserva dinamica de memoria para X, esto es, para el vector de decisiones
X = (int *)malloc((n+1)*sizeof(int));
X[0]=0;

// reserva dinamica de memoria de las matrices Bmax y Dec
Bmax = (int **)malloc((n+1)*sizeof(int *));
Dec  = (int **)malloc((n+1)*sizeof(int *));
for(int j=0;j<=n;j++){
    Bmax[j] = (int *)malloc((C+1)*sizeof(int));
    Dec[j]  = (int *)malloc((C+1)*sizeof(int));
}

// 1ª parte: inicializar las matrices con los resultados de los problemas triviales
for(int c=0;c<=C;c++){
    Bmax[0][c] = 0;//si es 0 no hace falta poner pero si por ej fuera un 7 si
    Dec[0][c]  = 0;
}

// 2ª parte: rellenar las matrices por filas en sentido ascendente
for(int j=1;j<=n;j++){
    for(int c=0;c<=C;c++){
        if(c < P[j]){
            Bmax[j][c] = Bmax[j-1][c];
            Dec[j][c]  = 0;
        }
        else{
            if(Bmax[j-1][c] >= Bmax[j-1][c-P[j]] + B[j]){
                Bmax[j][c] = Bmax[j-1][c];
                Dec[j][c]  = 0;
            }
            else{
                Bmax[j][c] = Bmax[j-1][c-P[j]] + B[j];
                Dec[j][c]  = 1;
            }
        }
    }
}

// 3ª parte: solucion
int j=n, c=C;
while(j > 0){
    X[j] = Dec[j][c];
    c -= X[j] * P[j];
    j--;
}

// mostrar por pantalla la secuencia de decisiones optima
printf("\nSecuencia Óptima:\n");
for(int k=1;k<=n;k++){
    printf("X[%d] = %d\n", k, X[k]);
}
int resultado = Bmax[n][C];

// liberar memoria
for(int i=0;i<=n;i++){
    free(Bmax[i]);
    free(Dec[i]);
}
free(Bmax);
free(Dec);
free(X);

// retornar el beneficio maximo
return resultado;
}


int DESCOMPONER_programacion_dinamica(int N, int M){
int **Pmax;
int **Dec;
int *S;

// reserva dinamica de memoria para S, esto es, para el vector de decisiones
S = (int *)malloc((M+1)*sizeof(int));
S[0] = 0;

// reserva dinamica de memoria de las matrices Pmax y Dec
Pmax = (int **)malloc((M+1)*sizeof(int *));
Dec  = (int **)malloc((M+1)*sizeof(int *));
for(int i=0;i<=M;i++){
    Pmax[i] = (int *)malloc((N+1)*sizeof(int));
    Dec[i]  = (int *)malloc((N+1)*sizeof(int));
}

// 1ª parte: inicializar las matrices con los resultados de los problemas triviales
for(int j=0;j<=N;j++){
    Pmax[1][j] = j;
    Dec[1][j]  = j;
}

// 2ª parte: rellenar las matrices por filas en sentido ascendente
for(int i=2;i<=M;i++){
    for(int j=0;j<=N;j++){
        if(j < i){
            Pmax[i][j] = 0;
            Dec[i][j]  = 0;
        }
        else{
            int mejor = 0;
            int mejor_k = 1;

            for(int k=1; k <= j-(i-1); k++){
                int prod = k * Pmax[i-1][j-k];
                if(prod > mejor){
                    mejor = prod;
                    mejor_k = k;
                }
            }
            Pmax[i][j] = mejor;
            Dec[i][j]  = mejor_k;
        }
    }
}

// 3ª parte: solucion
int suma = N;
for(int i=M;i>=1;i--){
    S[i] = Dec[i][suma];
    suma -= S[i];
}

// mostrar por pantalla la secuencia de decisiones optima
printf("\nSecuencia óptima de sumandos:\n");
for(int i=1;i<=M;i++){
    printf("S[%d] = %d\n", i, S[i]);
}
int resultado = Pmax[M][N];

// liberar memoria
for(int i=0;i<=M;i++){
    free(Pmax[i]);
    free(Dec[i]);
}
free(Pmax);
free(Dec);
free(S);

// retornar el producto maximo
return resultado;
}


// [OPCIONAL]

int EMBARCADEROS_programacion_dinamica(int n, int **C){
    int *Costemin;
    int *Dec;
    int *X;
    int j, k;

    /* 1ª parte: inicializar la estructura de almacenamiento con los resultados
    de los problemas triviales */

    Costemin = (int *)malloc((n+1)*sizeof(int));
    Costemin[n] = 0;

    Dec  = (int *)malloc((n+1)*sizeof(int));
    Dec[n] = 0;

    X = (int *)malloc((n+1)*sizeof(int));

    /* 2ª parte: rellenar la estructura de almacenamiento con los resultados 
    de los problemas no triviales, en sentido ascendente, mas sencillo a menos
    */
    for(j = n - 1;j >= 1; j--){

        Costemin[j] = 999999999;

        for(k = j+1; k <= n; k++){
            if(Costemin[j] > (C[j][k] + Costemin[k])){
                Costemin[j] = (C[j][k] + Costemin[k]);
                Dec[j] = k;
            }
        }
    }

    // 3ª parte: solucion
    X[1] = 1;
    j = 1;
    while (X[j] != n){
        j++;
        X[j] = Dec[X[j-1]];
    }

    // mostrar por pantalla la secuencia de decisiones optima
    printf("\nSecuencia óptima de costes:\n");
    for(int i=1; i<= j; i++){
        printf("%d\n", X[i]);
    }

    printf("Coste mínimo = %d\n", Costemin[1]);

    int resultado = Costemin[1];

    free(Costemin);
    free(Dec);
    free(X);

    // retornar el coste minimo
    return resultado;

}

