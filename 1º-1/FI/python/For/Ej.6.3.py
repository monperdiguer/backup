n=int(input("Introduzca un numero natural: "))
while n<0:
    print(n,"no es válido.Tiene que ser >=0")
    n=int(input("Dime un numero >=0: "))

caracter="*"
for i in range(1,n):
    caracter=caracter+"*"
print(caracter)