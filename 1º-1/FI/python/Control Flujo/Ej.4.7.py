anyo=int(input("Introduce el año: "))
if anyo%4==0:
    if anyo%100==0 and anyo%400!=0:
     print("El año", anyo," NO es bisiesto")
    else: print("El año",anyo,"es bisiesto")
else: print("El año",anyo,"NO es bisiesto")



