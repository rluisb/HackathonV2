package com.stefanini.hackathon2.repositorios;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.hackathon2.entidades.Emprestimo;
import com.stefanini.hackathon2.entidades.Pessoa;

@SuppressWarnings("all")
public abstract class RepositorioAbstrato<T> {
	
	@Inject
	private EntityManager entityManager;
	
	public void inserir(T entidade) {
		entityManager.persist(entidade);
	}
	
	public void remover(T entidade) {
		entityManager.remove(entityManager.merge(entidade));
	}

	public void atualizar(T entidade) {
		entityManager.merge(entidade);	
	}

	public List<T> todosRegistros(Class<?> classeDaEntidade) {
		return entityManager.createQuery("select l from " + classeDaEntidade.getSimpleName() + " l").getResultList();
	}
	
	
}
