package com.stefanini.hackathon2.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idLivro;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String autor;
	@Column(nullable=false)
	private Integer paginas;
	@Column(nullable=false)
	private Integer qtdeEstoque;
	@Column(nullable=true)
	private Integer qtdeEmprestado;
	@Column(nullable=true)
	private String status;
	
	
	public Livro() {
		this.status = "Disponivel";
	}


	public Integer getId() {
		return idLivro;
	}


	public void setId(Integer id_livro) {
		this.idLivro = id_livro;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public Integer getPaginas() {
		return paginas;
	}


	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}


	public Integer getQtdeEstoque() {
		return qtdeEstoque;
	}


	public void setQtdeEstoque(Integer qtde_estoque) {
		this.qtdeEstoque = qtde_estoque;
	}


	public Integer getQtdeEmprestado() {
		return qtdeEmprestado;
	}


	public void setQtdeEmprestado(Integer qtde_emprestado) {
		this.qtdeEmprestado = qtde_emprestado;
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
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((idLivro == null) ? 0 : idLivro.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((paginas == null) ? 0 : paginas.hashCode());
		result = prime * result + ((qtdeEmprestado == null) ? 0 : qtdeEmprestado.hashCode());
		result = prime * result + ((qtdeEstoque == null) ? 0 : qtdeEstoque.hashCode());
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
		Livro other = (Livro) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (idLivro == null) {
			if (other.idLivro != null)
				return false;
		} else if (!idLivro.equals(other.idLivro))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (paginas == null) {
			if (other.paginas != null)
				return false;
		} else if (!paginas.equals(other.paginas))
			return false;
		if (qtdeEmprestado == null) {
			if (other.qtdeEmprestado != null)
				return false;
		} else if (!qtdeEmprestado.equals(other.qtdeEmprestado))
			return false;
		if (qtdeEstoque == null) {
			if (other.qtdeEstoque != null)
				return false;
		} else if (!qtdeEstoque.equals(other.qtdeEstoque))
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
		return "Livro [idLivro=" + idLivro + ", nome=" + nome + ", autor=" + autor + ", paginas=" + paginas
				+ ", qtdeEstoque=" + qtdeEstoque + ", qtdeEmprestado=" + qtdeEmprestado + ", status=" + status + "]";
	}
	
}
