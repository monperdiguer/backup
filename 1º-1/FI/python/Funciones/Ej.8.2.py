def suma_divisores_propios(numero):
    """ Calcular los divisores de un numero"""
    suma=0
    for i in range(1,numero):
        if numero%i==0:
            print(i, end=" ")
            suma = suma + i
    return suma

#Programa principal:Comprobrar si un numero entero es propio
n=int(input("Introduzca el numero entero: "))
while n<1:
    print(n,"no vale tiene que ser >1")
    n = int(input("introduzca otro valor: "))

if suma_divisores_propios(n)==n:
    print("El numero",n,"ES perfecto")
else:
    print("El numero",n,"NO es perfecto")
