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
	private Integer id_livro;
	@Column(nullable=false)
	private String nome_livro;
	@Column(nullable=false)
	private String autor_livro;
	@Column(nullable=false)
	private Integer paginas_livro;
	
	public Livro() {
	}

	public Integer getId() {
		return id_livro;
	}

	public void setId(Integer id) {
		this.id_livro = id;
	}

	public String getNome() {
		return nome_livro;
	}

	public void setNome(String nome) {
		this.nome_livro = nome;
	}

	public String getAutor() {
		return autor_livro;
	}

	public void setAutor(String autor) {
		this.autor_livro = autor;
	}

	public Integer getPaginas() {
		return paginas_livro;
	}

	public void setPaginas(Integer paginas) {
		this.paginas_livro = paginas;
	}

	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor_livro == null) ? 0 : autor_livro.hashCode());
		result = prime * result + ((id_livro == null) ? 0 : id_livro.hashCode());
		result = prime * result + ((nome_livro == null) ? 0 : nome_livro.hashCode());
		result = prime * result + ((paginas_livro == null) ? 0 : paginas_livro.hashCode());
		return result;
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (autor_livro == null) {
			if (other.autor_livro != null)
				return false;
		} else if (!autor_livro.equals(other.autor_livro))
			return false;
		if (id_livro == null) {
			if (other.id_livro != null)
				return false;
		} else if (!id_livro.equals(other.id_livro))
			return false;
		if (nome_livro == null) {
			if (other.nome_livro != null)
				return false;
		} else if (!nome_livro.equals(other.nome_livro))
			return false;
		if (paginas_livro == null) {
			if (other.paginas_livro != null)
				return false;
		} else if (!paginas_livro.equals(other.paginas_livro))
			return false;
		return true;
	}

}
