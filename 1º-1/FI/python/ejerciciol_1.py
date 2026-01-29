n = int(input("Introduzca un número de notas: "))
#caso inválido
if n < 0:
    print("Este valor no es válido")
    n = int(input("Introduzca un número de notas(>=0): "))
#calculamos la media
suma_media = 0
for i in range(0, n):
    nota_individual = float(input("Introduzca una nota: "))
    #sumamos las notas en el caso de que sean válidas
    if nota_individual >= 0 and nota_individual <= 10:
        suma_media += nota_individual

media = suma_media/n
print("La media de las notas es:", media)
#texto según tu nota
if media>=0 and media<5:
    print("Suspenso")
elif media>=5 and media<7:
    print("Aprobado")
elif media>=7 and media<9:
    print("Notable")
else:
    print("Sobresaliente")

