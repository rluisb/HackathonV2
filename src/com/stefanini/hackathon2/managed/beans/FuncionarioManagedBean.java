package com.stefanini.hackathon2.managed.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.stefanini.hackathon2.entidades.Funcionario;
import com.stefanini.hackathon2.servicos.ServicoAbstrato;
import com.stefanini.hackathon2.util.Mensageiro;

@ManagedBean
@ViewScoped
public class FuncionarioManagedBean extends ManagedBeanAbstrato<Funcionario>{
	
	public FuncionarioManagedBean() {
	}

	public FuncionarioManagedBean(ServicoAbstrato<com.stefanini.hackathon2.entidades.Funcionario> servico) {
		super(servico);
	}
	
	private Funcionario Funcionario;
	private List<Funcionario> listaDeFuncionariosCadastradas;
	
	public void salvar() {
		servico.salvar(getFuncionario());
		Mensageiro.notificaInformacao("Parabéns!", "Funcionario salva com sucesso!");
		carregaListaDeFuncionarios();
		limpar();
	}
	
	public void deletar(Funcionario Funcionario) {
		servico.deletar(Funcionario);
		Mensageiro.notificaInformacao("Parabéns!", "Funcionario deletada com sucesso!");
		carregaListaDeFuncionarios();
		limpar();
	}
	
	public void limpar() {
		setFuncionario(new Funcionario());
	}
	
	private void carregaListaDeFuncionarios() {
		setListaDeFuncionariosCadastradas(servico.carregaTodosRegistrosDoBanco());
	}
	
	public List<Funcionario> getListaDeFuncionariosCadastradas() {
		if (listaDeFuncionariosCadastradas == null) {
			carregaListaDeFuncionarios();
		}
		return listaDeFuncionariosCadastradas;
	}
	
	public void setListaDeFuncionariosCadastradas(List<Funcionario> listaDeFuncionariosCadastradas) {
		this.listaDeFuncionariosCadastradas = listaDeFuncionariosCadastradas;
	}
	
	public Funcionario getFuncionario() {
		if (Funcionario == null) {
			limpar();
		}
		return Funcionario;
	}
	
	public void setFuncionario(Funcionario Funcionario) {
		this.Funcionario = Funcionario;
	}
	
}
