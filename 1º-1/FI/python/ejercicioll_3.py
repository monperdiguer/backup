s1 = str(input("Introduzca la primera cadena de texto: "))
s2 = str(input("Introduzca la segunda cadena de texto: "))
lista1 = s1.split()
lista2 = s2.split()
for i in range(len(lista1)):
    for j in range(len(lista2)):
        resultado = lista1[i]+lista2[j]

print(resultado)
