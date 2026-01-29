n=int(input("Introduzca un numero natural: "))
while n<0:
    print(n,"no es válido.Tiene que ser >=0")
    n=int(input("Dime un numero >=0: "))

producto=1
for i in range(1,n+1):
    producto=producto*i
print("El factorial de",n,"es",producto)

