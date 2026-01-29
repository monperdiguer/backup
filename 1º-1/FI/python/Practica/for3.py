a=int(input("Introduzca el inicio del intervalo"))
b=int(input("Introduzca el final del intervalo"))
if a<=0:
    print("Este valor no es válido")
    a = int(input("Introduzca el inicio del intervalo(>0)"))
for i in range(a,b-1):
    print((i**2+1)/i)