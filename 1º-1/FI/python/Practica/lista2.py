def pon_ceros(lista):
    if len(lista)==0:
        return None
    cambios=0
    for i in range(0,len(lista)):
        if lista[i]<0:
            lista[i]=0
            cambios+=1
    return cambios
lista=[3,-4,5,7,-1,8]
print(pon_ceros(lista))
print(lista)
