% Área para rellenar el nombre y apellidos
% Por ejemplo:
% Nombre = 'Jorge Jiménez Meana';
Nombre = 'Mónica Perdiguer Caso';

disp(['Practica entregada por ',Nombre]);
%% Ejercicio 1
disp('%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%');
disp('%%%%%%%%%%%%%%%%%%%    Solución del Ejercicio 1    %%%%%%%%%%%%%%%%%%%%%');
disp('%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%');
% Introduce aquí las instrucciones para obtener la solución del Ejercicio 1
clear; % 
A=33*(1:190);
B=39*(1:190);
C=429*(1:190);

%Unión de A y B
Union_AB = union(A,B);
D=intersect(Union_AB,C);

%Sumar todos los elementos del conjunto D
s=sum(D);
disp(s);

disp('%%%%%%%%%%%%%%%%%%%%%    Fin del Ejercicio 1    %%%%%%%%%%%%%%%%%%%%%%');
%% Ejercicio 2
disp('%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%');
disp('%%%%%%%%%%%%%%%%%%%    Solución del Ejercicio 2    %%%%%%%%%%%%%%%%%%%%%');
disp('%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%');
% Introduce aquí las instrucciones para obtener la solución del Ejercicio 2
clear; %
A=69*(1:394);
B=93*(1:394);
C=69*(1:197);
D=93*(1:197);

%Intersección AB
Inter_AB=intersect(A,B);

%Union CD
Union_CD=union(C,D);

E=setdiff(Inter_AB,Union_CD);
s=sum(E);

%Numero de elementos de E
n=length(E);
disp(s+n);

disp('%%%%%%%%%%%%%%%%%%%%%    Fin del Ejercicio 2    %%%%%%%%%%%%%%%%%%%%%%');
%% Ejercicio 3
disp('%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%');
disp('%%%%%%%%%%%%%%%%%%%    Solución del Ejercicio 3    %%%%%%%%%%%%%%%%%%%%%');
disp('%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%');
% Introduce aquí las instrucciones para obtener la solución del Ejercicio 3
clear; % 
z=-2.82-4.6231*i;
w=2.856-8.1231*i;

%Hallar el argumento
az=angle(z);
if az<0
    az=az+2*pi;
end

u=conj(z)*w;
%Parte real de u
rzw=real(u);
%Parte imaginaria de u
izw=imag(u);

disp(az);
disp(rzw);
disp(izw);

disp('%%%%%%%%%%%%%%%%%%%%%    Fin del Ejercicio 3    %%%%%%%%%%%%%%%%%%%%%%');
%% Ejercicio 4
disp('%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%');
disp('%%%%%%%%%%%%%%%%%%%    Solución del Ejercicio 4    %%%%%%%%%%%%%%%%%%%%%');
disp('%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%');
% Introduce aquí las instrucciones para obtener la solución del Ejercicio 4
clear; % 
z1=1.1367*exp((pi/4)*i);
z2=3.4022*exp(4+(pi/4)*i);

w=3.745*z1*z2^2*(conj(z1)/(1010*z2+1*i));
parte_real=real(w)
parte_imaginaria=imag(w)

%Calcular el modulo
modulo=abs(w)

%Argumento principal de w
argumento=angle(w)


disp('%%%%%%%%%%%%%%%%%%%%%    Fin del Ejercicio 4    %%%%%%%%%%%%%%%%%%%%%%');
%% Ejercicio 5
disp('%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%');
disp('%%%%%%%%%%%%%%%%%%%    Solución del Ejercicio 5    %%%%%%%%%%%%%%%%%%%%%');
disp('%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%');
% Introduce aquí las instrucciones para obtener la solución del Ejercicio 5
clear; % 
z=-2.208-1.3693*i;

r=zeros(1,4);

for k=0:3
    r(k+1)=nthroot(abs(z),4)*exp(((angle(z)+2*k*pi)/4)*i)
end

figure;
plot(real(r), imag(r), 'o');
hold on;
plot(real(z), imag(z), 'rx', 'MarkerSize', 10); % Marcar el número original z
xlabel('Parte real');
ylabel('Parte imaginaria');
title('Raíces quíntas de z');
grid on;
axis equal;
hold off;
disp('%%%%%%%%%%%%%%%%%%%%%    Fin del Ejercicio 5    %%%%%%%%%%%%%%%%%%%%%%');
