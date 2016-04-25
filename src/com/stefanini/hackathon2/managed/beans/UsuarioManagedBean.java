package com.stefanini.hackathon2.managed.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.stefanini.hackathon2.entidades.Usuario;
import com.stefanini.hackathon2.servicos.ServicoAbstrato;
import com.stefanini.hackathon2.util.Mensageiro;

@ManagedBean
@ViewScoped
public class UsuarioManagedBean extends ManagedBeanAbstrato<Usuario>{
	
	public UsuarioManagedBean() {

	}

	public UsuarioManagedBean(ServicoAbstrato<com.stefanini.hackathon2.entidades.Usuario> servico) {
		super(servico);
	}
	
	private Usuario Usuario;
	private List<Usuario> listaDeUsuariosCadastradas;
	
	
	public void salvar() {
		servico.salvar(getUsuario());
		Mensageiro.notificaInformacao("Parabéns!", "Usuario salvo com sucesso!");
		carregaListaDeUsuarios();
		limpar();
	}
	
	public void deletar(Usuario Usuario) {
		servico.deletar(Usuario);
		Mensageiro.notificaInformacao("Parabéns!", "Usuario deletado com sucesso!");
		carregaListaDeUsuarios();
		limpar();
	}
	
	public void limpar() {
		setUsuario(new Usuario());
	}
	
	private void carregaListaDeUsuarios() {
		setListaDeUsuariosCadastradas(servico.carregaTodosRegistrosDoBanco());
	}
	
	public List<Usuario> getListaDeUsuariosCadastradas() {
		if (listaDeUsuariosCadastradas == null) {
			carregaListaDeUsuarios();
		}
		return listaDeUsuariosCadastradas;
	}
	
	public void setListaDeUsuariosCadastradas(List<Usuario> listaDeUsuariosCadastradas) {
		this.listaDeUsuariosCadastradas = listaDeUsuariosCadastradas;
	}
	
	public Usuario getUsuario() {
		if (Usuario == null) {
			limpar();
		}
		return Usuario;
	}
	
	public void setUsuario(Usuario Usuario) {
		this.Usuario = Usuario;
	}
	
}
