a=int(input("Introduzca el inicio: "))
b=int(input("Introduzca el final: "))

while a<0 and b<0:
    print("Alguno de los valores no es valido")
    a = int(input("Introduzca un valor inicial entero positivo: "))
    b = int(input("Introduzca un valor final entero positivo: "))

suma=0
for i in range(a,b+1):
    suma+= + (i**2+1)/i
print("El sumatorio es: ", suma)