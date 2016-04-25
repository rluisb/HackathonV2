package com.stefanini.hackathon2.servicos;

import java.util.List;

import com.stefanini.hackathon2.repositorios.RepositorioAbstrato;
import com.stefanini.hackathon2.transacao.Transacional;

public abstract class ServicoAbstrato <T>{
	
	private final RepositorioAbstrato<T> repositorio;
	private final Class<?> classeDaEntidade;
	
	public ServicoAbstrato(Class<?> classeDaEntidade, RepositorioAbstrato<T> repositorio) {
		this.classeDaEntidade = classeDaEntidade;
		this.repositorio = repositorio;
	}

	@Transacional
	public void salvar (T entidade){
		if (entidade == null) {
			repositorio.inserir(entidade);
		}else{
			repositorio.atualizar(entidade);
		}
	}
	
	@Transacional
	public List<T> carregaTodosRegistrosDoBanco() {
		return repositorio.todosRegistros(classeDaEntidade);
	}
	
	@Transacional
	public void deletar(T entidade){
		repositorio.remover(entidade);
	}
	
}
