package com.stefanini.hackathon2.managed.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.stefanini.hackathon2.entidades.Livro;
import com.stefanini.hackathon2.servicos.ServicoAbstrato;
import com.stefanini.hackathon2.util.Mensageiro;

@ManagedBean
@ViewScoped
public class LivroManagedBean extends ManagedBeanAbstrato<Livro>{
	
	
	public LivroManagedBean() {

	}

	public LivroManagedBean(ServicoAbstrato<Livro> servico) {
		super(servico);
	}

	private Livro livro;
	private List<Livro> listaDeLivrosCadastrados;
	
	public void salvar() {
		servico.salvar(getLivro());
		Mensageiro.notificaInformacao("Parabéns!", "Livro salvo com sucesso!");
		carregaListaDeLivros();
		limpar();
	}
	
	public void deletar(Livro livro) {
		servico.deletar(livro);
		Mensageiro.notificaInformacao("Parabéns!", "Livro deletado com sucesso!");
		carregaListaDeLivros();
		limpar();
	}
	
	public void limpar() {
		setLivro(new Livro());
	}
	
	private void carregaListaDeLivros() {
		setListaDeLivrosCadastrados(servico.carregaTodosRegistrosDoBanco());
	}
	
	public List<Livro> getListaDeLivrosCadastrados() {
		if (listaDeLivrosCadastrados == null) {
			carregaListaDeLivros();
		}
		return listaDeLivrosCadastrados;
	}
	
	public void setListaDeLivrosCadastrados(List<Livro> listaDeLivrosCadastrados) {
		this.listaDeLivrosCadastrados = listaDeLivrosCadastrados;
	}
	
	public Livro getLivro() {
		if (livro == null) {
			limpar();
		}
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
}
