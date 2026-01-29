
def factorial(numero):
    """Retorna el factorial del numero entero dado"""
    producto=1
    for i in range(numero,0,-1):
        producto=producto*i
    return producto

#Programa principal:Pedir umbral para el valor del factorial
n=int(input("Introduzca el valor del umbral: "))
while n<0:
    print(n,"no vale tiene que ser >0")
    n = int(input("introduzca otro valor para el umbral: "))

#Calcular y mostrar el factorial de todos los numeros enteros del umbral
i=0
fact=factorial(i)
while fact<=n:
    print("El factorial de",i,"es", fact)
    i = i + 1
    fact=factorial(i)

