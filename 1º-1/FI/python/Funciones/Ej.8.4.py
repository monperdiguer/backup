def es_primo(numero):
    for i in range(2,numero):
        if numero%i==0:
            return False
    return True

#Programa principal:Comprobar si un numero es primo
n=int(input("Introduzca el numero: "))
while n>1:
    if es_primo(n):
        print(n,"es primo")
    else: print(n,"no es primo")
    n = int(input("Introduzca el numero: "))
