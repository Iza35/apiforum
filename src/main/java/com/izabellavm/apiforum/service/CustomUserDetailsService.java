package com.izabellavm.apiforum.service;

import com.izabellavm.apiforum.model.Usuario;
import com.izabellavm.apiforum.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado " + username);
        }
        return org.springframework.security.core.userdetails.User
            .withUsername(usuario.getUsername())
            .password(usuario.getPassword())
            .roles("USER")
            .build();
    }
}
