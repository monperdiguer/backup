f=open("prueba.txt")
datos=f.readlines()
f.close()
print(datos)
print("El número de lineas del fichero es: ",len(datos))

#mostrar la lista
for elemento in datos:
    print(elemento,end="")

#contar caracteres
print("Numero de caracteres de la linea 3: ",len(datos[2])) #Cuenta el \n del final

for i in range(len(datos)):
    print(datos[i].rstrip()) #Elimina los elementos invisibles de la derecha de la cadena