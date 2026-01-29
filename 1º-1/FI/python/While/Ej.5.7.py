n=int(input("Introduzca un numero entero positivo"))
maximo=0
posición_numero=1
posición_maximo=0
while n !=0 and n>0:
    if n>maximo:
        maximo=n
        posicion_maximo=posicion_numero
    n=int(input("Introduzca un numero entero positivo"))
    posicion_numero = posicion_numero + 1
print("El numero mayor es", maximo, "y se proporciono en la posicion",posicion_maximo)

