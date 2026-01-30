/* Fichero: expresiones.lex */
package lexico;
import java.io.InputStreamReader;
import java.lang.System;
%%
%char
%public
%standalone
%full
DIGITO = [0-9]
LETRA = [a-zA-Z]
%%
; {System.out.print(" FinSentencia");}
\+ {System.out.print(" Mas");}
\- {System.out.print(" Menos");}
\* {System.out.print(" Por");}
\/ {System.out.print(" Entre");}
\( {System.out.print(" Abre-Par");}
\) {System.out.print(" Cierra-Par");}
[\+\-]?{DIGITO} + {System.out.print(" Entero(" +yytext()+")");)
[\+\-]?{DIGITO} +\. {DIGITO}* {System.out.print(" Real(" +yytext()+")");)
[a-z](({DIGITO} | {LETRA} | _) * ({DIGITO} | {LETRA})) {System.out.print("Variable(" +yytext()+")");)

[" "\t] { }
imprime {System.out.print(" Palabra_reservada(imprime)");}
\n {System.out.print(yytext());}
. {System.out.print(" ERROR_Lexico");}