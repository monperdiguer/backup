n=int(input("Introduzca un numero entero: "))
for i in range(2,n):
    if n%i==0:
        print(n,"no es primo, es divisible por",i)
        break
else: print(n,"es primo")