
function verificarContrasenas() {
    var contrasena = document.getElementById('formCrearUsuario').password.value;
    var rcontrasena = document.getElementById('formCrearUsuario').rpassword.value;
    console.log("test");
    if (contrasena !== rcontrasena) {
        alert('Las contraseñas no coinciden. Verifica y vuelve a intentarlo.');
        return;
    }
    document.getElementById('formCrearUsuario').submit();
}
