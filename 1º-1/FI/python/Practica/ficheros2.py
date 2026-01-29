f=open("alumnos.txt")
alumnos=f.readlines()
f.close()
print(alumnos)

suma_alumnos=0
for i in alumnos:
    suma_alumnos+=1
print("Hay",suma_alumnos,"alumnos")

def coinciden_apellidos(linea,apellido):
    partes=linea.split(",")
    nombre=partes[1]
    apellidos=partes[0]
    return apellido in apellidos

print(coinciden_apellidos("Lopez Alvarez, Andres", "Lopez"))

numero_Fernandez=0
for i in alumnos:
    if coinciden_apellidos(i,"Fernandez"):
        numero_Fernandez+=1
print("Porcentaje:",numero_Fernandez/suma_alumnos*100.0)

def palabras_nombre(linea):
    partes=linea.split(",")
    nombre=partes[1]
    palabras=nombre.split()
    return len(palabras)

numero_palabras=[0,0,0,0,0,0]
for i in range(len(numero_palabras)):
    n_palabras=palabras_nombre(alumnos[i])
    numero_palabras[n_palabras]+=1
print(numero_palabras)
