#
# ANALISIS EXPERIMENTAL DEL PRODUCTO MATRICIAL
#

import numpy             as np
import matplotlib.pyplot as plt

from random import random     
from time   import time

# Funcion que crea una matriz como una lista de listas. La matriz se inicializa con numeros aleatorios
def CreaListaAlea(m, n):
   C = []
   for i in range(m):
      a = [0.0]*n
      for j in range(n):
         a[j] = random()
      C.append(a)
   return C

# Funcion que crea una matriz como una lista de listas. La matriz se inicializa con 0s
def CreaListaZeros(m, n):
   C = []
   for i in range(m):
      a = [0.0]*n
      C.append(a)
   return C

#
#  Funciones para realizar el producto matricial C = A * B
#

# Funcion que realiza el producto matricial. Las matrices estan definidas como listas de listas Python
def NaiveListas(n, A, B):
  C = CreaListaZeros(n, n)

  for i in range(n):
    for j in range(n):
      for k in range(n):
        C[i][j] = C[i][j]+A[i][k]*B[k][j]
  return C

# Funcion que realiza el producto matricial. Las matrices son creadas con funciones numpy
def NaiveNumpy(n, A, B):
  C = np.zeros((n, n), order='C', dtype=np.float64)

  for i in range(n):
    for j in range(n):
      for k in range(n):
        C[i,j] = C[i,j]+A[i,k]*B[k,j]
  return C

# PROCESO PARA MEDIR

# tallas y repeticiones
talla       =  [ 25,  50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300]
repite = [200, 100, 50,  20,  10,   8,   6,   4,   2,   1,   1,   1]

# vectores para almacenar tiempos
Eje_YTeorico = np.zeros(len(talla), dtype=np.float64)
Eje_YLista   = np.zeros(len(talla), dtype=np.float64)
Eje_YNumpy   = np.zeros(len(talla), dtype=np.float64)

# bucle para recorrer las tallas
for i in range(0,len(talla)):
  n=talla[i]
  
  # crear las matrices A y B como listas de listas Python
  AListas = CreaListaAlea(n, n)
  BListas = CreaListaAlea(n, n)

  # crear las matrices A y B con funciones numpy
  ANumpy = np.random.rand(n, n).astype(np.float64)
  BNumpy = np.random.rand(n, n).astype(np.float64)

  #
  # NAIVELISTAS
  #

  # bucle para las repeticiones
  secs = time()
  for j in range(repite[i]):
    C=NaiveListas(n, AListas, BListas) 
  Eje_YLista[i] = (time()- secs)/repite[i]
   
  # mostrar talla de las matrices y tiempo empleado
  print(f"NaiveListas {n}x{n}x{n} Segundos={Eje_YLista[i]:1.5E}")

  #
  # NAIVENUMPY
  #

  # bucle para las repeticiones
  secs = time()
  for j in range(repite[i]):
    C=NaiveNumpy(n, ANumpy, BNumpy)
  Eje_YNumpy[i] = (time()- secs)/repite[i]
   
  # mostrar talla de las matrices y tiempo empleado
  print(f"NaiveNumpy  {n}x{n}x{n} Segundos={Eje_YNumpy[i]:1.5E}")

  # tiempo teorico
  Eje_YTeorico[i] = talla[i]**3

# ajustes
Promedio_Listas_vs_Numpy=np.mean(Eje_YNumpy / Eje_YLista)
Promedio_Listas_vs_Teorico=np.mean(Eje_YTeorico / Eje_YLista)

print(f"NaiveNumpy es NaiveListas multiplicado por {Promedio_Listas_vs_Numpy:1.5E}")
print(f"NaiveTeorico es NaiveListas multiplicado por {Promedio_Listas_vs_Teorico:1.5E}")

Ajuste_Numpy   = Eje_YLista * Promedio_Listas_vs_Numpy
Ajuste_Teorico = Eje_YLista * Promedio_Listas_vs_Teorico

# grafica tiempo NaiveNumpy vs tiempo NaiveListas * constante
plt.plot(talla, Eje_YNumpy,         color='xkcd:green', label='NaiveNumpy')
plt.plot(talla, Ajuste_Numpy, 'o-', color='xkcd:red',   label='NaiveListas * cte')
plt.xlabel('talla')
plt.ylabel('tiempo')
plt.legend(loc='upper left')
plt.title('NaiveNumpy vs NaiveListas*cte')
plt.show()

# grafica tiempo teórico vs tiempo NaiveListas * constante
plt.plot(talla, Eje_YTeorico,         color='xkcd:green', label='NaiveTeórico')
plt.plot(talla, Ajuste_Teorico, 'o-', color='xkcd:red',   label='NaiveListas * cte')
plt.xlabel('talla')
plt.ylabel('tiempo')
plt.legend(loc='upper left')
plt.title('NaiveTeórico vs NaiveListas*cte')
plt.show()