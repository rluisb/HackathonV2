package com.stefanini.hackathon2.servicos;


import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Usuario;
import com.stefanini.hackathon2.repositorios.UsuarioRepositorio;

public class UsuarioServico extends ServicoAbstrato<Usuario>{
	
	@Inject
	public UsuarioServico(UsuarioRepositorio repositorio) {
		super(Usuario.class, repositorio);
	}
	
}
