n=int(input("Introduzca un numero natural: "))
while n<0:
    print(n,"no es válido.Tiene que ser >0")
    n=int(input("Dime un numero >0: "))


suma=0
for i in range(1,n+1):
    suma=suma+i
print("La suma de los",n,"primeros numeros natruales es",suma)
