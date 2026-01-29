clear
clc
syms x y
int(x*exp(x),x,0,1)

int(cos(x*y),y)

syms a b
int(cos(x),a,b)

int(1/x^2,1,Inf)

%%
clear
clc
syms x
f(x)=2*x^3;
g(x)=8*x;
solve(f-g) %Corte -2 0 2

area1=int(abs(f-g),-2,2) %Opcion 1

fplot(f,[-2,2])
hold on
fplot(g,[-2,2])
legend ('f','g')

a1=int(f-g,-2,0)
a2=int(g-f,0,2)
area2=a1+a2 %Opcion 2

%%
clear
clc
syms x
f(x)=(x^2-1)/(x^2+1);

limit(f,x,Inf)
limit(f,x,-Inf) %AH en y=1

solve(f-1) % NO HAY puntos de corte con la AH
int(1-f,-Inf,Inf)

fplot(f,[-100,100])
hold on
fplot(1,[-100,100])

%%
clear
clc
close all
syms x
f(x)=(-x^2+x+3)*log(x)
sol=double(solve(f)) %Descartamos la parte negativa

double(int(f,sol(1),sol(3)))

%%
clear
clc
syms x
f(x)=exp(-x^2);
double(solve(f))
valor=double(int(f,0,1))

m2=taylor(f,'Order',3)
double(int(m2,0,1))
m4=taylor(f,'Order',5)
double(int(m4,0,1))
m6=taylor(f,'Order',7)
double(int(m6,0,1))
m10=taylor(f,'Order',11)
double(int(m10,0,1))
m12=taylor(f,'Order',13)
double(int(m12,0,1))

%%
clear
clc
syms x
f(x)=sin(x);
valor=int(abs(sin(x)),-pi,pi)

xd=linspace(-pi,pi,50);
yd=f(xd);

area(xd,yd,'FaceColor','y')
title('Área calculada f(x)=sen(x) entre -pi y pi')
legend('Área')

%%
%Ejercicio 1
clear
clc
syms x
fa(x)=(1/(1+exp(x)));
int(fa(x))

fb(x)=(1/(x^2+x+1));
int(fb(x))

%%
% Ejercicio2
clear
clc
syms x
fa(x)=(1/(x^2-1));
int(fa(x),2,Inf)

fb(x)=(1/(x*log(x)^2));
double(int(fb(x),x,exp(1),Inf))

fc(x)=(x*exp(x));
int(fc(x),-Inf,0)

%%
%Ejercicio 3
clear
clc
syms x
f(x)=((x+1)/(x^2+x+1));

limit(f(x),x,Inf);
limit(f(x),x,-Inf); %AH en y=0

solve(f) % Puntos de corte con la AH y=1
double(int(f(x),0,1))

xd=linspace(0,1,50);
yd=f(xd);

area(xd,yd)
title('Área calculada f(x)=((x+1)/(x^2+x+1)) entre 0 y 1')
legend('Área')

