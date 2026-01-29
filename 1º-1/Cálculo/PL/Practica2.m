clear
clc
syms x
limit(sin(x)/x,x,0)
limit(1/x,x,0)
limit(1/x,x,0,'left')
limit(1/x,x,0,'right')
limit(1/x,x,Inf)

f(x)=(x-2)/(x^2-4); pretty(f)
limit(f,x,2)

%%Ejemplo 1.1
clear
clc
syms x
f(x)=sin(5*x)/log(1+4*x); pretty(f)
limit(f,x,0)
f(x)=log(1+sin(4*x))/(exp(sin(5*x))-1); pretty(f)
limit(f)

%%Ejemplo 1.2
clear
clc
syms x
%Estudio continuidad en x=1
f1(x)=(2*x^2+3)/5;
lim1izq=limit(f1,x,1,'left')
f2(x)=6-5*x;
lim1dch=limit(f2,x,1,'right')
valor1=f1(1) %Cont en x=1

%Estudio continuidad en x=3
lim3izq=limit(f2,x,3,'left')
f3(x)=x-3;
lim3dch=limit(f2,x,3,'right') %No cont en x=3

%Hacer gráfica
fplot(f1,[-5 1])
hold on
fplot(f2,[1 3])
fplot(f3,[3 5])

%% Ejemplo 1.3
clear
clc
syms x
f(x)=(x^2+1)/x+abs(x)+1; pretty(f)
limit(f,x,0,'left')
limit(f,x,0,'right') %AV en x=0

limit(f,x,Inf)%No hay AH por la dch
limit(f,x,-Inf)%AH por la izq y=1

m=limit(f/x,x,Inf)
n=limit(f-m*x,x,Inf)%AO por la dch en y=2x+1

fplot(f, [-5 5])
hold on
fplot(1, [-5 0])
fplot(m*x+n,[0,5])

%% Ejercicios 2
clear
clc
syms x
1;
f(x)=(exp(-x)-1)/x; pretty(f)
limit(f)
f(x)=cos(x)^(1/sin(x)); pretty(f)
limit(f)
f(x)=((2*x+3)/(2*x+1))^(x+1)
limit(f,x,Inf)
f(x)=exp(tg(x))
limit(f,x,pi/2)

%% Derivadas
clear
clc
syms x
diff(x^2,x,1)

f(x)=1/x;
diff(f)
difff(f,2)
diff(f,3)

syms y a 
diff(cos(a*y),y)

%% Ejemplo 3.1
clear
clc
syms x
f(x)=x/(1+x^2); pretty(f)
fprima=simplify(diff(f)); pretty(fprima)
fsegunda=simplify(diff(f,2)); pretty(fsegunda)

fplot(f, [-3 3])
hold on
fplot(fprima, [-3 3])
fplot(fsegunda, [-3 3])
legend('f','f´','f´´')

solve(fprima) %Candidatos a extrem abs -1 y 1, ademas de -3 3 por ser extremos del intervalo
double(f([-3 -1 1 3]))%MAX abs 1 y MIN abs -1
figure(2)
fplot(f, [-3 3])
hold on
plot(1,f(1),'r*')
plot(-1,f(-1),'go')

%% Ejercicio 3.2
clear
clc
syms x
f(x)=(x^2-4*x+4)/x^3; pretty(f)%Disc en x=0
solve(f) %Corta al eje X en el punto (2,0)
limit(f,x,0,'left')
limit(f,x,0,'right') %AV en x=0

limit(f,x,Inf)
limit(f,x,-Inf)%AH en y=0

fprima=simplify(diff(f)); pretty(fprima) %Candidato 0
solve(fprima) %Candidatos 2 y 6
fprima([-1 1 2 3 6 7]) %MAX relativo 6 y MIN relativo 2
fsegunda=simplify(diff(f,2)); pretty(fsegunda) %Candidato 0
double(solve(fsegunda)) %Candidato 2.5359, 9.4641
fsegunda([-1 2 3 10])
fplot(f,[-100 100])

%% Polinomios de Taylor
clear
clc
syms x
f(x)=exp(x)
taylor(f,x,2,'Order',4)

%% Ejercicio MacLauding

clear
clc
syms x
f(x)=sin(x)
m1=taylor(f,'Order',2)
m3=taylor(f,'Order',4)
m5=taylor(f,'Order',6)
m7=taylor(f,'Order',8)

fplot(f, [-pi pi])
hold on
fplot(m1, [-pi pi])
fplot(m3, [-pi pi])
fplot(m5, [-pi pi])
fplot(m7, [-pi pi])
legend('y=sen(x)', 'Polinomio de MacLaurin de grado 1', 'Polinomio de MacLaurin de grado 3', 'Polinomio de MacLaurin de grado 5', 'Polinomio de MacLaurin de grado 7')

%%