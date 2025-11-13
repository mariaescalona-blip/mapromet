package net.javaguides.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.javaguides.springboot.model.Usuario;
import net.javaguides.springboot.web.dto.UserRegistrationDto;

public interface UsuarioService extends UserDetailsService{
	Usuario save(UserRegistrationDto registrationDto);
}
