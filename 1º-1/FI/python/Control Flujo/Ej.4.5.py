num=int(input("Introduce un número: "))
print("ESCOGE UNA OPCION. Calcular: \n"
      "a) El cuadrado del número \n"
      "b) El cubo del número \n"
      "c) El doble del número \n")
opcion=input("Opción? ")

if opcion== 'a':
    print("El cuadrado del número",num,"es:",num**2)
elif opcion== 'b':
    print("El cubo del numero", num,"es", num**3)
elif opcion== 'c':
    print("El doble del numero",num,"es", 2*num)
else:
    print("Esa opción no existe")