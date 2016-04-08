package com.stefanini.hackathon2.managed.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Pessoa;
import com.stefanini.hackathon2.servicos.PessoaServico;
import com.stefanini.hackathon2.util.Mensageiro;

@ManagedBean
@ViewScoped
public class PessoaManagedBean {

	private Pessoa Pessoa;
	private List<Pessoa> listaDePessoasCadastrados;
	
	@Inject
	private PessoaServico servico;
	
	public PessoaManagedBean() {
	}
	
	public void salvar() {
		servico.salvar(getPessoa());
		Mensageiro.notificaInformacao("Parab�ns!", "Pessoa salva com sucesso!");
		carregaListaDePessoas();
		limpar();
	}
	
	public void deletar(Pessoa Pessoa) {
		servico.deletar(Pessoa);
		Mensageiro.notificaInformacao("Parab�ns!", "Pessoa deletada com sucesso!");
		carregaListaDePessoas();
		limpar();
	}
	
	public void limpar() {
		setPessoa(new Pessoa());
	}
	
	private void carregaListaDePessoas() {
		setListaDePessoasCadastrados(servico.carregaTodasPessoasDoBanco());
	}
	
	public List<Pessoa> getListaDePessoasCadastrados() {
		if (listaDePessoasCadastrados == null) {
			carregaListaDePessoas();
		}
		return listaDePessoasCadastrados;
	}
	
	public void setListaDePessoasCadastrados(List<Pessoa> listaDePessoasCadastrados) {
		this.listaDePessoasCadastrados = listaDePessoasCadastrados;
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
