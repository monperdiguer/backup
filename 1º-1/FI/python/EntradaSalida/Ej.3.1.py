nombre = input("Introduce el nombre del alumno: ")
nota1 = float(input("Introduce la nota 1 de " + nombre + ": "))
nota2 = float(input("Introduce la nota 2: "))

media= (nota1+nota2) / 2
aprobado= media>=5
print("La nota media de",nombre,"es",media)
print("Aprueba la asignatura:",aprobado)