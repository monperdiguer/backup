//
// ALGORITMIA: PRACTICA DE DIVIDE Y VENCERAS
//
// MAXIMO_VECTOR - PRODUCTO_VECTOR - ORDEN_ESTRICTO_CRECIENTE_VECTOR - EXAMEN RECURSION NOVIEMBRE 2020
// -----------------------------------------------------------------------------------------------------------------------------------------------
//
// TAREAS.-
//
// Programa en el que se pide el tamanio del vector (n>=1), se reserva dinamicamente memoria,
// se leen sus elementos. Los elementos se muestran por pantalla y seguidamente, a traves de las funciones
// MAXIMO_VECTOR, SUMA_VECTOR, DOBLE_VECTOR, que deben seguir el esquema de divide y venceras, 
// se buscara el elemento de mayor valor en el vector, se calculara la suma de los elementos del vector y se indicara
// si todo elemento del vector es el doble del elemento situado a su izquierda, respectivamente.
//
// Programa en el que se pide el numero de filas y de columnas de la matriz (n,m>=1), se reserva dinamicamente memoria y
// se leen sus elementos. Los elementos se muestran por pantalla y seguidamente, a traves de la funcion
// EXAMEN_RECURSION_NOVIEMBRE_2018 (MODELO A), que debe seguir el esquema de divide y venceras, se resolverá el problema 1 del 
// examen del tema 2 (curso 2018/2019):
//
// "Dada una matriz de enteros A[1..n][1..m] siendo n≥1 y m≥1, diseñar una función recursiva que retorne cierto si se cumple que
//  los elementos de cada fila de la matriz, leídos de izquierda a derecha, están en orden estrictamente decreciente"
//
//-------------------------------------------------------------------------------------------------------------------------------------------------


#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

//
// prototipos de funciones
//

int  lee_vector(int *, int);
int  escribe_vector(int *, int);
void lee_matriz (int **, int, int);
void escribe_matriz (int **, int, int);

//
// prototipos de las funciones maximo, suma y doble

int  maximo_vector_DyV(int *,int,int);

// TAREA ALUMNO: DESCOMENTAR LAS DOS LÍNEAS SIGUIENTES
int  suma_vector_DyV(int *,int,int);
bool doble_vector_DyV(int *,int,int);

//
// prototipos de la funcion EXAMEN RECURSION NOVIEMBRE 2018 y funciones auxiliares si se precisan
//

// TAREA ALUMNO: COMPLETAR LAS DOS LÍNEAS SIGUIENTES Y AÑADIR MÁS SI SE PRECISAN
bool EXAMEN_RECURSION_NOVIEMBRE_2018_version_filas (int **, int, int, int);
bool EXAMEN_RECURSION_NOVIEMBRE_2018_version_columnas (int **, int, int, int);

bool filaDecreciente(int*, int );
bool medioDecreciente(int** , int , int );


// programa principal
int main() {

    int n,m,x;
    int *V;

    do{
       printf("\nIntroduce el numero de elementos del vector para obtener el maximo, la suma y para saber si todo elemento es el doble del elemento situado a su izquierda (>=1): ");
       scanf("%d",&n);} while (n<1);

    // reservar dinamicamente memoria
    V = (int*) malloc(n*sizeof(int));


    lee_vector(V,n);
    escribe_vector (V,n);

    printf("\nEl maximo de los elementos del vector es %d\n\n",maximo_vector_DyV(V,0,n-1));

    printf("\nLa suma de los elementos del vector es %d\n\n",suma_vector_DyV(V,0,n-1));

    if (doble_vector_DyV(V,0,n-1))
        printf("\nTodo elemento del vector cumple que es el doble del elemento situado a su izquierda");
    else
        printf("\nNo todo elemento del vector cumple que es el doble del elemento situado a su izquierda");

    //liberar memoria
    free(V);

    //
    // PROBLEMA 2 DEL EXAMEN RECURSION NOVIEMBRE 2018 (MODELO A)
    //
    printf("\n\n\n A continuacion introduce los datos de una matriz (dimension y elementos)");
    
    do{
       printf("\nIntroduce el numero de filas (>=1): ");
       scanf("%d",&n);} while (n<1);

    do{
       printf("\nIntroduce el numero de columnas (>=1): ");
       scanf("%d",&m);} while (m<1);

    // definimos una variable de tipo puntero a puntero a int y reservamos memoria para n filas
    int **M = (int**) malloc(n*sizeof(int*));

    //reservamos espacio para las columnas
    for(int i=0;i<n;i++)
            M[i] = (int*) malloc(m*sizeof(int));

    // Leemos la matriz
    lee_matriz (M,n,m);


    printf("\n\nLa matriz introducida es:\n\n");

    // Mostramos el contenido de la matriz
    escribe_matriz (M,n,m);

    //Invocamos a las funciones que comprueban la propiedad en la matriz introducida

    // TAREA ALUMNO: COMPLETAR LAS LLAMADAS A AMBAS FUNCIONES

    if (EXAMEN_RECURSION_NOVIEMBRE_2018_version_filas(M, 0, n-1, m)) 
        printf("\n[DyV por filas] Si se cumple que los elementos de cada fila de la matriz, leidos de izquierda a derecha, estan en orden estrictamente decreciente\n\n");
    else 
        printf("\n[DyV por filas] No se cumple que los elementos de cada fila de la matriz, leidos de izquierda a derecha, estan en orden estrictamente decrecienten\n");

    if (EXAMEN_RECURSION_NOVIEMBRE_2018_version_columnas(M,0, m-1, n)) 
        printf("\n[DyV por columnas] Si se cumple que los elementos de cada fila de la matriz, leidos de izquierda a derecha, estan en orden estrictamente decreciente\n\n");
    else 
        printf("\n[DyV por columnas] No se cumple que los elementos de cada fila de la matriz, leidos de izquierda a derecha, estan en orden estrictamente decreciente\n\n");

    // Liberamos el espacio reservado para las columnas
    for (int i=0;i<n;i++) free(M[i]);

    // Liberamos el espacio reservado para las filas
    free(M);

    return 0;
}

//
// Definiciones de funciones
//

// Funcion para leer las componentes del vector
int lee_vector(int *V, int n){
    for (int i=0;i<n;i++) {
        printf("\nDame el valor de la componente %d: ",i+1);
    scanf("%d",V+i);
    }
    return 0;
}

// Funcion para escribir las componentes del vector
int escribe_vector(int *V, int n){
    printf("\nEl vector introducido es: [ ");
    for (int i=0;i<n;i++)
        printf("%d ",*(V+i));
    printf("]\n");
    return 0;
}


void lee_matriz (int **M, int n, int m){
    int i,j;
    for (i=0;i<n;i++)
        for (j=0;j<m;j++){
            printf("\nDame el elemento [%d,%d] :  ",i+1,j+1);
            scanf("%d",&M[i][j]);
        }
    }

void escribe_matriz (int **M, int n, int m){
    int i,j,aux;
    for (i=0;i<n;i++)
    {
        for (j=0;j<m;j++)
            printf("%d\t",M[i][j]);
    printf("\n\n");
    }
}

// Funcion que proporciona el maximo del vector siguiendo el esquema de Divide y Venceras

int maximo_vector_DyV(int *V, int inicio, int fin){
    int max_izq, max_dcha, mitad;

// caso trivial
if (inicio == fin) return V[inicio];

// caso no trivial
else {
    // dividir
    mitad=(inicio+fin)/2;

    // resolver
    max_izq  = maximo_vector_DyV(V,inicio,mitad);
    max_dcha = maximo_vector_DyV(V,mitad+1, fin);

    // combinar
    return (max_izq > max_dcha) ? max_izq : max_dcha;
    }
}


// Funcion que proporciona la suma de los elementos del vector siguiendo el esquema de Divide y Venceras

int suma_vector_DyV(int *V, int inicio, int fin){
    int suma_izq, suma_dcha, mitad;

// caso trivial
if (inicio == fin) return V[inicio];

// caso no trivial
else {
    // dividir
    mitad=(inicio+fin)/2;

    //resolver
    suma_izq = suma_vector_DyV(V,inicio,mitad);
    suma_dcha = suma_vector_DyV(V, mitad+1, fin);

    return suma_izq + suma_dcha;
    }
}


// Funcion que determina si todo elemento del vector es el doble del elemento situado a su izquierda siguiendo el esquema de Divide y Venceras

bool doble_vector_DyV(int *V, int inicio, int fin){
    bool doble_izq, doble_dcha, medio;
    int mitad;

    // caso trivial
    if (inicio == fin) return true;

    // caso no trivial
    else {
        // dividir
        mitad=(inicio+fin)/2;

        //resolver
        doble_izq = doble_vector_DyV(V,inicio, mitad);
        doble_dcha = doble_vector_DyV(V, mitad+1, fin);

        medio = V[mitad] * 2 == V[mitad + 1];

        return doble_izq && doble_dcha && medio;
        }
}


// Funcion que soluciona el problema 1 del examen del tema 2 (curso 2018/2019-MODELO A), siguiendo el esquema de Divide y Venceras (division por filas)

// TAREA ALUMNO: COMPLETAR LOS PARAMETROS DE LA FUNCION
bool EXAMEN_RECURSION_NOVIEMBRE_2018_version_filas(int **M, int fila_inicial, int fila_final, int m){
bool decreciente_izq, decreciente_dcha;
int mitad;

// caso trivial
if (fila_inicial == fila_final) return filaDecreciente(M[fila_inicial], m);

// caso no trivial
else {
    // dividir
    mitad=(fila_inicial + fila_final)/2;

    decreciente_izq = EXAMEN_RECURSION_NOVIEMBRE_2018_version_filas(M, fila_inicial, mitad, m);
    decreciente_dcha = EXAMEN_RECURSION_NOVIEMBRE_2018_version_filas(M,mitad+1, fila_final, m);

    return decreciente_izq && decreciente_dcha;
    }
}




// Funcion que soluciona el problema 1 del examen del tema 2 (curso 2018/2019-MODELO A), siguiendo el esquema de Divide y Venceras (division por columnas)

// TAREA ALUMNO: COMPLETAR LOS PARAMETROS DE LA FUNCION
bool EXAMEN_RECURSION_NOVIEMBRE_2018_version_columnas(int **M, int columna_inicial, int columna_final, int n){
bool decreciente_izq, decreciente_dcha;
int mitad;

// caso trivial
if (columna_inicial == columna_final) return true;

// caso no trivial
else {
    // dividir
    mitad =(columna_inicial + columna_final)/2;

    decreciente_izq = EXAMEN_RECURSION_NOVIEMBRE_2018_version_filas(M, columna_inicial, mitad, n);
    decreciente_dcha = EXAMEN_RECURSION_NOVIEMBRE_2018_version_filas(M,mitad+1, columna_final, n);

    return decreciente_izq && decreciente_dcha && medioDecreciente(M, n, mitad);
    }
}


bool filaDecreciente(int* fila, int m) {
    for (int j = 0; j < m - 1; j++) {
        if (fila[j] <= fila[j+1]) {
            return false;
        }
    }
    return true;
}

bool medioDecreciente(int** M, int n, int medio){
    for (int i = 0; i < n - 1; i++) {
        if (M[i][medio] <= M[i][medio + 1]) {
            return false;
        }
    }
    return true;
}
