n=input("Introduzca un numero: ")
while n<0:
    n=int(input(str(n) + "tiene que ser positivo. Introduce un numero entero positivo"))
print("Has introducido el numero", n)