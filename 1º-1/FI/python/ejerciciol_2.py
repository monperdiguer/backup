umbral = int(input("Introduzca un valor entero para el umbral (>0): "))
digito = int(input("Introduzca un dígito [0,9]: "))
#casos inválidos
if umbral<=0:
    print("Este valor no es válido")
    umbral = int(input("Introduzca un valor entero para el umbral (>0): "))
if digito<0 or digito>9:
    print("Este valor no es válido")
    digito = int(input("Introduzca un dígito [0,9]: "))

#recorremos el umbral
for i in range(0, umbral):
    #miramos todas las posiciones del numero para ver si tiene ese digito
    if i % 10 == digito:
        print(i)
