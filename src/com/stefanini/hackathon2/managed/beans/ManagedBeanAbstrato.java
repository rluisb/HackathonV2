package com.stefanini.hackathon2.managed.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.stefanini.hackathon2.entidades.Pessoa;
import com.stefanini.hackathon2.servicos.ServicoAbstrato;
import com.stefanini.hackathon2.util.Mensageiro;

@ManagedBean
@ViewScoped
public class ManagedBeanAbstrato <T> {

	protected ServicoAbstrato<T> servico;
	private List<T> listaDeDados;
	
	public ManagedBeanAbstrato(ServicoAbstrato<T> servico) {
		this.servico = servico;
	}
	
	public ManagedBeanAbstrato(){
		
	}
	
	public void salvar() {
		Mensageiro.notificaInformacao("Parabéns!", "Emprestimo salvo com sucesso!");
	}
	
	public void deletar(T entidade) {
		servico.deletar(entidade);
		Mensageiro.notificaInformacao("Parabéns!", "Emprestimo deletado com sucesso!");
	}
	
	private void carregaListaDeDados() {
		setListaDeDados(servico.carregaTodosRegistrosDoBanco());
	}
	
	public void setListaDeDados(List<T> listaDeDados) {
		this.listaDeDados = listaDeDados;
	}
	
	public List<T> getListaDeDados() {
		if (listaDeDados == null) {
			carregaListaDeDados();
		}
		return listaDeDados;
	}
	
}
