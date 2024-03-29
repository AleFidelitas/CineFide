package com.cinefide.service;

import com.cinefide.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    
    //se define la firma del metodo para obtener los registros de usuario
    public List<Usuario> getUsuario(boolean activo);
    
    
    
    //trae registro por id 
    public Usuario getUsuario(Usuario usuario);

    //trae registro por username
    Usuario getByUsername(String username);
    
    //si id usuario tiene un valor, se modifica ese registro
    //si idusuario no tiene un valor se inserta un nuevo registro
    public void save(Usuario usuario);
    
    //se eimina el registro que tenga el valor del idusuario que trae
    public void delete (Usuario usuario);
    
    
}
