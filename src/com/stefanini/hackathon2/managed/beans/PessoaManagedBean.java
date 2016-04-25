package com.stefanini.hackathon2.managed.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.stefanini.hackathon2.entidades.Pessoa;
import com.stefanini.hackathon2.servicos.ServicoAbstrato;
import com.stefanini.hackathon2.util.Mensageiro;

@ManagedBean
@ViewScoped
public class PessoaManagedBean extends ManagedBeanAbstrato<Pessoa>{
	
	
	
	public PessoaManagedBean() {
		
	}

	public PessoaManagedBean(ServicoAbstrato<com.stefanini.hackathon2.entidades.Pessoa> servico) {
		super(servico);
	}

	private Pessoa Pessoa;
	private List<Pessoa> listaDePessoasCadastradas;
	
	public void salvar() {
		servico.salvar(getPessoa());
		Mensageiro.notificaInformacao("Parabéns!", "Pessoa salva com sucesso!");
		carregaListaDePessoas();
		limpar();
	}
	
	public void deletar(Pessoa Pessoa) {
		servico.deletar(Pessoa);
		Mensageiro.notificaInformacao("Parabéns!", "Pessoa deletada com sucesso!");
		carregaListaDePessoas();
		limpar();
	}
	
	public void limpar() {
		setPessoa(new Pessoa());
	}
	
	private void carregaListaDePessoas() {
		setListaDePessoasCadastradas(servico.carregaTodosRegistrosDoBanco());
	}
	
	public List<Pessoa> getListaDePessoasCadastradas() {
		if (listaDePessoasCadastradas == null) {
			carregaListaDePessoas();
		}
		return listaDePessoasCadastradas;
	}
	
	public void setListaDePessoasCadastradas(List<Pessoa> listaDePessoasCadastradas) {
		this.listaDePessoasCadastradas = listaDePessoasCadastradas;
	}
	
	public Pessoa getPessoa() {
		if (Pessoa == null) {
			limpar();
		}
		return Pessoa;
	}
	
	public void setPessoa(Pessoa Pessoa) {
		this.Pessoa = Pessoa;
	}
	
}
