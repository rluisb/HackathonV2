package com.stefanini.hackathon2.servicos;


import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Funcionario;
import com.stefanini.hackathon2.repositorios.FuncionarioRepositorio;

public class FuncionarioServico extends ServicoAbstrato<Funcionario>{
	
	@Inject
	public FuncionarioServico(FuncionarioRepositorio repositorio) {
		super(Funcionario.class, repositorio);
	}

}
