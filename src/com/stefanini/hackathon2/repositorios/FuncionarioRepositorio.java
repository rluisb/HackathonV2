package com.stefanini.hackathon2.repositorios;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.hackathon2.entidades.Funcionario;

@SuppressWarnings("all")
public class FuncionarioRepositorio extends RepositorioAbstrato<Funcionario>{
	
	@Inject
	private EntityManager entityManager;
	
	public void inserir(Funcionario funcionario) {
		entityManager.persist(funcionario);
	}

	public List<Funcionario> todasFuncionarios() {
		return entityManager.createQuery("select l from " + Funcionario.class.getSimpleName() + " l").getResultList();
	}
	
	public void remover(Funcionario funcionario) {
		entityManager.remove(entityManager.merge(funcionario));
	}

	public void removerPorId(Integer id) {
		Funcionario entity = entityManager.find(Funcionario.class, id);
		entityManager.remove(entity);	
	}

	public void atualizar(Funcionario funcionario) {
		entityManager.merge(funcionario);	
	}
	
	public Funcionario pesquisarPorID(Integer id) {
		return entityManager.find(Funcionario.class, id);
	}

}
