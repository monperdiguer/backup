f = open("datos.txt")
datos=f.readlines()
f.close()
print(datos)

#pasar de str a int
for i in range(len(datos)):
    datos[i]=int(datos[i]) #errror no sé por qué

#metodo suma
suma=0
for j in range(len(datos)):
    suma+=datos[j]
print(suma)

print(sum(datos))

