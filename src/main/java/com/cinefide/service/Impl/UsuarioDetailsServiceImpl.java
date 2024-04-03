package com.cinefide.service.Impl;

import com.cinefide.dao.UsuarioDao;
import com.cinefide.domain.Rol;
import com.cinefide.domain.Usuario;
import com.cinefide.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl
        implements UsuarioDetailsService, 
        UserDetailsService{

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        
        Usuario usuario = usuarioDao.findByUsername(username);
        
        if(usuario==null){
            //no encontro
            throw new UsernameNotFoundException(username);
            
        }
        //si estoy acá si encot´ro el usuario
        
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        //se recuperan los role ddel usuario y se transforman 
        //en roles de seguridad del sistema
        var roles= new ArrayList<GrantedAuthority>();
        for(Rol r : usuario.getRoles()){
            //se agregan los roles como permisos o loles reales
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
            
        }
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
    }
    
}
