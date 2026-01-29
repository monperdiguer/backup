a=float(input("Introduce el valor de a: "))
b=float(input("Introduce el valor de b: "))

if a!=0:
    print("La solución es: ", -b/a)
else:
    if b==0 :
        print("Hay infinitas soluciones")
    else:
        print("No tiene solución")

