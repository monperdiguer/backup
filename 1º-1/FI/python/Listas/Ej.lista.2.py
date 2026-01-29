#Ejercicio 1
lista=[5,8,10]
suma=0
for i in range(len(lista)):
    suma+=lista[i]
print()
print("La suma de los valores es",suma)
print("La suma de los valores es",sum(lista))
print(suma==sum(lista))

#Ejercicio2
def posicion_maximo(lista):
    #Para cuando la lista este vacía
    if len(lista)==0:
        return None

    indice_maximo=0
    maximo=lista[0]
    for i in range(1,len(lista)):
        if(maximo<lista[i]):
            indice_maximo=i
            maximo=lista[i]
    return indice_maximo

print()
print("EL maximo es",max(lista),"y se encuentra en la posicion",posicion_maximo(lista))

#Ejercicio3
print()
def pon_ceros(datos):
    cambios=0
    for i in range(len(datos)):
        if(datos[i]<0):
            cambios=cambios+1
            datos[i]=0
    return cambios

datos=[3,-4,5,7,-1,8]
print(pon_ceros(datos))
print(datos)

#Ejercicio4
def suma_potencias(lista2,numero):
    suma=0
    for i in range(len(lista2)):
        suma+=lista2[i]**numero
    return suma
print()
numero=float(input("Introduzca a que valor quiere elevar la lista: "))
lista2=[3,4,19,8]
print("La suma de las potencias es",suma_potencias(lista2,numero))


