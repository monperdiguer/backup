fichero = open("quijote.txt")
lineas = fichero.readlines()
fichero.close()
#mostar lista
for elemento in lineas:
    print(elemento)
def numero_palabras(lineas):
    for j in lineas:

        palabras = elemento.split(" ")
        suma_palabras = 0
        for i in range(len(palabras)):
            suma_palabras += 1
            print("En la linea", j, "hay", suma_palabras, "palabras")
            maximo_palabras = int(palabras[0])
            if maximo_palabras < int(palabras[i]):
                maximo_palabras = palabras[i]
            return maximo_palabras

print("La línea más larga del fichero es: ", numero_palabras(lineas))