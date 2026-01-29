num1=int(input("Introduce el primer numero: "))
num2=int(input("Introduce el segundo numero: "))
num3=int(input("Introduce el tercer numero: "))
num4=int(input("Introduce el cuarto numero: "))
num5=int(input("Introduce el quinto numero: "))

#Se podría utilizar la funcion print(max(num1,num2,num3,num4,num5)
maximo=num1
if maximo<num2:
    maximo=num2
if maximo<num3:
    maximo=num3
if maximo<num4:
    maximo=num4
if maximo<num5:
    maximo=num5
print("El numero maximo es: ", maximo)