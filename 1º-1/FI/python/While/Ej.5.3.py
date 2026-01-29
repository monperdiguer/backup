n=int(input("Introduzca un numero: "))
suma=0
total=0
while n >= 0:
    suma=suma+n
    total=total+1
    n = int(input("Introduzca el siguiente numero: "))
if total!=0:
    print("La media de los numeros introducidos es", suma/total)
else: print("No has introducido numeros positivos")