
const maxLongitudes = {
    'nombreCompleto': 45,
    'email': 45,
    'telefono': 9,
    'psw': 20,
    'usuario': 20,
    'modelo': 20,
    'matricula': 7,
    'color': 20,
    'nombreDpt': 45,
    'puesto': 30,
    'departamento': 30,
}

var wwidth = window.innerWidth;
var wheight = window.innerHeight;

window.addEventListener('resize', ()=>{
    wwidth = window.innerWidth;
    wheight = window.innerHeight;
});

function eliminarEspacios (texto) {
    return texto.replace(/ /g, "");
}

function actualizarAtaquesLog (texto) {
    let xhttp = new XMLHttpRequest();
    xhttp.open("POST", "Requests", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("nuevoAtaque=" + texto);
    
}

// Global: funcion que comprueba que el dato introducido no es un intento de inyeccion SQL
function comprobarInyeccionSQL (texto) {
    let positivo = false;
    if (texto != undefined) {
        if (texto.includes("select " || texto.includes(" from") || texto.includes("SELECT ") || texto.includes(" FROM"))) {
            document.getElementsByTagName('body')[0].innerHTML = "<p>You tried to SQL inyection this site. You have no longer access to this session</p>";
            positivo = true;
            actualizarAtaquesLog("ISQL");
        }
    }
    return positivo;
}

// Global: funcion que comprueba que el dato introducido no es un intento de ataque XSS
function comprobarXSS (texto) {
    let positivo = false;
    if (texto != undefined) {
        if (texto.includes("<script>") || texto.includes("<SCRIPT>")) {
            document.getElementsByTagName('body')[0].innerHTML = "<p>You tried to XSS this site. You have no longer access to this session</p>";
            positivo = true;
            actualizarAtaquesLog("XSS");
        }
    }
    return positivo;
}

// Global: funcion de resumen para llamar a las diferentes funciones de seguridad
function comprobarSeguridadDatosForm (texto) {
    console.log('comprobando la seguridad de ' + texto);
    let positivoXSS = comprobarXSS(texto);
    let positivoISQL = comprobarInyeccionSQL(texto);
    return positivoXSS || positivoISQL;
}

function comprobarLongitudMaximaEntrada (texto, maxLength) {
    let excedeLimite = false;
    if (texto != undefined) {
        if (texto.length > maxLength) {
            excedeLimite = true;
        }
    }
    return excedeLimite;
}

function comprobarLongitudMinimaEntrada (texto, minLength) {
    let menorALimite = false;
    if (texto != undefined) {
        if (texto.length < minLength) {
            menorALimite = true;
        }
    }
    return menorALimite;
}

function comprobarLongitudDatosForm(texto) {
    let positivo = comprobarLongitudMaximaEntrada(texto, 45);
    let positivo2 = comprobarLongitudMinimaEntrada(texto, 6);
    // Eliminar esta línea si se desea recuperar la longitud minima
    positivo2 = false;
    return positivo || positivo2;
}

function comprobarEmail (email) {
    let isFalse = false;
    let emailRegex = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
    if (!emailRegex.test(email)) {
        isFalse = true;
    }
    return isFalse;
}

function comprobarTelefono (telefono) {
    let isFalse = false;
    telefono = eliminarEspacios(telefono);
    let tlfnoRegex = "^(\\+34|0034|34)?[6789]\\d{8}$";
    if (!tlfnoRegex.test(telefono)) {
        isFalse = true;
    }
    return isFalse;
}

// En registroCliente: Recupera los datos del formulario de registro de un cliente
function recuperarDatosFormRegCli () {
    let usuario = document.getElementById('reg-usuario');
    let nombre = document.getElementById('reg-nombre');
    let tlfn = document.getElementById('reg-telefono');
    let email = document.getElementById('reg-email');
    let psw = document.getElementById('reg-psw');
    let reppsw = document.getElementById('reg-rep-psw');
    let terminos = document.getElementById('TerminosYCondiciones');
    let privacidad = document.getElementById('PrivacidadYCookies');
    let entidades = [usuario, nombre, tlfn, email, psw, reppsw]
    let positivo = false;
    let camposLlenos = false;
    let longitudes = false;

    if (psw.value === reppsw.value && terminos.checked && privacidad.checked) {

        if (eliminarEspacios(tlfn.value).length != 9) {
            tlfn.style.border = "1px solid red";
            tlfn.style.borderRadius = "2px";
            longitudes = true;
            console.log('el numero es incorrecto')
        }

        if (comprobarEmail(email.value)) {
            email.style.border = "1px solid red";
            email.style.borderRadius = "2px";
            longitudes = true;
            console.log('el email es incorrecto')
        }

        for (let i = 0; i < entidades.length; i++) {
            if(comprobarLongitudDatosForm(entidades[i].value)) {
                entidades[i].style.border = "1px solid red";
                entidades[i].style.borderRadius = "2px";
                longitudes = true;
            }
            if (entidades[i].value!="") {
                positivo = positivo || comprobarSeguridadDatosForm(entidades[i].value);
                camposLlenos = camposLlenos || false;
            } else {
                camposLlenos = camposLlenos || true;
                entidades[i].style.border = "1px solid red";
                entidades[i].style.borderRadius = "2px";
            }
        }
        if (!positivo && !camposLlenos && !longitudes) {
            console.log('enviando')
            let xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    if (this.responseText == "./cuenta.html") {
                        window.location.href = this.responseText;
                    }
                    if (this.responseText == "./registroCliente.html") {
                        window.location.href = this.responseText;
                    }
                    document.getElementById("regCli").innerHTML = this.responseText;
                }
            };
            xhttp.open("POST", "Requests", true);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send(
                "reg-usuario=" + usuario.value + 
                "&reg-nombre=" + nombre.value +
                "&reg-telefono=" + tlfn.value +
                "&reg-email=" + email.value +
                "&reg-psw=" + psw.value +
                "&reg-rep-psw=" + reppsw.value
                );
        }
    } else {
        console.log('error de registro')
    }
}

// En registroEmpleado: funcion que recupera los datos del formulario de registro de un nuevo empleado
function recuperarDatosFormRegEmp () {
    let usuario = document.getElementById('reg-usuario-emp');
    let nombre = document.getElementById('reg-nombre-emp');
    let tlfn = document.getElementById('reg-telefono-emp');
    let email = document.getElementById('reg-email-emp');
    let dpt = document.getElementById('reg-dpt-emp');
    let puesto = document.getElementById('reg-puesto-emp');
    let sueldo = document.getElementById('reg-sueldo-emp');
    let psw = document.getElementById('reg-psw-emp');
    let reppsw = document.getElementById('reg-rep-psw-emp');
    let entidades = [usuario, nombre, tlfn, email, dpt, puesto, sueldo, psw, reppsw]
    let positivo = false;
    let camposLlenos = false;
    let longitudes = false;


    if (psw.value === reppsw.value) {
        
        if (eliminarEspacios(tlfn.value).length != 9) {
            tlfn.style.border = "1px solid red";
            tlfn.style.borderRadius = "2px";
            longitudes = true;
        }

        if (comprobarEmail(email.value)) {
            email.style.border = "1px solid red";
            email.style.borderRadius = "2px";
            longitudes = true;
        }

        for (let i = 0; i < entidades.length; i++) {
            if(comprobarLongitudDatosForm(entidades[i].value)) {
                entidades[i].style.border = "1px solid red";
                entidades[i].style.borderRadius = "2px";
                longitudes = true;
            }
            if (entidades[i].value!="") {
                positivo = positivo || comprobarSeguridadDatosForm(entidades[i].value);
                camposLlenos = camposLlenos || false;
            } else {
                camposLlenos = camposLlenos || true;
                entidades[i].style.border = "1px solid red";
                entidades[i].style.borderRadius = "2px";
            }
        }
        
        if (!positivo && !camposLlenos && !longitudes) {
            let xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    if (this.responseText == "./fichaEmpleado.html") {
                        window.location.href = this.responseText;
                    } else if (this.responseText == "./registroEmpleado.html") {
                        window.location.href = this.responseText;
                    } else {
                        document.getElementById("regEmp").innerHTML = this.responseText;
                    }
                }
            };
            xhttp.open("POST", "Requests", true);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("reg-usuario-emp=" + usuario.value 
            + "&reg-nombre-emp=" + nombre.value
            + "&reg-telefono-emp=" + tlfn.value
            + "&reg-email-emp=" + email.value
            + "&reg-dpt-emp=" + dpt.value
            + "&reg-puesto-emp=" + puesto.value
            + "&reg-sueldo-emp=" + sueldo.value
            + "&reg-psw-emp=" + psw.value
            + "&reg-rep-psw-emp=" + reppsw.value
            );
        } else {
            console.log('error inicio de sesión')
        }
    } else {
        console.log('error de registro')
    }
}

function recuperarDatosInicioSesion () {
    let usuarioIni = document.getElementById("inicio-sesion-usuario");
    let pswIni = document.getElementById("inicio-sesion-password");
    let positivo = false;

    positivo = comprobarSeguridadDatosForm(usuarioIni.value) || comprobarSeguridadDatosForm(pswIni.value);
    if (!positivo) {
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                try {
                    window.location.href = this.responseText;
                } catch (error) {
                    console.log("Error inicio sesion: " + error);
                }
            }
        };
        xhttp.open("POST", "Requests", true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("inicio-sesion-usuario=" + usuarioIni.value + "&inicio-sesion-password=" + pswIni.value);
    } else {
        console.log('error inicio de sesión')
    }
}

function pedirCita () {
    console.log("pidiendo cita")
    let cita = document.getElementById("cuenta-calendario-cita");
    let xhttp = new XMLHttpRequest();
    xhttp.open("POST", "Requests", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("nuevaCita=" + cita.value);
}

function aceptarCookiesEnBack () {
    document.getElementById("cookies").style.display = "none";
    let xhttp = new XMLHttpRequest();
    xhttp.open("POST", "Requests", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("aceptarCookies=" + true);
    
}

function checkCookiesAceptadas () {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            if (this.responseText=="true") {
                document.getElementById("cookies").style.display = "none";
            }
        }
    };
    xhttp.open("POST", "Requests", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("isCookiesAceptadas=" + true);
}







// STYLES 


// index
// imgbackgrounds
let indImgBlocks = document.getElementsByClassName('ind-img-block');

let observerIIB = new IntersectionObserver(([entry])=>{
    if (entry.isIntersecting) {
        entry.target.style.animation = "extendHeight .7s cubic-bezier(.74, .06, .4, .92) forwards";
        entry.target.style.height = Math.min(wwidth*0.2, wheight*0.2); 
    }
}, {
    threshold: 0.3
});

for (let i = 0; i < indImgBlocks.length; i++) {
    observerIIB.observe(indImgBlocks[i]);
}

// imgs
let indImgs = document.getElementsByClassName('ind-imgs');

let observerII = new IntersectionObserver(([entry])=>{
    if (entry.isIntersecting) {
        entry.target.style.animation = "opacityReveal 1s .7s cubic-bezier(.74, .06, .4, .92) forwards";
    }
}, {
    threshold: 0.3
});

for (let i = 0; i < indImgs.length; i++) {
    observerII.observe(indImgs[i]);
}


