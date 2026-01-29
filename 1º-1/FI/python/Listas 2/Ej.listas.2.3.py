f=open("alumnos.txt")
alumnos=f.readlines()
f.close()

numero_alumnos=len(alumnos)
print("Numero total de alumnos ",numero_alumnos)

def coincide_apellido(linea,apellido):
    partes=linea.split(",")#separar la coma
    apellidos=partes[0]
    nombre=partes[1]
    return apellido in apellidos

print(coincide_apellido("Lopez Alvarez,Andres","Lopez"))

numero_fernandez=0
for i in alumnos:
    if coincide_apellido(i,"Fernandez"):
        numero_fernandez+=1
print("Numero total de 'Fernandez'",numero_fernandez)
print("Porcentaje: ",100.0*numero_fernandez/numero_alumnos)

def palabras_en_nombre(linea):
    partes = linea.split(",")
    nombre = partes[1]
    palabras=nombre.split()
    #devolvemos la longitud de la lista split
    return len(palabras)

numero_palabras=[0,0,0,0,0,0,0,0]
#recorrer la lista por posiciones
for i in range(len(alumnos)):
    n_palabras=palabras_en_nombre(alumnos[i])
    numero_palabras[n_palabras]+=1
print(numero_palabras)


