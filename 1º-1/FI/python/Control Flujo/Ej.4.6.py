nota1=float(input("Introduce la primera nota: "))
nota2=float(input("Introduce la segunda nota: "))
nota3=float(input("Introduce la tercera nota: "))
nota4=float(input("Introduce la cuarta nota: "))

caracter=str
media= (nota1+nota2+nota3+nota4) / 4.0
if media>=0 and media<60:
    caracter = "E"
elif media>=60 and media<70:
    caracter = "D"
elif media>=70 and media<80:
    caracter = "C"
elif media>=80 and media<90:
    caracter = "B"
elif media>=90 and media<=100:
    caracter="A"
else: print("El valor de una nota no es valido")

print("media=",media, caracter)
