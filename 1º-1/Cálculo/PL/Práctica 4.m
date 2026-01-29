plot(2,3,1,'m^')
plot3([2 3 4 5], [3 0 -1 5], [1 -2 5 3], 'r*-')

%%
clear
clc
syms x y
f(x,y)=x*exp(-x^2-y^2); pretty(f)
double (f(1,2))
subplot(2,1,1)
fsurf(f,[-3 3 -2 2])
subplot(2,1,2)
fsurf(f,[-3 3 -2 2],'ShowContours','on')

%%
clear
clc
syms x y
f(x,y)=(x*y)/(x^2+y^2); pretty(f)
fsurf(f,[-2 2 -2 2])
figure(2)
fsurf(f,[-2 2 -2 2],'MeshDensity',51)

%%
clear
clc
syms x y
f(x,y)=x^2*cos(y)+x*y^2;
dxf=diff(f,x,1)
dyf=diff(f,y,1)
grad=[dxf,dyf]

gradient(f)

%%
clear
clc
syms x y
f(x,y)=atan(y/x);
E(x,y)=diff(f,x,2)+diff(f,y,2)
simplify(E)

%%
clear
clc
syms x y
f(x,y)=x^2+sin(x*y)
grad=[diff(f,x)+diff(f,y)]
double(grad(1,-2))

g=gradient(f)
double(g(1,-2))

%%
clear
clc
syms x y
f(x,y)=x^2+y^2+x*y^2;pretty(f)
fx=diff(f,x)
fy=diff(f,y)
[xs ys]=solve(fx, fy) %Puntos criticos (0,0) (-1,sqrt(2)) (-1,-squart(2))

%Una opción
fxx=diff(fx,x)
fxy=diff(fx,y)
fyy=diff(fy,y)

H=[fxx fxy;fxy fyy]

H1=H(xs(1),ys(1))
det(H1) %(0,0) min relat porque det>0, 2>0

H2=H(xs(2),ys(2))
det(H2) %(-1,squart(2)) pto de silla

H3=H(xs(3),ys(3))
det(H3) %(-1,-squart(2)) pto de silla

fsurf(f,[-3 1 -2 2])
hold on
zs=f(xs,ys);
plot3(xs,ys,zs,'g*-')

%%
clear
clc
syms n
f(n)=1/(n^2+3*n^2);
symsum(f,n,1,Inf)








