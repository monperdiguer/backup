n=int(input("Introduzca un numero: "))
suma_pares=0
suma_impares=0
total_pares=0
total_impares=0
while n >= 0:
    if n%2==0:
        suma_pares=suma_pares+n
        total_pares=total_pares+1
    else:
        suma_impares=suma_impares+n
        total_impares=total_impares+1
    n = int(input("Introduzca el siguiente numero: "))

if total_pares !=0:
    print("La media de los numeros pares introducidos es", suma_pares/total_pares)
else: print("No has introducido numeros positivos pares")
if total_impares !=0:
    print("La media de los numeros impares introducidos es", suma_impares/total_impares)
else: print("No has introducido numeros positivos impares")