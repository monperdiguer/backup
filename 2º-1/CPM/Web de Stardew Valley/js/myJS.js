//ReqJ1
//Esqueleto defensivo 
//Comprobamos si en la pagina hay un formulario
const form = document.querySelector('form');
//Declaramos variables en JS:
//var -> ANTIGUA NO USAR
//let -> variable que cambia de valor
//const -> variable que no cambia de valor

if(!form){
    //Salimos
    console.log("No hay form. Salimos...")
    exit(0);
}

//Resto del codigo

// ReqJ2
function updatePreview(){
    const nombre = document.getElementById('nombre').value;
    const correo = document.getElementById('correo').value;
    const contraseña = document.getElementById('contraseña').value;
    const telefono = document.getElementById('telefono').value;

    const preview = document.getElementById('preview-content');

    //vamos a modifiacr el codigo HTML (el DOM) de la etiqueta del preview
    preview.innerHTML = ` 
        <p><strong>Nombre:</strong> ${nombre}</p>
        <p><strong>Correo:</strong> ${correo}</p>
        <p><strong>Contraseña:</strong> ${contraseña}</p>
        <p><strong>Telefono:</strong> ${telefono}</p>
        `; //Son tildes
}

// ReqJ3
function checkValidityState(field) {
    //quitar estados previos
    field.classList.remove('valid', 'invalid');

    //verificar validez HTML5 incorporada
    if(field.checkValidity()){
        field.classList.add('valid');
    } else{
        field.classList.add('invalid');
    }
}

// ReqJ4
//Funcion para validar el formulario 'a mano'
function validateForm(){
    const errorBox = document.getElementById('error-box');
    errorBox.textContent = '';
    errorBox.style.display = 'none';
    
    if(!form.reportValidity()){
        return false;
    }

    // ReqJ5
    const customError = checkCustomRules();
    if(customError){
        errorBox.textContent = customError;
        errorBox.style.display = 'block';
        return false;
    }

    return true;
}

// ReqJ5
function checkCustomRules(){
    const nombre = document.getElementById('nombre').value.toLowerCase();
    const contraseña = document.getElementById('contraseña').value.toLowerCase();

    // Ejemplo: La contraseña no puede ser igual al nombre
    if (contraseña.includes(nombre)) {
        //ReqJ6:  Gestión del foco
        document.getElementById('contraseña').focus();
        return 'Por seguridad, la contraseña no puede contener tu nombre.';
    }

    return null;
}

// ReqJ7
function handleKeyDown(event){
    //En JS las comprobaciones se hacen con == que comprueba solo el valor
    // y === comprueba valor y tipo
    if(event.key === 'Enter'){
        document.getElementById('reset-btn').classList.add('highlight');
    }
}

// ReqJ8
function handleMouseOver(element) {
    element.style.backgroundColor = '#90ee90';
}
function handleMouseOut(element) {
    element.style.backgroundColor = '';
}
