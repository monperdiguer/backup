n=int(input("Introduzca un numero: "))
cadena= str(n)
cifras=[]
while n>0:
    cifra=n%10
    n=n//10
    if(cifra>n%10):
        cifras.append(cifra)
print("las cifras de mayor a menor valor son:",cifras) #raro