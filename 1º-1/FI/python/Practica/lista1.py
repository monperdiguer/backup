def posicion_maximo(lista):
    if len(lista)==0:
        return None
    posicion=0
    maximo=lista[0]
    for i in range(0,len(lista)):
        if(maximo<lista[i]):
            posicion=i
            maximo=lista[i]
    return posicion+1
lista=[1,2,7,1,3]
print("el valor maximo de la lista es",max(lista),"y está en la posicion",posicion_maximo(lista))