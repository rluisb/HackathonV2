package com.stefanini.hackathon2.servicos;


import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Pessoa;
import com.stefanini.hackathon2.repositorios.PessoaRepositorio;

public class PessoaServico extends ServicoAbstrato<Pessoa>{
	
	@Inject
	public PessoaServico(PessoaRepositorio repositorio) {
		super(Pessoa.class, repositorio);
	}
	
}
