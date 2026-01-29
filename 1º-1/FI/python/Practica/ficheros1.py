from Listas.Introduccion import elemento

f=open("datos.txt")
datos=f.readlines()
f.close()
print(datos)
print("El numero de lineas de este fichero es",len(datos))

datos= int(datos)
def suma_elementos(datos):
    suma=0
    for i in range(datos[0],len(datos)):
        suma+=datos[i]
    return suma

print("La suma de los numeros es",suma_elementos(datos))
#???