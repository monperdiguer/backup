%Ejemplo 6.1
%Ejercicio 1
clear
clc
syms x
p(x)=x^3+3*x^2-4
solve(p)

%%
%ejercicio 7
clear
clc
syms x
format short
10000/(400+6*500)
format shortG
x=nthroot(270,3)*(690+876)

%%
clear
clc
syms x
f(x)=x^2/(6*x+x^3)
pretty(f)
format short
a= double(f(1))
b= double(f(-0.5))

%%
syms x
f(x)=x^3-3*x+2
solve(f)

%%
clear
clc
syms x
f(x)=x*sin(x);
g(x)=x^2-1;
h(x)=exp(x+3);
h(g(f(x)))
h(finverse(h))

%%



