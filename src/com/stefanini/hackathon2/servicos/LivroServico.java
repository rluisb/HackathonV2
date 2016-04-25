package com.stefanini.hackathon2.servicos;

import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Livro;
import com.stefanini.hackathon2.repositorios.LivroRepositorio;

public class LivroServico extends ServicoAbstrato<Livro>{

	@Inject
	public LivroServico(LivroRepositorio repositorio) {
		super(Livro.class, repositorio);
	}
	
}
