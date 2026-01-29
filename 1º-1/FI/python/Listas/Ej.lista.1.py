lista1=[5,8,10]
lista2=[3,2,9,12,4]

for i in range(len(lista1)):
    print(lista1[i],end=" ")
print()
for i in range(len(lista2)-1,-1, -1):
    print(lista2[i], end=" ")

suma=0
for i in range(len(lista2)):
    suma+=lista2[i]
print()
print(suma)
print(sum(lista2))
print(suma==sum(lista2))


