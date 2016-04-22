package com.stefanini.hackathon2.servicos;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Funcionario;
import com.stefanini.hackathon2.repositorios.FuncionarioRepositorio;
import com.stefanini.hackathon2.transacao.Transacional;

public class FuncionarioServico {
	
	@Inject
	private FuncionarioRepositorio repositorio;
	
	@Transacional
	public void salvar(Funcionario funcionario) {
		if (funcionario.getId() == null) {
			repositorio.inserir(funcionario);
		} else {
			repositorio.atualizar(funcionario);
		}
	}

	@Transacional
	public List<Funcionario> carregaTodasFuncionariosDoBanco() {
		return repositorio.todasFuncionarios();
	}

	@Transacional
	public void deletar(Funcionario funcionario) {
		repositorio.remover(funcionario);;
	}

}
