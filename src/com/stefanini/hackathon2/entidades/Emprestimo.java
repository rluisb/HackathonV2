package com.stefanini.hackathon2.entidades;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.stefanini.hackathon2.util.LocalDatePersistenceConverter;

@Entity
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idPessoa", nullable=true)
	private Pessoa pessoa;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idFuncionario", nullable=true)
	private Funcionario funcionario;
	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idLivro", nullable = false)
	private List<Livro> livros;
	@Column(nullable=true)
	@Convert(converter = LocalDatePersistenceConverter.class)
	private LocalDate retirada;
	@Convert(converter = LocalDatePersistenceConverter.class)
	@Column(nullable=true)
	private LocalDate devolucao;
	@Column(nullable=true)
	private String status;
	
	
	public Emprestimo() {
		this.retirada = LocalDate.now();
		this.status = "Sem Status";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public LocalDate getRetirada() {
		return retirada;
	}

	public void setRetirada(LocalDate retirada) {
		this.retirada = retirada;
	}

	public LocalDate getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(LocalDate devolucao) {
		this.devolucao = devolucao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((devolucao == null) ? 0 : devolucao.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((livros == null) ? 0 : livros.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((retirada == null) ? 0 : retirada.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (devolucao == null) {
			if (other.devolucao != null)
				return false;
		} else if (!devolucao.equals(other.devolucao))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (livros == null) {
			if (other.livros != null)
				return false;
		} else if (!livros.equals(other.livros))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (retirada == null) {
			if (other.retirada != null)
				return false;
		} else if (!retirada.equals(other.retirada))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", pessoa=" + pessoa + ", funcionario=" + funcionario + ", livro=" + livros
				+ ", retirada=" + retirada + ", devolucao=" + devolucao + ", status=" + status + "]";
	}
	
	
	
}
