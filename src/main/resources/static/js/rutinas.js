
function verificarContrasenas() {
    var contrasena = document.getElementById('formCrearUsuario').contrasena.value;
    var rcontrasena = document.getElementById('formCrearUsuario').rcontrasena.value;

    if (contrasena !== rcontrasena) {
        alert('Las contraseñas no coinciden. Verifica y vuelve a intentarlo.');
        return;
    }
    document.getElementById('formCrearUsuario').submit();
}
