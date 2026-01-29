caracter=input("Introduce un carácter: ")
contador=0
while caracter != ".":
    if caracter == "a" or caracter == "Aj":
        contador= contador+1
    caracter = input("Introduce un carácter: ")
print("has introducido", contador, "a's")
