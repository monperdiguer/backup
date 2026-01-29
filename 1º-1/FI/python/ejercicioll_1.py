def contiene(lista, valor):
    for i in range(len(lista)):
        #si el valor es igual al que aparece en la lista true, si no false
        if valor == lista[i]:
            return True
    else:
        return False

def lista_sin_repetidos(lista):
    for i in range(len(lista)):
        #si la lista tiene ese valor lo eliminamos
        if contiene(lista, lista[i]):
            lista.remove(valor)
    return lista

lista =[1 ,2 ,1 ,1 ,3 ,2 ,1 ,1 ,3 ,4]
valor = int(input("Introduzca un valor que pueda contener la lista: "))
print("¿Está", valor, "en la lista?", contiene(lista, valor))
print("La lista resultante es: ", lista_sin_repetidos(lista))