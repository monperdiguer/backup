.386
.model flat, C

.code

; Complete the procedure

IsValidAssembly PROC

;PROLOGO
push ebp 
mov ebp,esp

;SALVAGUARDADO DE REGISTROS
push ecx
push ebx
push eax

;ACCESO A PARÁMETROS
inc ebp
inc ebp
mov     eax, [ebp]  ; a
inc ebp
mov     ebx, [ebp]  ; b
inc ebp
mov     ecx, [ebp]  ; c

;CUERPO PROCEDIMIENTO
not     eax         ; xxxx xxxx xxxx xxxx xxxx xxxx (0 o 1)xxx xxxx --> xxxx xxxx xxxx xxxx xxxx xxxx (1 o 0)xxx xxxx
and     eax, 80h    ; xxxx xxxx xxxx xxxx xxxx xxxx (1 o 0)xxx xxxx and xxxx xxxx xxxx xxxx xxxx xxxx 1xxx xxxx
shr     eax, 7      ; xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxx(resultado and)
cmp     eax, 1      ; ¿Resultado == 1? 
je      Siguiente   ; Si se cumple ir a Siguiente
xor     eax, eax    ; Si no se cumple, devolver 0 y
jmp     Acabar      ; Terminar procedimiento saltando a Acabar

Siguiente:
xor     ebx, ecx    ; b xor c
cmp     ebx, 435881	; ¿(b xor c) = 435881?
je      Consecuente	; Si se cumple ir a Consecuente
xor		eax, eax	; Si no se cumple, devolver 0 y
jmp     Acabar		; Terminar procedimiento saltando a Acabar

Consecuente:
mov     eax, 1      ; Devolver 1

Acabar:

;RESTAURACIÓN DE REGISTROS
pop     ecx
pop     ebx
pop     eax

;EPILOGO
pop     ebp							 
ret
        
IsValidAssembly ENDP
END