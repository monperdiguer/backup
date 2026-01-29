contador=0
numero=1
while contador<n:
#for numero in range(1, n):
    cubo=numero**3

    suma = 0
    while cubo>0:
        suma=suma+cubo%10
        cubo=cubo//10
    if numero==suma:
        print("Encontramos el numero",numero, "siento su cubo",numero**3)
        contador=contador+1
    numero=numero+1
