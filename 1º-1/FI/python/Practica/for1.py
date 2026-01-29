n=int(input("Introduzca un número entero"))
if n<0:
    print("Este valor no es válido")
    n = int(input("Introduzca un número entero"))
for i in range(0,n):
    print("*", end="")